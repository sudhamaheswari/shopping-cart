package com.niit.shoppingcart.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.Product;

@Repository

public interface ProductDAO {  ////it is an interface class we will do CRUD operations through this ...we just write the methods but they are not implementing 


	public boolean save(Product product); ////we can save and update the particular user through this methods
	
	public boolean update(Product product);
	
	public void delete(int id); // to delete an particular user
	
	public Product get(int id);
	
	public List<Product> list();  //it will get the list of login users
		
	
	
}