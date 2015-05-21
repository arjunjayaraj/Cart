<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product Page</title>
     <meta name="_csrf" content="${_csrf.token}"/>
    <!-- default header name is X-CSRF-TOKEN -->
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

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
				<li id= "search_bar"><form id="searchform" >
				<div class="input-field col s1 li_no_hover arrange" id ="nav-category-select">
				    <select id ="categorySelect">
				      <option value="ALL">ALL</option>
				      <option value="MEN">Men</option>
				      <option value="WOMEN">Women</option>
				      <option value="BOYS">Boys</option>
				      <option value="GIRLS">Girls</option>
				      <option value="UNISEX">Unisex</option>
				    </select>
				  </div>
				<div class="input-field arrange" id="searchdiv">
							<input id="searchproduct" type="search" required  name="searchproduct">
							<label for="searchproduct"><i class="mdi-action-search"></i></label>
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
<div class="col s12 m8 l9" id="productList">
            <!-- Main page content  -->
            <div class="row" >
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

	<footer class="page-footer">
		<%@ include file = "partials/footer.jsp"%>
	</footer>
	
<!-- var token = $("meta[name='_csrf']").attr("content"); -->
<!-- 	        var header = $("meta[name='_csrf_header']").attr("content"); -->

<!--   beforeSend: function(xhr){ -->
<!-- 		                xhr.setRequestHeader(header, token); -->
<!-- 		            }, -->
	
</body>
</html>

		<script type="text/javascript">
		$("#searchproduct").keyup( function() {
			var searchQuery = $("#searchproduct").val();
			var search = $("#categorySelect").val();
			
	 		window.alert(search);
			    $.ajax({
		            type: "GET",
		            url: "productsearch",
		            contentType : 'application/json; charset=utf-8',
		            data: { "searchproduct" :searchQuery,
		            		"category" :search,
		            }, 
		          
		              success :function(result) {
		         $("#productList").html(result);
		            		          			
		          }});	    
				
		});

	</script> 



