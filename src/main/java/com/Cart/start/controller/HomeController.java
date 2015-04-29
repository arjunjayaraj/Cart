package com.Cart.start.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Cart.start.dao.UsersDAO;
import com.Cart.start.manager.UsersManager;
import com.Cart.start.model.Users;
import com.Cart.start.model.studentInfo;


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
		studentInfo stud = new studentInfo();
		
		stud.setName("JG3");
		
		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		session.save(stud);
		
		session.getTransaction().commit();
		session.close();
		return model;

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
	
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public ModelAndView login(@RequestParam(value="myArray") String myArray)
//							 
	

		ModelAndView model = new ModelAndView();
		
//		UserObj userObj1=new UserObj();
//		userObj1.setFirstName("myArray");
//		userObj1.setLastName("lastName");
//		userObj1.setEmail("username");
//		userObj1.setPassword("username");
//		
//		userObj1.setRole("password");
//		
//		
//		
//		UserDAO userDAO=new UserDAO();
//		userDAO.openCurrentSessionwithTransaction();
//		userDAO.save(userObj1);
//		userDAO.closeCurrentSessionwithTransaction();
//		
//		
//		
//		
//		if (error != null) {
//			model.addObject("error", "Invalid username and password!");
//		}
//
//		if (logout != null) {
//			model.addObject("msg", "You've been logged out successfully.");
//		}
		model.setViewName("login");

		return model;

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("registerForm") Users user,
			@RequestParam("confirm-password") String confirmPassword) {
		
		UsersDAO checkUser=new UsersDAO();
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("login");
		
		String email=user.getEmail();
		UsersManager userManager = new UsersManager();
		//Users userObj=checkUser.findById(email);
		Boolean flagSave=true;
	
//		 if(userManager.isPresent(email)){
//			flagSave=false;
//			modelView.addObject("error", "Email already exists!!");
//		}
//		 else if (!(user.getPasswd().equals(confirmPassword))) {
//				flagSave=false;
//				modelView.addObject("error", "Password Mismatch!!");		
//				
//			} 
			
		if(flagSave==true){
			userManager.persist(user);
			modelView.addObject("error", "Registered Successfully!!");
		}
		return modelView;
	}

}