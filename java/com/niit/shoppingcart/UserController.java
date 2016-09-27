package com.niit.shoppingcart;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.niit.shoppingcart.dao.LoginDAO;
import com.niit.shoppingcart.dao.UserDetailsDAO;
/*import com.niit.shoppingcart.DAO.LoginDAO;
import com.niit.ShoppingCart.DAO.UserDetailsDAO;
import com.niit.ShoppingCart.model.Login;
import com.niit.ShoppingCart.model.UserDetails;*/
import com.niit.shoppingcart.model.UserDetails;

@Controller
public class UserController {

	@Autowired
	UserDetailsDAO registerdao;
	@Autowired
	LoginDAO logindao;
	

	@RequestMapping(value = "/fail2login", method = RequestMethod.GET)
	public ModelAndView loginerror(ModelMap model) {
		return new ModelAndView("Login", "error", true);
	}

		
	@ModelAttribute("UserDetails")
	public UserDetails registerUser() {
		return new UserDetails();

	}

	
	

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView checkUserOne(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws Exception {
		if (request.isUserInRole("ROLE_ADMIN")) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String str = auth.getName(); // get username
			session = request.getSession(true);
			session.setAttribute("loggedInUser", str);
			// session.invalidate();
			ModelAndView m1 = new ModelAndView("Admin");
			return m1;
		}
		else
		{
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String str = auth.getName();
			session = request.getSession(true);
			session.setAttribute("loggedInUser", str);
			ModelAndView m2 = new ModelAndView("ManageProduct");
			return m2;
		}
		
	}
	
		
	
	

}

