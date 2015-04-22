<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet"
	href="resources/css/materialize.min.css" media="screen,projection" />
<link type="text/css" rel="stylesheet" href="resources/css/home.css"
	media="screen,projection" />
<!--Let browser know website is optimized for mobile-->
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
</head>
<body>

	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="resources/js/materialize.min.js"></script>
	<script type="text/javascript" src="resources/js/custom.js"></script>



	<nav style= "background-color: #4CAF50;">
		<div class="nav-wrapper">
			<a href="#!" class="brand-logo">Logo</a>
			<ul class="hide-on-med-and-down " style="margin-left: 15%;">
				
				<li class="li_no_hover" style="margin-left: -5%;"><a class='dropdown-button waves-effect btn-flat' style= "color: white;border-radius: 25px;" data-beloworigin="true"
					href='#' data-activates='dropdown1'><b>Categories</b></a>
					<ul id='dropdown1' class='dropdown-content'>
						<li><a href="#!">one</a></li>
						<li><a href="#!">two</a></li>
						<li class="divider"></li>
						<li><a href="#!">three</a></li>
					</ul></li>
				<li id="search-bar"><form style="height: 100%;">
						<div class="input-field" style="padding: 5px; margin-left: 10%; height: 83%; margin-left: 0px;">
							<input id="search" type="search" required
								style="height: 50%; border-radius: 25px; margin: 10px; padding-top: 5px;width: 85%;"> <label
								for="search"><i class="mdi-action-search"></i></label>
						</div>
					</form></li>
				<li style="float: right;"><a><i class="mdi-action-account-circle" ></i></a></li>
				<li style="float: right;"><a><i class="mdi-action-add-shopping-cart" ></i></a></li>
			</ul>
		</div>
	</nav>
	
<div  class="container" >	
<div id="collection-wrap">
 <div class="row" id="collection-panel-wrap">
          <div class="col l6 s12 m12">
          <div class="card small collection-panel" id="home-collection-men" >
            <div class="card-image collection-content" >
             <a href="#"> <img id="collection-men-image" src="resources/images/men.jpg">
             <span class="card-title collection-title" id="collection-men-title" >MEN</span>
             </a>
            
            </div>
             
          </div>
        </div>
        <div class="col l6 s12 m12">
          <div class="card small collection-panel" id="home-collection-women">
            <div class="card-image collection-content">
             <a href="#"> <img id="collection-women-image" src="resources/images/women.jpg" >
             <span class="card-title collection-title" id="collection-women-title" >WOMEN</span>
             </a>
            
            </div>
             
          </div>
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
