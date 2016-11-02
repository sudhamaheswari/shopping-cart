package com.niit.shoppingcart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.LoginDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.dao.UserDetailsDAO;
import com.niit.shoppingcart.model.Login;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.UserDetails;

@Controller   //defines the class as a spring mvc controller

public class HomeController {   
	
	@Autowired  //to inject the dependency at run time using spring
	UserDetailsDAO ud;//reference variable is created for UserDetailsDAO class and connects with the SupplierDAO interface

	@Autowired  
	LoginDAO ld; 
	
	@Autowired 
	SupplierDAO sd;
	
	@RequestMapping("/")  //used to map web requests on to specific handler methods or classes
	public ModelAndView home() //method which will read the pojo and jsp files
	{
		ModelAndView m1 = new ModelAndView("Home");  //used to pass the respected jsp pages
		
		return m1; //object m1 is returned
	}
	
	
	@RequestMapping("/reg") 
	public ModelAndView regi()
	{
		ModelAndView m1 = new ModelAndView("Register"); //used to pass the respected jsp pages
		
		return m1;
	}
	@RequestMapping("Login")
	public ModelAndView Login()
	{
		ModelAndView m1 = new ModelAndView("Login");
		return m1;
	}
	
	@ModelAttribute("UserDetails")  //@ModelAttribute refers to a property of the Model object (the M in MVC ;). @ModelAttribute is a Spring-MVC specific annotation used for preparing the model data. It is also used to define the command object that would be bound with the HTTP request data. The annotation works only if the class is a Controller class (i.e. annotated with @Controller).
	public UserDetails registerUser(){
		return new UserDetails();  //it will returns the object of model class
		
	}
	@ModelAttribute("Supplier")
	public Supplier sup(){
		return new Supplier();
		
	}
	@RequestMapping("addSupplier")
	public ModelAndView display3() {

		ModelAndView mv3 = new ModelAndView("addSupplier");
		return mv3;
	}

	@RequestMapping(value = "storeUser", method = RequestMethod.POST) //to provide the Url pattern for which handler method will be used ,even though request URI remains same. We can use @RequestMapping method variable to narrow down the HTTP methods for which this method will be invoked. 
	public String addUser(@Valid @ModelAttribute("UserDetails") UserDetails registeruser,BindingResult result)//valid is common to validate a model after binding user input to it,
	//binding result is used to hold the result of validation and binding and contains errors that may have occured
	{
		if (result.hasErrors()) {// if any error will occur while registering it will gives the error and returns back to the register page
			System.out.println("Errors");
			return "Register";
		}
		System.out.println(registeruser.getUsername());// if no errors then user details will be saved
		ud.save(registeruser); //it will save the user in the database
		Login loginuser = new Login();// login object is created and the following data will move in to the login table 
		loginuser.setId(registeruser.getId());//values are set and retrieved 
		loginuser.setUsername(registeruser.getUsername());
		loginuser.setPassword(registeruser.getPassword());
		loginuser.setStatus(registeruser.getStatus());//which shows  the statues either admin or user
		ld.save(loginuser);//login details of user successfully stored into the login table
		return "Home";  //when user is successfully login it will return to the home page
	}
	
    @ModelAttribute("Login")  // it is the property of model (pojo) class object
    public Login createuser(){
    	return new Login();
    }
    
    @RequestMapping("/checkuser")  //check user will checks the user whether registered or not
    public ModelAndView checkedUser(@Valid @ModelAttribute("Login")Login user,BindingResult result,@RequestParam("userName") String userName,@RequestParam("password")String password) //request param is used to specify the particular parameter
    { 
    	System.out.println("UserName is............."+userName);
    	System.out.println("Password is............."+password);  //print the user name and password
		return null;
    	
    }
    
    
    @RequestMapping("storesupplier")
	public String addBook(HttpServletRequest request, @Valid @ModelAttribute("Supplier") Supplier supplier,
			BindingResult result) {
		if (result.hasErrors()) {
			return "addSupplier";
		}
		sd.save(supplier);
		return "addSupplier";

	}
	
    @RequestMapping("Admin")
    public ModelAndView admin(){
    	return new ModelAndView("Admin");
    }
        @RequestMapping("Home")
    public ModelAndView sun(){
    	return new ModelAndView("Home");
    }
   
    @RequestMapping("logoutsuccess")
	public ModelAndView logoutpage(){
		ModelAndView mv9 = new ModelAndView("logoutsuccess");
		return mv9;
	}

	@RequestMapping(value = "/Logout", method = RequestMethod.GET)
	public void logout(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		//doGet() and doPost() methods throw javax.servlet.ServletException and IOException
		HttpSession newsession = request.getSession(false);
		//session is used to create the objects
		if (newsession != null) 
	    {   //not created yet
	         newsession.invalidate();

	    }
		response.sendRedirect("j_spring_security_logout");	
		}

	 @RequestMapping("Contactus")
		public ModelAndView contact(){
			ModelAndView mv9 = new ModelAndView("Contactus");
			return mv9;
		}

	 @RequestMapping("UserHome")
	    public ModelAndView son(){
	    	return new ModelAndView("UserHome");
	    }
	   
    
    
    
}