package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;

@EnableTransactionManagement
@Repository("productDAO")  //marks the specific class as a data access object

public class ProductDAOImpl implements ProductDAO{  //this class implements the ProductDAO class
	
	
	@Autowired  // to inject dependency at run time by spring.it connects to the ProductDAOimpl
	private SessionFactory sessionFactory;
	// Session Factory is not a singleton.it creates the session objects
	
	public ProductDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
		//this keyword is used to refer current class instance variable
	}
	@Transactional// it defines the scope of single database transaction.the database transaction happens inside the scope of persistence context 
	
	public boolean save(Product product){ //for saving the product
		try {
			sessionFactory.getCurrentSession().save(product);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public boolean update(Product product){  //for updating the product
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	/*@Transactional
	public boolean delete(Product product){
		try {
			sessionFactory.getCurrentSession().delete(product);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}*/
	@Transactional
	public void delete(int id)  // to delete the product
	{
		Product ProductToDelete = new Product();
		ProductToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(ProductToDelete);
	}
	@Transactional
	public Product get(int id){
		
		String hql = "from Product where id = "+"'"+id+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> list = query.list();
		
		if(list==null || list.isEmpty()){
			return null;
		}
		else {
		return list.get(0);
			
		}
	}
	@Transactional
	public List<Product> list(){
		
		String hql = "from Product";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	
	}
	
	
	
	
	
}