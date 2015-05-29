package com.Cart.start.controller;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;

import com.Cart.start.model.Cart;
import com.Cart.start.model.Category;
import com.Cart.start.model.Filter;
import com.Cart.start.model.Products;
import com.Cart.start.model.Users;
import com.Cart.start.service.CartService;
import com.Cart.start.service.CategoryService;
import com.Cart.start.service.ProductService;
import com.Cart.start.service.UsersService;

import enums.Roles;


@Controller
public class HomeController {
	
	@Autowired
	private UsersService usersService;
	public final void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	@Autowired
	private ProductService productService;
	public final void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@Autowired
	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@Autowired
	private CartService cartService;

	public final void setCartService(CartService cartService) {
		this.cartService = cartService;
	}
	
	/**
     * This is to covert org.springframework.web.multipart.commons.CommonsMultipartFile to
     * byte[] in HadoopConnection.java
     * @param binder
     */
    @InitBinder
    public void initBinderAll(WebDataBinder binder) {
        binder.registerCustomEditor(byte[].class,  new ByteArrayMultipartFileEditor());
    }
	
	
//				Main Home
	

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
	
//			Login & Register
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@ModelAttribute Users users,
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		
		ModelAndView model = new ModelAndView();
		model.addObject("loginTab", "active");
		model.addObject("registerTab", "");
		model.setViewName("login");

		return model;

	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute Users user,
			@RequestParam("confirm-password") String confirmPassword) {
		ModelAndView modelView = new ModelAndView();

		Boolean flagSave = true;

		if (!(user.getPassword().equals(confirmPassword))) {
			flagSave = false;
			modelView.addObject("error", "Password Mismatch!!");
			modelView.addObject("loginTab", "");
			modelView.addObject("registerTab", "active");
			modelView.setViewName("login");

		}
		if (flagSave == true) {
			try{
			this.usersService.addUser(user);
			modelView.addObject("error", "Registered Successfully!!");
			modelView.addObject("loginTab", "active");
			modelView.addObject("registerTab", "");
			modelView.setViewName("login");
			}
			catch (Exception e){
				 e.printStackTrace();
				 modelView.addObject("error", "Already Registerd in same Email!!");
				 modelView.addObject("forgot_password", "Forgot Password?");
				 modelView.addObject("loginTab", "");
				 modelView.addObject("registerTab", "active");
				 modelView.setViewName("login");
			}
		}
		return modelView;
	}
	
//			Admin Pages
	
	@RequestMapping(value = { "/adminHome" }, method = RequestMethod.GET)
	public ModelAndView adminHomePage() {

		ModelAndView model = new ModelAndView();
		model.setViewName("adminHome");
		return model;

	}
	@RequestMapping(value = { "/adminUsersControl" }, method = RequestMethod.GET)
	public ModelAndView adminUsersControl(@ModelAttribute Users user) {

		ModelAndView model = new ModelAndView();
		List<Users> allUsers= this.usersService.listUsers();
		System.out.println(allUsers);
		model.addObject("user", new Users());
		model.addObject("roles", Roles.values());
		model.addObject("listUsers", allUsers);
		model.setViewName("adminUsersControl");
		return model;

	}
	@RequestMapping(value = { "/adminProductsControl" }, method = RequestMethod.GET)
	public ModelAndView adminProductControl() {

		ModelAndView model = new ModelAndView();
		List<Products> listproducts = this.productService.listProducts();
		model.addObject("listproducts", listproducts);
		model.setViewName("adminProductControl");
		return model;

	}
	@RequestMapping(value = { "/adminAddRole" }, method = RequestMethod.GET)
	public @ResponseBody ModelAndView addRole(@RequestParam("email") String email,@RequestParam("role") String rol) {
		
		System.out.println(rol.toString());
		Roles role = Roles.valueOf(rol);
		this.usersService.addRole(email, role);
		ModelAndView model = new ModelAndView();
		model.setViewName("adminUsersControl");
		return model;
	}

	@RequestMapping(value = { "/adminDeleteRole" }, method = RequestMethod.GET)
	public @ResponseBody ModelAndView deleteRole(@RequestParam("email") String email,@RequestParam("role") String rol) {
		
		Roles role = Roles.valueOf(rol);
		this.usersService.deleteRole(email, role);
		ModelAndView model = new ModelAndView();
		model.setViewName("adminUsersControl");
		return model;
	}
	
	@RequestMapping(value = "/adminUserDelete", method = RequestMethod.GET)
	public @ResponseBody ModelAndView deleteUser(@RequestParam("email") String email) {

		ModelAndView model = new ModelAndView();
		this.usersService.removeUser(email);
		model.setViewName("adminUsersControl");
		return model;
	}
	
	@RequestMapping(value = "/adminEditUser", method = RequestMethod.POST)
	public @ResponseBody ModelAndView editUser(@RequestBody Users user) {
		
		ModelAndView model = new ModelAndView();
		this.usersService.updateUser(user);
		model.setViewName("adminUsersControl");
		return model;
	}
	@RequestMapping(value = "/adminEditUser", method = RequestMethod.GET)
	public @ResponseBody ModelAndView editUserWithKey(@RequestParam("user") String user,
					@RequestParam("curUser") String curUser) {
		
		ModelAndView model = new ModelAndView();
		Users editUser = new Users();
		ObjectMapper mapper = new ObjectMapper();
		try {
			editUser = mapper.readValue(user, Users.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.usersService.updateUserKey(editUser, curUser);
		model.setViewName("adminUsersControl");
		return model;
	}
	
//				PRODUCT PAGES

	@RequestMapping(value = "/product")
	public ModelAndView product(){
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("product");
		List<Products> listproducts = this.productService.listProducts();
		modelView.addObject("listproducts", listproducts);
		List<String> listbrand = this.productService.brands();
		modelView.addObject("listbrand", listbrand);
		List<String> listcategory = this.productService.categoryList();
		modelView.addObject("listcategory", listcategory);
		return modelView;
	}
	@RequestMapping(value="/productsearch",method = RequestMethod.GET)
	public  @ResponseBody ModelAndView productsearch(@RequestParam("searchproduct") String search, @RequestParam("category") String category){
		ModelAndView modelView = search(search,category);
		modelView.setViewName("search");
		return modelView;
		
	}
	public  ModelAndView search(String search,String agegroup){
		ModelAndView modelView = new ModelAndView();
		List<Products> listproducts = this.productService.searchByGenderAndProductName(search, agegroup);
		modelView.addObject("listproducts", listproducts);
		List<String> listbrand = this.productService.brands();
		modelView.addObject("listbrand", listbrand);
		List<Category> listcategory = this.categoryService.listCategory();
		modelView.addObject("listcategory", listcategory);
		return modelView;
	}
	
	@RequestMapping(value="/productSearch")
	public  ModelAndView productSearch(@RequestParam(value = "agegroup", required = false) String agegroup,@RequestParam("searchProduct") String search){
		System.out.println("inside search");
		ModelAndView modelView = search(search,agegroup);
		modelView.setViewName("product");
		return modelView;
		
	}
	@RequestMapping(value="product={agegroup}")
	public  ModelAndView productGroup(@PathVariable("agegroup") String ageGroup){
		String search="";
		ModelAndView modelView = search(search,ageGroup);
		modelView.setViewName("product");
		return modelView;
		
	}
	@RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	public ModelAndView productAdd(@ModelAttribute("product") Products products){
		ModelAndView modelView = new ModelAndView();
			this.productService.addProduct(products);
			modelView.setViewName("adminProductControl");
			return modelView;
	}
	@RequestMapping(value = "/adproduct", method = RequestMethod.POST)
	public @ResponseBody ModelAndView adproduct(@RequestBody Products product) {
		System.out.println(product);
		System.out.println("in ad product");
		ModelAndView model = new ModelAndView();
		this.productService.addProduct(product);
		model.setViewName("product");
		return model;
	}
	
	@RequestMapping(value = "/updateproduct", method = {RequestMethod.POST,RequestMethod.GET} )
	public ModelAndView productupdate(@ModelAttribute("product") Products product){
		ModelAndView modelView = new ModelAndView();
			this.productService.updateProduct(product);
			modelView.setViewName("home");
			return modelView;
	}

	@RequestMapping(value = "/upproduct", method = RequestMethod.POST)
	public @ResponseBody ModelAndView upproduct(@RequestBody Products product) {
		System.out.println(product);
		System.out.println("in ad product");
		ModelAndView model = new ModelAndView();
		this.productService.updateProduct(product);
		model.setViewName("product");
		return model;
	}
	
	@RequestMapping(value = "/removeproduct", method = RequestMethod.GET  )
	public ModelAndView productremove(@ModelAttribute("productName") String productName){
		ModelAndView modelView = new ModelAndView();
			this.productService.removeProduct(productName);
			modelView.setViewName("product");
			return modelView;
	}

	@RequestMapping(value = "/filter", method = RequestMethod.POST  )
	public @ResponseBody ModelAndView filterList(@RequestBody Filter filter) {
		ModelAndView modelView = new ModelAndView();
		System.out.println(filter.getCategory());
		List<Products> listproducts = this.productService.filterList(filter);
		modelView.addObject("listproducts", listproducts);
		modelView.setViewName("search");
		return modelView;
	
	}
	

	
	//				CART PAGES
	@RequestMapping(value = "/userAddToCart", method = RequestMethod.GET)
	public ModelAndView addToCart(@RequestParam ("productname") String productName, 
			@RequestParam ("user") String curUser)	{
		this.cartService.addToCart(productName, curUser);
		ModelAndView model = new ModelAndView();
		model.setViewName("userCart");
		return model;
	}


	@RequestMapping(value = { "/userCart={email}.html" }, method = RequestMethod.GET)
	public ModelAndView userCart(@PathVariable("email") String email) {

		ModelAndView model = new ModelAndView();
		System.out.println(email);
		List<Cart> userCart= this.cartService.listAllByUser(email);
		System.out.println(userCart);
		model.addObject("listCart", userCart);
		model.setViewName("userCart");
		return model;

	}
}