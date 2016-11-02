package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Login;

@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO {
	public List<Login> list1() {
		return null;
	}

	@Autowired
	private SessionFactory sessionFactory;

	public LoginDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void save(Login login) {
		sessionFactory.getCurrentSession().save(login);

	}

	@Transactional
	public void update(Login login) {
		sessionFactory.getCurrentSession().update(login);

	}

	@Transactional
	public void delete(int id) {
		Login UserToDelete = new Login();
		UserToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(UserToDelete);
	}

	@Transactional
	public List getAllUsers() {  //through this method we can get the list of all login users

		Session session=sessionFactory.openSession();
		List listlogin=session.createQuery("from User").list();
		session.close();
		return listlogin;
		}


	@Transactional
	public Login get(int id) {
		// sessionFactory.getCurrentSession().get(User.class,id);
		String hql = "from User where Id=" + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Login> listUser = query.list();
		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		return null;
	}
	@Transactional
	public Login getSingleUser(int id) {  //to get a single user at a time
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();  //always opens a new session that you have to close once you are done with the operations.
		Login login=(Login)session.load(Login.class, id);
		return login;
		}
	@Transactional
	public List<Login> list() {
		@SuppressWarnings("unchecked") //Indicates that the named compiler warnings 
		List<Login> list = (List<Login>) sessionFactory.getCurrentSession()
				.createCriteria(Login.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return list;
	}
}