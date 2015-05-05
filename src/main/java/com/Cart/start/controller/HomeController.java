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
import com.Cart.start.service.UsersService;

@Controller
public class HomeController {
	
	private UsersService usersService;

	@Autowired(required = true)
	@Qualifier(value = "usersService")
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

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
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

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("registerForm") Users user,
			@RequestParam("confirm-password") String confirmPassword) {
		ModelAndView modelView = new ModelAndView();

		Boolean flagSave = true;

		if (!(user.getPassword().equals(confirmPassword))) {
			flagSave = false;
			modelView.addObject("error", "Password Mismatch!!");
			modelView.setViewName("login");

		}
		if (flagSave == true) {
			this.usersService.addUser(user);
			modelView.addObject("error", "Registered Successfully!!");
			modelView.setViewName("home");
		}
		return modelView;
	}

}