package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Login;

public interface LoginDAO {

	
	public List<Login> list();
	
	public Login get(int id);
	
	public Login getSingleUser(int id);
	
	public void save(Login login);
	
	public void update(Login login);
	
	public List getAllUsers();
	
	public void delete(int id);
}
