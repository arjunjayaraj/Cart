<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
<title>Login Page</title>

<link href="resources/css/materialize.css" rel="stylesheet">
<link href="resources/css/materialize.min.css" rel="stylesheet">
<link href="resources/css/login.css" rel="stylesheet">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="resources/js/materialize.js"></script>
<script src="resources/js/materialize.min.js"></script>
<script src="resources/js/login.js"></script>
</head>
<body>

<div class="row" id="login-box">
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
			          <form:input path="username" type="text"/>
			        	 <label for="email">Username or email </label>
			        		        </div>
			      </div>
			      <div class="row">
			        <div class="input-field col s12">
			          <%-- <form:input type="password" name="password" path="password" class="validate" id="login-password" required/> --%>
			          <form:input type="password" path="password"/>
			          <label for="password">Password</label>
			        </div>
			      </div>
			      
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
			<p id="error-msg"></p>
			    <form class="col s12"  onsubmit="return validateRegisterForm()">
				     <div class="row">
				        <div class="input-field col s6">
				          <input  id="first-name" type="text" class="validate" required>
				          <label for="first-name">First Name</label>
				        </div>
				        <div class="input-field col s6">
				          <input id="last-name" type="text" class="validate" required>
				          <label for="last-name">Last Name</label>
				        </div>
	                </div>
				    <div class="row">
				        <div class="input-field col s12">
				          <input id="register-email" type="email" name="username" class="validate" required>
				       <label for="register-email">Email</label>
				       </div>
				      </div>
				<div class="row">
				        <div class="input-field col s6">
				          <input  id= "register-password" type="password" name="password" class="validate" required>
				          <label for="password">Enter Password </label>
				        </div>
				       <div class="input-field col s6">
				          <input  type="password" name="confirm-password" id="confirm-password" class="validate" required>
				          <label for="confirm-password" id="confirm-password-label" style="font-size:12px">Confirm Password</label>
				        </div>
				      </div>
				      
					 <button class="btn waves-effect waves-light" type="submit" name="action" value="submit" name="submit" id="register-submit">Register
					   
					  </button>
					        
			    </form>
			</div>
		</div>
     </div>
   
  </div>
        


</body>
</html>