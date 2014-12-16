package com.packt.webstore.exception;


//@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No product found!")
public class ProductNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -4940652196131005577L;
	
	private String productId;
	
	public ProductNotFoundException(String productId){
		this.setProductId(productId);
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

}
