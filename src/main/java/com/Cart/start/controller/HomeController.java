package com.Cart.start.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Cart.start.dao.UsersDAO;
import com.Cart.start.manager.UsersManager;
import com.Cart.start.model.Users;
import com.Cart.start.service.UsersService;


@Controller
public class HomeController {
	   private UsersService userService;
	     
	    @Autowired(required=true)
	    @Qualifier(value="userService")
	    public void setPersonService(UsersService us){
	        this.userService = us;
	    }
	    
	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is welcome page!");
		model.setViewName("home");
		return model;

	}
	@RequestMapping(value = {"/home" }, method = RequestMethod.GET)
	public ModelAndView homePage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is welcome page!");
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
	public ModelAndView login(@ModelAttribute Users users,@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("login");

		return model;

	}
	
	@RequestMapping("/loginno")
	public ModelAndView getLoginForm(@ModelAttribute Users users,
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		String message = "";
		if (error != null) {
			message = "Incorrect username or password !";
		} else if (logout != null) {
			message = "Logout successful !";
		}
		return new ModelAndView("loginno", "message", message);
	}

	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("registerForm") Users user,
			@RequestParam("confirm-password") String confirmPassword) {
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("home");
		Boolean flagSave=true;

	if (!(user.getPassword().equals(confirmPassword))) {
		flagSave=false;
		modelView.addObject("error", "Password Mismatch!!");		
			
		} 
		if(flagSave==true){
			this.userService.addUser(user);
			modelView.addObject("error", "Registered Successfully!!");
		}
		user=null;
		return modelView;
	}

}