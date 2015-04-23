<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet"
	href="resources/css/materialize.min.css" media="screen,projection" />
<link type="text/css" rel="stylesheet" href="resources/css/admin.css"
	media="screen,projection" />
<!-- Import scripts -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="resources/js/materialize.min.js"></script>
<script type="text/javascript" src="resources/js/admin.js"></script>
<!--Let browser know website is optimized for mobile-->
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
</head>
<body>
	<div class="login_wrap center-align">
	<header class="page-footer"></header>
		<h4>Admin Login</h4>
		<form class="login z-depth-3">
			<div class="row">
				<div class="input-field ">
					<input id="email" type="email" class="validate"> <label
						for="email">Email</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field ">
					<input id="password" type="password" class="validate"> <label
						for="password">Password</label>
				</div>
			</div>

			<button class="btn waves-effect waves-light" type="submit"
				name="action">
				Submit <i class="mdi-content-send right"></i>
			</button>


		</form>
		<footer class="page-footer"></footer>
	</div>
</body>
</html>