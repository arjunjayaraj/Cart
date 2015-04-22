<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<!--Import materialize.css-->
      <link type="text/css" rel="stylesheet" href="resources/css/materialize.min.css"  media="screen,projection"/>
	  <link type="text/css" rel="stylesheet" href="resources/css/home.css"  media="screen,projection"/>
      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
</head>
<body>
<div class="container" id="content-wrap">
 <div class="row" id="collection-panel-wrap">
          <div class="col l6 s12 m12">
          <div class="card small collection-panel" id="home-collection-men" style="height: 20%;" >
            <div class="card-image home-collection-image" style="height: 100%">
             <a href="#"> <img id="collection-men-image" src="resources/images/men.jpg">
             <span class="card-title collection-title" id="collection-men-title" style="color: #EE6E73;">MEN</span>
             </a>
            
            </div>
             
          </div>
        </div>
        <div class="col l6 s12 m12">
          <div class="card small collection-panel" id="home-collection-women" >
            <div class="card-image home-collection-image"  style="height: 100%">
             <a href="#"> <img id="collection-women-image" src="resources/images/women.jpg" style="height: 100%">
             <span class="card-title collection-title" id="collection-women-title" style="color: #EE6E73">WOMEN</span>
             </a>
            
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
                <p class="grey-text text-lighten-4" id="about-text">IndiaCart provides a platform for vendors across the country to connect with millions of customers. Our online shopping platform has the widest assortment of products from thousands of brands across categories like Women's Apparel,and Men's Apparel. Grab your favorite products at best prices and save the one thing that matters most to you - "Your Money". </div>
              <div class="col l4 offset-l2 s12">
                <h5 class="white-text">Top Links</h5>
                <ul>
                  <li><a class="grey-text text-lighten-3" href="#!">Contact us</a></li>
                  <li><a class="grey-text text-lighten-3" href="#!">About us</a></li>
                  <li><a class="grey-text text-lighten-3" href="#!">Terms of use</a></li>
                  <li><a class="grey-text text-lighten-3" href="#!">FAQ</a></li>
                </ul>
              </div>
            </div>
          </div>
          <div class="footer-copyright">
            <div class="container">
       © 2015 Copyright Text
           </div>
          </div>
        </footer>
            

</body>
</html>
