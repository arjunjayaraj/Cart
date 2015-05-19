<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>

	<head>
		<title>AdminHome</title>
		
		<!--Import materialize.css-->
      	<link type="text/css" rel="stylesheet" href="resources/css/materialize.min.css"  media="screen,projection"/>
	  	<link type="text/css" rel="stylesheet" href="resources/css/home.css"  media="screen,projection"/>
    	
    	<!-- Import scripts -->
      	<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
      	<script  type="text/javascript" src="resources/js/materialize.min.js"></script>
      	<script  type="text/javascript" src="resources/js/home-ads.js"></script>
      		<script type="text/javascript" src="resources/js/custom.js"></script>
    	
    	<!--Let browser know website is optimized for mobile-->
      	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
	</head>
<body>
	<nav>
		<div class="nav-wrapper">
			<a href="#!" ><img id="logo_img" src= "resources/images/shopify-bag.png"></a>
			<span id= "nav_title" ><b >India-Cart</b></span>
			<ul id= "categories_drop" class="right hide-on-med-and-down">
				<li><c:url value="/j_spring_security_logout" var="logoutUrl" />
					<form action="${logoutUrl}" method="post" id="logoutForm" style="margin-bottom: 0px;">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					</form>
				<script>
					function formSubmit() {
						document.getElementById("logoutForm").submit();
					}
				</script>
				
				 <a class='dropdown-button' data-constrainwidth="false" data-beloworigin="true" href='#' data-activates='dropdown1'>
				 	<i class="mdi-action-account-circle"></i>
				 </a>
				 <c:if test="${pageContext.request.userPrincipal.name != null}">
 						 <!-- Dropdown Structure -->
  							<ul id='dropdown1' class='dropdown-content'>
    						<li><a href="#!">${pageContext.request.userPrincipal.name}</a></li>
    						<li><a href="javascript:formSubmit()">Logout</a></li>
 							 </ul>
 				</c:if>
				</li>
			</ul>
		</div>
	</nav>
<div id="collection-wrap">
 <div class="row" id="collection-panel-wrap">
          <div class="col l6 s12 m12">
          <div class="card small collection-panel" id="home-collection-men" >
            <div class="card-image collection-content" >
             <a href="adminUsersControl"> <img id="collection-men-image" src="resources/images/users.png">
             <span class="card-title collection-title" id="collection-men-title" >USERS</span>
             </a>
            
            </div>
             
          </div>
        </div>
        <div class="col l6 s12 m12">
          <div class="card small collection-panel" id="home-collection-women">
            <div class="card-image collection-content">
             <a href="adminProductsControl"> <img id="collection-women-image" src="resources/images/products.jpg" >
             <span class="card-title collection-title" id="collection-women-title" >PRODUCTS</span>
             </a>
            
            </div>
             
          </div>
        </div>
      </div>
          
          </div>  
						<!--   	  FOOTER	-->

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