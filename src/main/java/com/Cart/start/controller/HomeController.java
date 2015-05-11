package com.Cart.start.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Cart.start.model.Users;
import com.Cart.start.service.ProductService;
import com.Cart.start.service.UsersService;
import com.Cart.start.model.Products;
import com.Cart.start.model.Category;
import javax.persistence.GeneratedValue;


@Controller
public class HomeController {
	
	@Autowired(required = true)
	@Qualifier(value = "productService")
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@Autowired(required = true)
	@Qualifier(value = "usersService")
	private UsersService usersService;
	public void setUsersService(UsersService us) {
		this.usersService = us;
	}

	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {

		ModelAndView model = new ModelAndView();
		model.setViewName("home");
		return model;

	}

	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public ModelAndView homePage() {

		ModelAndView model = new ModelAndView();
		model.setViewName("home");
		return model;

	}

	@RequestMapping(value = { "/adminLogin" }, method = RequestMethod.GET)
	public ModelAndView adminLoginPage() {

		ModelAndView model = new ModelAndView();
		model.setViewName("adminLogin");
		return model;

	}

	@RequestMapping(value = { "/adminHome" }, method = RequestMethod.GET)
	public ModelAndView adminHomePage() {

		ModelAndView model = new ModelAndView();
		model.setViewName("adminHome");
		return model;

	}
	@RequestMapping(value = { "/addNewProduct" }, method = RequestMethod.GET)
	public ModelAndView addNewProductPage() {

		ModelAndView model = new ModelAndView();
		model.setViewName("addNewProduct");
		return model;

	}
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is protected page!");
		model.setViewName("admin");
		return model;

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@ModelAttribute Users users,
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("login");

		return model;

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute Users user,
			@RequestParam("confirm-password") String confirmPassword) {
		ModelAndView modelView = new ModelAndView();

		Boolean flagSave = true;

		if (!(user.getPassword().equals(confirmPassword))) {
			flagSave = false;
			modelView.addObject("error", "Password Mismatch!!");
			modelView.setViewName("login");

		}
		if (flagSave == true) {
			try{
			this.usersService.addUser(user);
			modelView.addObject("error", "Registered Successfully!!");
			modelView.setViewName("login");
			}
			catch (Exception e){
				 e.printStackTrace();
				 modelView.addObject("error", "Already Registerd in same Email!!");
				 modelView.addObject("forgot_password", "Forgot Password?");
				 modelView.setViewName("login");
			}
		}
		return modelView;
	}
	
	@RequestMapping(value = "/pr")
	public ModelAndView product(){
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("product");
			return modelView;
	}
	
	@RequestMapping(value = "/product" )
	public ModelAndView productAdd(@ModelAttribute("product") Products product){
		ModelAndView modelView = new ModelAndView();

//		Products product =new Products();
		//product.setProductId(3);
//		product.setBrand("addidas");
//		product.setProductName("asdsdasdadf");
//		product.setProductPrice(500);
//		product.setQuantity(8);
//		product.setProductImage("asdas");
//		Category category1 = new Category();
//		category1.setCategoryName("shoe");
//		product.setCategory(category1);
		
			this.productService.addProduct(product);
			modelView.setViewName("home");
			return modelView;
	}

}