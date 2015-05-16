<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Person Page</title>
    

    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="resources/css/materialize.min.css" media="screen,projection" />
    <link type="text/css" rel="stylesheet" href="resources/css/Items.css" media="screen,projection" />
	<link type="text/css" rel="stylesheet" href="resources/css/home.css"  media="screen,projection"/>
	
    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

    <!--Scripts-->
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="resources/js/materialize.min.js"></script>
    <script  type="text/javascript" src="resources/js/home-ads.js"></script>
    <script type="text/javascript" src="resources/js/custom.js"></script>
</head>

<body>
<nav>
		<div class="nav-wrapper">

			<a href="#!" class="brand-logo">Logo</a>
			<ul id= "categories_drop" class="right hide-on-med-and-down">
				
				<li id= "search_bar"><form >
				<div class="li_no_hover arrange" ><a id ="drop_button"
					class='dropdown-button waves-effect btn-flat' data-beloworigin="true"
					href='#' data-activates='dropdown1'><b>Categories</b></a>
					<ul id='dropdown1' class='dropdown-content' >
						<li><a href="#!">one</a></li>
						<li><a href="#!">two</a></li>
						<li class="divider"></li>
						<li><a href="#!">three</a></li>
					</ul></div>
						<div class="input-field arrange">
							<input id="search" type="search" required>
							<label for="search"><i class="mdi-action-search"></i></label>
						</div>
					</form></li>
				<li><a href="mobile.html"><i
						class="mdi-action-add-shopping-cart"></i></a></li>
				<li><a href="login.html"><i
						class="mdi-action-account-circle"></i></a></li>
				
			</ul>
		</div>
	</nav>
	<div class="row">
        <div class="col s12 m4 l3">
            <!-- Grey navigation panel -->
            <ul class="collapsible" data-collapsible="accordion">
                <li>
                    <div class="collapsible-header">
                        <i class="mdi-action-list"></i>Category
                    </div>
                    <div class="collapsible-body">
                        <p>Lorem ipsum dolor sit amet.</p>
                    </div>
                </li>
                <li>
                    <div class="collapsible-header">
                        <i class="mdi-action-list"></i>Price range
                    </div>
                    <div class="collapsible-body">
                        <p>Lorem ipsum dolor sit amet.</p>
                    </div>
                </li>
                <li>
                    <div class="collapsible-header">
                        <i class="mdi-action-list"></i>Brand
                    </div>
                    <div class="collapsible-body">
                        <p>Lorem ipsum dolor sit amet.</p>
                    </div>
                </li>
            </ul>
        </div>
<div class="col s12 m8 l9">
            <!-- Main page content  -->
            <div class="row">
                <c:if test="${!empty listproducts}">
                    <c:forEach items="${listproducts}" var="product">
                        <div class="col s12 m6 l3">
                            <div class="card">
                                <div class="card-image">
                                    <img class="item-image" src="resources/images/${product.productImage}"><span class="card-title" style="color: black">${product.productName}</span>
                                </div>
                                <div class="card-content">
                                    <p>${product.brand}</p>
                                </div>
                                <div class="card-action">
                                    <a class="waves-effect waves-light btn add-to-cart" onclick="Materialize.toast('<span>Added to Cart!</span><a class=&quot;btn-flat yellow-text&quot; href=&quot;#!&quot;>Undo</a>', 3000)">Add To Cart</a>
                                </div>
                            </div>
                        </div>
                      
                    </c:forEach>
                </c:if>                   
            </div>
        </div>
    </div>
<form action="product" method="post">
<table>
<!-- <tr><td>Product ID</td><td><input type="number" name="productId"></td></tr> -->
<tr><td>Product Name</td><td><input type="text" name="productName"></td></tr>
<tr><td>Product image</td><td><input type="text" name="productImage"></td></tr>
<tr><td>Product price</td><td><input type="text" name="productPrice"></td></tr>
<tr><td>Product brand</td><td><input type="text" name="brand"></td></tr>
<tr><td>Product quantity</td><td><input type="text" name="quantity"></td></tr>
<tr><td>category name</td><td><input type="text" name="category.categoryName"></td></tr>
<tr><td><input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" /></td></tr>
<tr><td>submit</td><td><input type="submit"></td></tr>
</table>

</form>
<form action="updateproduct" method="post" >
<table>
<!-- <tr><td>Product ID</td><td><input type="number" name="productId"></td></tr> -->
<tr><td>Product Name</td><td><input type="text" name="productName"></td></tr>
<tr><td>Product image</td><td><input type="text" name="productImage"></td></tr>
<tr><td>Product price</td><td><input type="text" name="productPrice"></td></tr>
<tr><td>Product brand</td><td><input type="text" name="brand"></td></tr>
<tr><td>Product quantity</td><td><input type="text" name="quantity"></td></tr>
<tr><td><input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" /></td></tr>
<tr><td>category name</td><td><input type="text" name="category.categoryName"></td></tr>
<tr><td>update</td><td><input type="submit"></td></tr>
</table>
</form>
<form action="removeproduct" method="post" >
<table>
<tr><td>Product Name</td><td><input type="text" name="productName"></td></tr>
<tr><td><input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" /></td></tr>
<tr><td>Remove</td><td><input type="submit"></td></tr>
</table>

</form>
<h3>Products List</h3>
<c:if test="${!empty listproducts}">
    <table class="tg">
    <tr>
        <th width="80">productID</th>
        <th width="120">product Name</th>
        <th width="120">Product brand</th>
        <th width="120">Product image</th>
        <th width="120">Product quantity</th>
        <th width="120">Product price</th>
        <th width="120">Product category</th>
        <th width="60">Edit</th>
        <th width="60">Delete</th>
    </tr>
    <c:forEach items="${listproducts}" var="product">
        <tr>
            <td>${product.productId}</td>
            <td>${product.productName}</td>
            <td>${product.brand}</td>
            <td>${product.productImage}</td>
            <td>${product.quantity}</td>
            <td>${product.productPrice}</td>
            <td>${product.category.categoryName}</td>          
            <td><a href="<c:url value='/edit/${product.productName}' />" >Edit</a></td>
            <td><a href="<c:url value='/remove/${product.productName}' />" >Delete</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>
<div class="col s12 m8 l9">
            <!-- Main page content  -->
            <div class="row">
                <c:if test="${!empty listPersons}">
                    <c:forEach items="${listPersons}" var="person">
                        <div class="col s12 m6 l3">
                            <div class="card">
                                <div class="card-image">
                                    <img class="item-image" src="${person.img}"><span class="card-title">${person.title}</span>
                                </div>
                                <div class="card-content">
                                    <p>${person.descr}</p>
                                </div>
                                <div class="card-action">
                                    <a class="waves-effect waves-light btn add-to-cart" onclick="Materialize.toast('<span>Added to Cart!</span><a class=&quot;btn-flat yellow-text&quot;href=&quot;#!&quot;>Undo</a>', 3000)">Add To Cart</a>
                                </div>
                            </div>
                        </div>
                      
                    </c:forEach>
                </c:if>                   
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