package com.niit.shoppingcart;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;

@Controller
public class ProductController {

	@Autowired  //it will connects with ProductDAO with below object
	ProductDAO pd;
	@Autowired
	SupplierDAO sd;

	@ModelAttribute("Product")  //@ModelAttribute refers to a property of the Model object (the M in MVC ;). @ModelAttribute is a Spring-MVC specific annotation used for preparing the model data. It is also used to define the command object that would be bound with the HTTP request data. The annotation works only if the class is a Controller class (i.e. annotated with @Controller).
	public Product createProduct() 
	{
		
    return new Product();
	}
@RequestMapping("addproduct")
	public ModelAndView display3() {

		ModelAndView mv3 = new ModelAndView("addproduct");  //it will read the addProduct.jsp(name should be same as jsp)

		mv3.addObject("supplier", new Supplier());  //we are adding the products to the particular supplier
        List suppliers= sd.list();  //it will show the list of suppliers
        mv3.addObject("suppliers", suppliers);
        return mv3;
	}
@RequestMapping("storeproduct")
	public String addproduct(HttpServletRequest request, @Valid @ModelAttribute("Product") Product product,BindingResult result) {
		if (result.hasErrors()) {
			return "addproduct";
		}
		String filename = product.getImg().getOriginalFilename();  //to store the product image
		product.setImage(filename);

		try {
			byte[] bytes = new byte[product.getImg().getInputStream().available()];
			product.getImg().getInputStream().read(bytes);
			BufferedInputStream buffer = new BufferedInputStream(product.getImg().getInputStream());
			MultipartFile file = product.getImg();
			String path = request.getServletContext().getRealPath("/") + "resources/images";
			File rootPath = new File(path);
			if (!rootPath.exists())
				rootPath.mkdirs();
			File store = new File(rootPath.getAbsolutePath() + "/" + filename);
			System.out.println("Image path :" + path);
			OutputStream os = new FileOutputStream(store);
			os.write(bytes);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		pd.save(product);
		return "addproduct";

	}

@RequestMapping("ManageProduct")
public ModelAndView display11() {
	ModelAndView m10 = new ModelAndView("ManageProduct");
	return m10;
}

@RequestMapping(value = "list", method = RequestMethod.GET, produces = "application/json")
public @ResponseBody String showList()
{
	List list = pd.list();
	Gson x = new Gson();  //Gson is a Java library that can be used to convert Java Objects into their JSON representation.
	//It can also be used to convert a JSON string to an equivalent Java object.
	String json = x.toJson(list);
	return json;
}
@RequestMapping("/viewproduct")
public ModelAndView display8() {
	ModelAndView m4 = new ModelAndView("viewproduct");
	return m4;
}
@RequestMapping("/ShowProducts")
public ModelAndView display6() {
	ModelAndView m4 = new ModelAndView("ShowProducts");
	return m4;
}
@RequestMapping("/viewproductuser")
public ModelAndView display10() {
	ModelAndView m4 = new ModelAndView("viewproductuser");
	return m4;
}
@RequestMapping("/ShowProductuser")
public ModelAndView display13() {
	ModelAndView m4 = new ModelAndView("ShowProductuser");
	return m4;
}

@RequestMapping("/delete")
public ModelAndView deleteProduct(@RequestParam int id) {
	pd.delete(id);
	ModelAndView m1 = new ModelAndView("ManageProduct");
	return m1;
}
@ModelAttribute ("Product")
public ModelAndView display9(){
	ModelAndView m9 = new ModelAndView("Product");
	return m9;
}
	@RequestMapping(value = "viewproduct", method = RequestMethod.GET)
	public ModelAndView viewPro(@RequestParam int id, @ModelAttribute Product products) {
		Product product = pd.get(id);
		return new ModelAndView("viewproduct", "product", product);
	}
	
	@RequestMapping(value = "ShowProducts", method = RequestMethod.GET)
	public ModelAndView viewPros(@RequestParam int id, @ModelAttribute Product products) {
		Product product = pd.get(id);
		return new ModelAndView("ShowProducts", "product", product);
	}
	
	@RequestMapping(value = "viewproductuser", method = RequestMethod.GET)
	public ModelAndView viewProuser(@RequestParam int id, @ModelAttribute Product products) {
		Product product = pd.get(id);
		return new ModelAndView("viewproductuser", "product", product);
	}
	
	@RequestMapping(value = "ShowProductsuser", method = RequestMethod.GET)
	public ModelAndView viewProuser1(@RequestParam int id, @ModelAttribute Product products) {
		Product product = pd.get(id);
		return new ModelAndView("ShowProductsuser", "product", product);
	}
	 
	 

	@RequestMapping("editproduct")
	public ModelAndView display15() {
		ModelAndView m6 = new ModelAndView("editproduct");
		return m6;

	}		 		 
 @RequestMapping(value="editproduct",method=RequestMethod.GET)
    public ModelAndView editPro(@RequestParam int id){
	 Product product1=pd.get(id);
    	return new ModelAndView("editproduct","Product",product1);
    }

 @RequestMapping(value="/update",method=RequestMethod.POST)
 public ModelAndView updateProduct(HttpServletRequest request,@Valid @ModelAttribute("Product")Product product,BindingResult result)
 {
 	
 	String filename=product.getImg().getOriginalFilename();
 	
 	product.setImage(filename);
	
 	try{
		byte[] bytes=new byte[product.getImg().getInputStream().available()];
		product.getImg().getInputStream().read(bytes);
		BufferedInputStream buffer=new BufferedInputStream(product.getImg().getInputStream());
		MultipartFile file=product.getImg();
		String path=request.getServletContext().getRealPath("/")+"resources/images";
		File rootPath=new File(path);
		if(!rootPath.exists())
			rootPath.mkdirs();
		File store=new File(rootPath.getAbsolutePath()+"/"+filename);
		System.out.println("Image path :"+path);
		OutputStream os=new FileOutputStream(store);
		os.write(bytes);
	}
	catch(Exception e){
		System.out.println(e.getMessage());
	}
		        
 	pd.update(product);
 	return new ModelAndView("ManageProduct");
 }	 


	@RequestMapping("Products")
	public ModelAndView display20() {
		ModelAndView m6 = new ModelAndView("Products");
		return m6;

	}		 

	
	}
