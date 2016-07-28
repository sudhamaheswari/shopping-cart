package com.niit.ShoppingCart;

import java.util.List;

public class Supplier {

	private String id;
	private String name;
	private String address;
	private Product product;
	
	
          private List<Product>products;
	

	public Supplier(String id, String name, String address, Product product, List<Product> products) {
			this.id = id;
			this.name = name;
			this.address = address;
			this.product = product;
			this.products = products;
		}


	public String getId() {
		return id;	
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}


	
}
