package com.Cart.start.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Cart.start.dao.UsersDAO;
import com.Cart.start.manager.UsersManager;
import com.Cart.start.model.Users;


@Controller
public class HomeController {

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

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
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

		UsersDAO checkUser=new UsersDAO();
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("login");
		
		UsersManager userManager = new UsersManager();
		Boolean flagSave=true;
		
		if (!(user.getPassword().equals(confirmPassword))) {
			flagSave=false;
			modelView.addObject("error", "Password Mismatch!!");		
			
		} 
	
		else if((userManager.isPresent(user.getUsername()))){
			flagSave=false;
			modelView.addObject("error","Email already exists!!!");
		}
		
		if(flagSave==true){
			userManager.save(user);
			modelView.addObject("error", "Registered Successfully!!");
		}
		return modelView;
	}
/*
		
//		 if(userManager.isPresent(email)){
//			flagSave=false;
		if(errorMsg!=""){
			modelView.addObject("error",errorMsg);
			flagSave=false;
		}
			
//		
		if(flagSave==true){
			userManager.save(user);
			modelView.addObject("error", "Registered Successfully!!");
		}
		modelView.setViewName("login");
		return modelView;
	}*/
	
	/*@RequestMapping(value = "/register", method = RequestMethod.GET)
	public  @ResponseBody ModelAndView controllerMethod(@ModelAttribute(value="myData") Users myData) throws ParseException {
		System.out.println("************************************************");
		
		ModelAndView modelView = new ModelAndView();
		UsersManager userManager = new UsersManager();
		userManager.persist(myData);
		modelView.addObject("error", "Registered Successfully!!");
		modelView.setViewName("login");
		return modelView;
	}*/

}