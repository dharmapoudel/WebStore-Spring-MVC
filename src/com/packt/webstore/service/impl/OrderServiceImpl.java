package com.packt.webstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	@Qualifier("OutMemory")
	private ProductRepository productRepository;

	public void processOrder(String productId, long quantity) {
		Product productById = productRepository.getProductById(productId);

		if(productById.getUnitsInStock() < quantity){
			throw new IllegalArgumentException("Out of stock. Available units in stock is "+ productById.getUnitsInStock());
		}
		productById.setUnitsInStock(productById.getUnitsInStock()-quantity);
	}
}
