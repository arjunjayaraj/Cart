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
<body onload='document.loginForm.username.focus();'>

	<h1>User Login</h1>

	<!-- <div id="login-box">	
		<div class="row">
		    <form class="col s12"  name='loginForm'
					action="<c:url value='/j_spring_security_check' />" method='POST'>
		     <div class="row">
		        <div class="input-field col s12">
		          <input id="email" type="email" class="validate" placeholder="E Mail">
		        		        </div>
		      </div>
		      <div class="row">
		        <div class="input-field col s12">
		          <input id="password" type="password" class="validate">
		          <label for="password">Password</label>
		        </div>
		      </div>
		      
		 <button class="btn waves-effect waves-light" type="submit" name="action" value="submit" name="submit">Login
		   
		  </button>
		        
		    </form>
		</div>
	</div> -->
	
	<div class="row" >
    <div class="col s5">
      <ul class="tabs">
        <li class="tab col s6"><a class="active" href="#test1">Test 1</a></li>
        <li class="tab col s6"><a  href="#test2">Test 2</a></li>
      
      </ul>
    </div>
    <div id="test1" class="col s12">Test 1
    <div>	
		<div class="row">
		    <form class="col s12"  name='loginForm'
					action="<c:url value='/j_spring_security_check' />" method='POST'>
		     <div class="row">
		        <div class="input-field col s12">
		          <input id="email" type="email" class="validate" placeholder="E Mail">
		        		        </div>
		      </div>
		      <div class="row">
		        <div class="input-field col s12">
		          <input id="password" type="password" class="validate">
		          <label for="password">Password</label>
		        </div>
		      </div>
		      
		 <button class="btn waves-effect waves-light" type="submit" name="action" value="submit" name="submit">Login
		   
		  </button>
		        
		    </form>
		</div>
	</div>
    
    </div>
    
    <div id="test2" class="col s12">Test 2</div>
   
  </div>
        


</body>
</html>