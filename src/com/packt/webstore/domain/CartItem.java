package com.packt.webstore.domain;

import java.math.BigDecimal;

public class CartItem {
	private Product product;
	private int quantity;
	private BigDecimal totalPrice;
	
	public CartItem(){
		
	}
	
	public CartItem(Product product){
		super();
		this.setProduct(product);
		this.setQuantity(1);
		this.setTotalPrice(product.getUnitPrice());
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
		this.updateTotalPrice();
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
		this.updateTotalPrice();
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	private void updateTotalPrice() {
		totalPrice = this.product.getUnitPrice().multiply(new BigDecimal(this.quantity));
		
	}
	
	@Override
	public int hashCode(){
		final int prime = 311;
		int result = 1;
		result = prime*result + ((product == null)? 0 : product.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		CartItem other = (CartItem) obj;
		
		if(product == null){
			if(other.product != null)
				return false;
		}else if(!product.equals(other.product)){
			return false;
		}
		
		return true;
	}
}
