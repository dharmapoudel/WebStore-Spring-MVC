package com.packt.webstore.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	@Qualifier("OutMemory")
	private ProductRepository productRepository;
	
	@Override
	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}

	@Override
	public List<Product> getProductsByCategory(String category) {
		
		return productRepository.getProductsByCategory(category);
	}

	@Override
	public Set<Product> getProductsByfilter(
			Map<String, List<String>> filterParams) {
		return productRepository.getProductsByFiler(filterParams);
	}

	@Override
	public Product getProductById(String productId) {
		return productRepository.getProductById(productId);
	}

	@Override
	public void addProduct(Product product) {
		productRepository.addProduct(product);
		
	}
	
	public String getFileExtension(String fileName){
		
		if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
	        return fileName.substring(fileName.lastIndexOf(".")+1);
		else
			return "";
	}
}
