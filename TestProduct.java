package com.niit.ShoppingCart;

public class TestProduct {

	public static void main(String[] args) {
		
		
       Product p1 = new Product(101, "iphone",65_000);
       Product p2 = new Product(102, "tv",45_000);
       
   
       System.out.println("ID:"+p1.getId());
       System.out.println("Name:"+ p1.getName());
       System.out.println("Price:"+ p1.getprice());
       
       System.out.println("ID:" +p2.getId());
       System.out.println("Name:" +p2.getName());
       System.out.println("Price:" +p2.getprice());
	}

}
