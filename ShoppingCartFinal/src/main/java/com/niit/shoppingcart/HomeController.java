package com.niit.shoppingcart;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.LoginDAO;
import com.niit.shoppingcart.dao.UserDetailsDAO;
import com.niit.shoppingcart.model.Login;
import com.niit.shoppingcart.model.UserDetails;

@Controller

public class HomeController {
	
	@Autowired
	UserDetailsDAO ud;

	@Autowired
	LoginDAO ld;
	@RequestMapping("/")
	public ModelAndView home()
	{
		ModelAndView m1 = new ModelAndView("Home");
		//mv.addObject("message", "Thank you for visiting this URL");
		return m1;
	}
	
	
	@RequestMapping("/reg")
	public ModelAndView regi()
	{
		ModelAndView m1 = new ModelAndView("Register");
		//mv.addObject("user ClickedRegisterHere", "True");
		return m1;
	}
	@ModelAttribute("UserDetails")
	public UserDetails registerUser(){
		return new UserDetails();
		
	}
	
	@RequestMapping(value = "storeUser", method = RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute("UserDetails") UserDetails registeruser,BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Errors");
			return "register";
		}
		System.out.println(registeruser.getUsername());
		ud.save(registeruser);
		Login loginuser = new Login();
		loginuser.setId(registeruser.getId());
		loginuser.setUsername(registeruser.getUsername());
		loginuser.setPassword(registeruser.getPassword());
		loginuser.setStatus(registeruser.isStatus());
		ld.save(loginuser);
		return "register";
	}
	
}
