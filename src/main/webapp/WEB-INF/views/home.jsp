<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
	<head>
		<title>Home</title>
		
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

		<div  class="container" >
     		<ul class="pagination">
   				<li class="disabled"><a href="#!"><i class="mdi-navigation-chevron-left"></i></a></li>
    			<li class="active"><a href="#!">1</a></li>
    			<li class="waves-effect"><a href="#!">Women</a></li>
    			<li class="waves-effect"><a href="#!">Kids</a></li>
   	 			<li class="waves-effect"><a href="#!">4</a></li>
    			<li class="waves-effect"><a href="#!">5</a></li>
    			<li class="waves-effect"><a href="#!"><i class="mdi-navigation-chevron-right"></i></a></li>
  			</ul>
  			
      	<!-- ADS by Pattar -->
      		
      	<div class="row" id="sponsored-ads">
        	<div class="slider">
    			<ul class="slides">
     				<li>
        				<img src="http://lorempixel.com/580/250/nature/1"> <!-- random image -->
        				<div class="caption center-align">
        	  				<h3>This is our big Tagline!</h3>
          					<h5 class="light grey-text text-lighten-3">Here's our small slogan.</h5>
        				</div>
      				</li>
      				<li>
                        <img src="http://lorempixel.com/580/250/nature/2"> <!-- random image -->
                        <div class="caption left-align">
                	        <h3>Left Aligned Caption</h3>
                    	    <h5 class="light grey-text text-lighten-3">Here's our small slogan.</h5>
                    	</div>
                    </li>
      				<li>
        				<img src="http://lorempixel.com/580/250/nature/3"> <!-- random image -->
				        <div class="caption right-align">
          					<h3>Right Aligned Caption</h3>
          					<h5 class="light grey-text text-lighten-3">Here's our small slogan.</h5>
        				</div>
      				</li>
      				<li>
        				<img src="http://lorempixel.com/580/250/nature/4"> <!-- random image -->
        				<div class="caption center-align">
          					<h3>This is our big Tagline!</h3>
          					<h5 class="light grey-text text-lighten-3">Here's our small slogan.</h5>
        				</div>
      				</li>
    			</ul>
  			</div>
		</div>
		
		<!-- Men's and Women's section Arjun -->
		
		<div id="collection-wrap">
			<div class="row" id="collection-panel-wrap">
				<div class="col l6 s12 m12">
					<div class="card small collection-panel" id="home-collection-men" >
						<div class="card-image collection-content" >
							<a href="MEN"> <img id="collection-men-image" src="resources/images/men.jpg">
								<span class="card-title collection-title" id="collection-men-title" >MEN</span>
							</a>
						</div>
					</div>
				</div>
				<div class="col l6 s12 m12">
					<div class="card small collection-panel" id="home-collection-women">
						<div class="card-image collection-content">
							<a href="WOMEN"> <img id="collection-women-image" src="resources/images/women.jpg" >
								<span class="card-title collection-title" id="collection-women-title" >WOMEN</span>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<footer class="page-footer">
		<%@ include file = "partials/footer.jsp"%>
	</footer>
</body>
</html>
