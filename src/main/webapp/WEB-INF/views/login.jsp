<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@page session="true"%>
<html>
<head>
<title>Login Page</title>

<link href="resources/css/materialize.css" rel="stylesheet">
<link href="resources/css/materialize.min.css" rel="stylesheet">
<link href="resources/css/login.css" rel="stylesheet">
<link type="text/css" rel="stylesheet" href="resources/css/home.css"  media="screen,projection"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="resources/js/materialize.js"></script>
<script src="resources/js/materialize.min.js"></script>
<script src="resources/js/login.js"></script>
<script  type="text/javascript" src="resources/js/home-ads.js"></script>
<script type="text/javascript" src="resources/js/custom.js"></script>
</head>
<body>
<nav>
		<div class="nav-wrapper">

			<a href="#!" ><img id="logo_img" src= "resources/images/shopify-bag.png"></a>
			<span id= "nav_title" ><b >India-Cart</b></span>
			<ul id= "categories_drop" class="right hide-on-med-and-down">
				
				<li id= "search_bar"><form >
				<div class="li_no_hover arrange" ><a id ="drop_button"
					class='dropdown-button waves-effect btn-flat' data-beloworigin="true"
					href='#' data-activates='dropdown1'><b>Categories</b></a>
					<ul id='dropdown1' class='dropdown-content' >
						<li><a href="#!">one</a></li>
						<li><a href="#!">two</a></li>
						<li class="divider"></li>
						<li><a href="#!">three</a></li>
					</ul></div>
						<div class="input-field arrange">
							<input id="search" type="search" required>
							<label for="search"><i class="mdi-action-search"></i></label>
						</div>
					</form></li>
				<li><a href="mobile.html"><i
						class="mdi-action-add-shopping-cart"></i></a></li>
				
				
			</ul>
		</div>
	</nav>

<div class="row" id="login-box">
		<p id="error-msg">${error}</p>
    <div class="col s12">
      <ul class="tabs">
        <li class="tab col s6"><a class="active" href="#login">Sign In</a></li>
        <li class="tab col s6"><a  href="#register">Sign Up</a></li>
      
      </ul>
    </div>
    
   						 <!--     ***** Login *****     -->
    <div id="login" class="col s12">
	    <div>	
			<div class="row">

				<p id="error-msg"></p>
			    <form:form class="col s12"  name='loginForm' action="j_spring_security_check"
			    			modelAttribute="users" method='POST'>
			     <div class="row">
			        <div class="input-field col s12">
			         <%--  <form:input type="text" name="username" path="username" class="validate" id="login-email" required/> --%>
			          <form:input path="username" type="text" />

			        	 <label for="email">Username or email </label>
			        		        </div>
			      </div>
			      <div class="row">
			        <div class="input-field col s12">

			          <%-- <form:input type="password" name="password" path="password" class="validate" id="login-password" required/> --%>
			          <form:input type="password" path="password" />
			          <label for="password">Password</label>
			        </div>
			      </div>
			      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
			 <button class="btn waves-effect waves-light" id="login-submit" type="submit" name="action" value="submit" name="submit">Login
			   
			  </button>
			        
			    </form:form>
			</div>
		</div>
    
    </div>
    
                       <!--  ***** Register ******  -->
    
  <div id="register" class="col s12">
     <div>	
			<div class="row">
			
			  <!-- <form class="col s12"  action="register" method="post" commandName="registerForm" >-->
			  	<form class="col s12" id="registerForm" action="register" method="post" commandName="registerForm" >
				    <p id="error-msg" name="errorMsg"></p>
				     <div class="row">
				        <div class="input-field col s6">
				          <input  id="first-name" type="text" class="validate alphabets-only"  name="fName"  required/>
				          <label for="first-name">First Name</label>
				        </div>
				        <div class="input-field col s6">
				          <input id="last-name" type="text" class="validate alphabets-only"  name="lName" required/>
				          <label for="last-name">Last Name</label>
				        </div>
	                </div>
				    <div class="row">
				        <div class="input-field col s12">
				          <input id="register-email" type="email" name="username" class="validate" required/>
				       <label for="register-email">Email</label>
				       </div>
				      </div>
					<div class="row">
				        <div class="input-field col s6">
				          <input id= "register-password" type="password" name="password" class="validate" required/>
				          <label for="password">Enter Password </label>
				        </div>
				       <div class="input-field col s6">
				          <input type="password" name="confirm-password" id="confirm-password" class="validate" required/>
				          <label for="confirm-password" id="confirm-password-label" style="font-size:12px">Confirm Password</label>
				        </div>
				      </div>

				      
 					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

					 <button class="btn waves-effect waves-light" type="submit"  name="submit"  value="submit" id="register-submit">Register
					   
					  </button>
					        
			    </form>
			   
			</div>
		</div>
     </div>
     
     
   
  </div>
        
	<footer class="page-footer">
		<div class="container">
			<div class="row">
				<div class="col l6 s12">
					<h5 class="white-text">IndiaCart</h5>
					<p class="grey-text text-lighten-4" id="about-text">IndiaCart
						provides a platform for vendors across the country to connect with
						millions of customers. Our online shopping platform has the widest
						assortment of products from thousands of brands across categories
						like Women's Apparel,and Men's Apparel. Grab your favorite
						products at best prices and save the one thing that matters most
						to you - "Your Money".
				</div>
				<div class="col l4 offset-l2 s12">
					<h5 class="white-text">Top Links</h5>
					<ul>
						<li><a class="grey-text text-lighten-3" href="#!">Contact
								us</a></li>
						<li><a class="grey-text text-lighten-3" href="#!">About
								us</a></li>
						<li><a class="grey-text text-lighten-3" href="#!">Terms
								of use</a></li>
						<li><a class="grey-text text-lighten-3" href="#!">FAQ</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="footer-copyright">
			<div class="container">© 2015 Copyright Text</div>
		</div>
	</footer>

</body>
</html>