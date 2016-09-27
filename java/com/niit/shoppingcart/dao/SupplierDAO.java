package com.niit.shoppingcart.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.Supplier;

@Repository

public interface SupplierDAO {

	public boolean save(Supplier supplier);
	
	public boolean update(Supplier supplier);
	
	public void delete(int id);
	
	public Supplier get(int id);
	
	public List<Supplier> list();
		
	
	
}