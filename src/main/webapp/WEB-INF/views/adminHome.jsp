<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Home</title>
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
<script type="text/javascript" src="resources/js/custom.js"></script>

<!--Let browser know website is optimized for mobile-->
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
</head>
<body>
	<div class="admin_wrap">
		<div class="header">
		<div class=" logut">
		<button class="logout_btn">Logout</button>
		</div>
		</div>
		<div class="admin_options">
			<div class="add_product z-depth-3 btn  waves-effect waves-orange">
				<a>Add New Product</a>
			</div>
			<div class="delete_product z-depth-3 btn waves-effect waves-orange">
				<a>Delete Existing Product</a>
			</div>
			<div class="edit_product z-depth-3 btn waves-effect waves-orange">
				<a>Edit Product Details</a>
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
			<div class="container pull-right">Â© 2015 Copyright Text</div>
		</div>
	</footer>

	</div>
</body>
</html>