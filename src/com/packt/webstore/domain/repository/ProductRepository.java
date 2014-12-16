package com.packt.webstore.domain.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.packt.webstore.domain.Product;

public interface ProductRepository {
	List<Product> getAllProducts();
	List<Product> getProductsByCategory(String category);
	Product getProductById(String productid);
	Set<Product> getProductsByFiler(Map<String, List<String>> filterParams);
	void addProduct(Product product);
}
