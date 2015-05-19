<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
	<head>
		<title>Login Page</title>
			
		<link href="resources/css/materialize.css" rel="stylesheet">
		<link href="resources/css/materialize.min.css" rel="stylesheet">
		<link href="resources/css/login.css" rel="stylesheet">
		<link type="text/css" rel="stylesheet" href="resources/css/home.css" media="screen,projection" />

		<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		<script src="resources/js/materialize.js"></script>
		<script src="resources/js/materialize.min.js"></script>
		<script src="resources/js/login.js"></script>
		<script type="text/javascript" src="resources/js/home-ads.js"></script>
		<script type="text/javascript" src="resources/js/custom.js"></script>
	</head>
	<body>
		<nav>
			<%@ include file = "partials/header.jsp"%>
		</nav>

						<!--     PAGE START  -->
		<div class="row" id="login-box">
			<p id="error-msg">${error}</p>
			<div class="col s12">
				<ul class="tabs">
					<li class="tab col s6"><a class="${loginTab}" href="#login">Sign	In</a></li>
					<li class="tab col s6"><a class="${registerTab}" href="#register">Sign Up</a></li>
				</ul>
			</div>

				<!--     ***** Login *****     -->
			<div id="login" class="col s12">
				<div>
					<div class="row">
						<c:if test="${'error' eq param.auth}">
       						 <div style="color:red">
                				Login Failed!!!<br />
                					Reason : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
       						  </div>
    					</c:if>
						<form:form class="col s12" name='loginForm'
								action="j_spring_security_check" modelAttribute="users"
								method='POST'>
							<div class="row">
								<div class="input-field col s12">
									<form:input path="email" type="email" required="true"/>
									<label for="email">Username or email </label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s12">
									<form:input type="password" path="password" required="true"/>
									<label for="password">Password</label>
								</div>
							</div>
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
							<button class="btn waves-effect waves-light" id="login-submit"
									type="submit" name="action" value="submit" name="submit">Login
							</button>
						</form:form>
					</div>
				</div>
			</div>

		<!--  ***** Register ******  -->

			<div id="register" class="col s12">
				<div>
					<div class="row">
						<form:form class="col s12" id="registerForm" action="register" modelAttribute="users"
								method="post" >
							<div class="row">
								<div class="input-field col s6">
									<form:input id="first-name" type="text" path="fName"
											class="validate alphabets-only" name="fName" required="true"/>
									<label for="first-name">First Name</label>
								</div>
								<div class="input-field col s6">
									<form:input id="last-name" type="text" path="lName"
										class="validate alphabets-only" name="lName" required="true"/>
									<label for="last-name">Last Name</label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s12">
									<form:input id="register-email" path="email" type="email" name="email" class="validate" required="true" />
									<label for="email">Email</label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s6">
									<input id="register-password" type="password" name="password" class="validate" required />
									<label for="password">Enter Password </label>
								</div>
								<div class="input-field col s6">
									<input type="password" name="confirm-password" id="confirm-password" class="validate" required />
									<label for="confirm-password" id="confirm-password-label" style="font-size: 12px">Confirm Password</label>
								</div>
							</div>
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
							<button class="btn waves-effect waves-light" type="submit"
										name="submit" value="submit" id="register-submit">Register
							</button>
						</form:form>
					</div>
				</div>
			</div>
			<p id="error-msg"><a href="#">${forgot_password}</a></p>
		</div>
	
						<!--     PAGE END  -->
						
						
						<!--   	  FOOTER	-->

		<footer class="page-footer">
			<%@ include file = "partials/footer.jsp"%>
		</footer>
	
	</body>
</html>