package com.niit.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class TextSupplier {

	public static void main(String[] args) {
   
		Product p1=new Product(101,"iphone",70_000);
		Product p2=new Product(102,"intex",60_000);
		
		Supplier s1=new Supplier("S500","intex","Delhi", p1,null);
	
		List<Product>ProductList=new ArrayList<Product>();
		ProductList.add(p1);
		ProductList.add(p2);
		
		
		s1.setProducts(ProductList);
		System.out.println("the details:");
		System.out.println(s1.getId());
		System.out.println(s1.getName());
		System.out.println(s1.getAddress());
		
		
		System.out.println(p1.getId());
		System.out.println(p1.getName());
		System.out.println(p1.getprice());
		
		System.out.println(p2.getId());
		System.out.println(p2.getName());
		System.out.println(p2.getprice());
		
		
		
	}

}
