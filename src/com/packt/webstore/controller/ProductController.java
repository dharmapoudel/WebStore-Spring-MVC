package com.packt.webstore.controller;


import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.packt.webstore.domain.Product;
import com.packt.webstore.exception.NoProductsFoundUnderCategoryException;
import com.packt.webstore.exception.ProductNotFoundException;
import com.packt.webstore.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/product")
	public String getProductById(@RequestParam("id") String productId, Model model){
		Product p = productService.getProductById(productId);
		model.addAttribute("product", p);
		return "product";
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req, ProductNotFoundException exception){
		ModelAndView mav = new ModelAndView();
		mav.addObject("invalidProductId", exception.getProductId());
		mav.addObject("exception", exception);
		mav.addObject("url", req.getRequestURL()+ "?"+req.getQueryString());
		mav.setViewName("productNotFound");
		return mav;
	}
	
	@RequestMapping
	public String list(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}
	
	@RequestMapping("/all")
	public String allProducts(Model model){
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}
	
	@RequestMapping("/{category}")
	public String getProductsByCategory(Model model, @PathVariable("category") String productCategory){
		List<Product> products = productService.getProductsByCategory(productCategory);
		if (products == null || products.isEmpty()) {
			throw new NoProductsFoundUnderCategoryException();
		}
		model.addAttribute("products", products);
		return "products";
	}
	@RequestMapping("/filter/{ByCriteria}")
	public String getProductsByFilter(@MatrixVariable(pathVar="ByCriteria") Map<String, List<String>> filterParams, Model model){
		model.addAttribute("products", productService.getProductsByfilter(filterParams));
		return "products";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewProductForm(Model model){
		Product newProduct = new Product();
		model.addAttribute("newProduct", newProduct);
		return "addProduct";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") Product newProduct, 
			BindingResult result, HttpServletRequest request){
		
		String[] supressedFields = result.getSuppressedFields();
		if(supressedFields.length > 0){
			throw new RuntimeException("Attempting to bind disallowed fields:"+ StringUtils.arrayToCommaDelimitedString(supressedFields));
		}
		
		MultipartFile productImage = newProduct.getProductImage();
		String fileName = productImage.getOriginalFilename();
		
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		
		if(productImage != null && !productImage.isEmpty()){
			try{
				File file = new File(rootDirectory+"\\WEB-INF\\resources\\images\\"+newProduct.getProductId()+"."+
								productService.getFileExtension(fileName));
				productImage.transferTo(file);
			} catch( Exception e){
				throw new RuntimeException("Product Image saving failed!", e);
			}
		}
		newProduct.setImageSource(newProduct.getProductId()+"."+ productService.getFileExtension(fileName));
		productService.addProduct(newProduct);
		return "redirect:/products";
	}
	
	@InitBinder
	public void initializeBinder(WebDataBinder binder){
		binder.setDisallowedFields("unitsInOrder", "discontinued", "imageSource");
		binder.setAllowedFields("productId", "name", "unitPrice", "description", 
				"manufacturer", "category", "unitsInStock", "productImage", "condition");
	}
	
	@RequestMapping("/invalidPromoCode")
	public String invalidPromoCode(){
		return "invalidPromoCode";
	}
}
