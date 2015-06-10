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
			<%@ include file = "partials/header.jsp"%>
		</nav>
		
		<div id="collection-wrap">
 			<div class="row" id="collection-panel-wrap">
 					<div class="col l9 s12 m12">
 					<div class="card small collection-panel" id="home-collection-men" >
 						<div class="card-image collection-content" >
 							<a href="adminUsersControl">
 								<img id="collection-men-image" src="resources/images/users.png">
             					<span class="card-title collection-title" id="collection-men-title" >USERS</span>
             				</a>
             			</div>
             		</div>
             	</div>
             </div>
        </div>  
		
						<!--   	  FOOTER	-->
		<footer class="page-footer">
			<%@ include file = "partials/footer.jsp"%>
		</footer>

	</body>
</html>