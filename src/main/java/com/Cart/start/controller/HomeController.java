package com.Cart.start.controller;

import java.text.ParseException;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.Cart.start.dao.UsersDAO;
import com.Cart.start.manager.UsersManager;
import com.Cart.start.model.Users;
import com.Cart.start.model.studentInfo;


//import com.Cart.start.dao.UsersDAO;
//import com.Cart.start.manager.UsersManager;
//import com.Cart.start.model.Users;
//import com.Cart.start.model.studentInfo;



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


		ModelAndView model = new ModelAndView();
		model.setViewName("login");

		return model;

	}

	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("registerForm") Users user,
			@RequestParam("confirm-password") String confirmPassword) {

		UsersDAO checkUser=new UsersDAO();
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("login");

		UsersManager userManager = new UsersManager();
		Boolean flagSave=true;
		
		if (!(user.getPasswd().equals(confirmPassword))) {
			flagSave=false;
			modelView.addObject("error", "Password Mismatch!!");		
			
		} 
	
		else if((userManager.isPresent(user.getEmail()))){
			flagSave=false;
			modelView.addObject("error","Email already exists!!!");
		}
//	
		if(flagSave==true){
			userManager.persist(user);
			modelView.addObject("error", "Registered Successfully!!");
		}
		return modelView;
	}
	
	/*@RequestMapping(value = "/register", method = RequestMethod.GET)
	public  @ResponseBody ModelAndView register(
			@RequestParam("fName") String fName,
			@RequestParam("lName") String lName,
			@RequestParam("email") String email,
			@RequestParam("passwd") String passwd,
			@RequestParam("errorMsg") String errorMsg){
		System.out.println("**********************"+errorMsg+"***************************");
		UsersDAO checkUser=new UsersDAO();
		ModelAndView modelView = new ModelAndView();
		
		Users user =new Users();
		user.setfName(fName);
		user.setlName(lName);
		user.setEmail(email);
		user.setPasswd(passwd);
		
		UsersManager userManager = new UsersManager();
		
		Boolean flagSave=true;

		
//		 if(userManager.isPresent(email)){
//			flagSave=false;
		if(errorMsg!=""){
			modelView.addObject("error",errorMsg);
			flagSave=false;
		}
			
//		
		if(flagSave==true){
			userManager.persist(user);
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