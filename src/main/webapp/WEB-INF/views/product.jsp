<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page session="true"%>
<html>
<head>
    <title>Product Page</title>
     <meta name="_csrf" content="${_csrf.token}"/>
    <!-- default header name is X-CSRF-TOKEN -->
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

    <!--Import materialize.css-->
     <link type="text/css" rel="stylesheet" href="resources/css/materialize.min.css" media="screen,projection" />
    <link rel="stylesheet"	href='<c:url value="resources/css/pure-0.4.2.css"/>'>
    <link rel="stylesheet"	href='<c:url value="resources/css/font-awesome-4.0.3/css/font-awesome.css"/>'>
	<link rel="stylesheet"	href='<c:url value="resources/css/jquery-ui-1.10.4.custom.css"/>'>
    <link type="text/css" rel="stylesheet" href="resources/css/materialize.min.css" media="screen,projection" />
	<link type="text/css" rel="stylesheet" href="resources/css/home.css"  media="screen,projection"/>
	<link type="text/css" rel="stylesheet" href="resources/css/product.css"  media="screen,projection"/>
	
    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

    <!--Scripts-->
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
 	<script type="text/javascript" src="resources/js/lib/jquery-ui-1.10.4.custom.js"></script>
<!-- 	<script type="text/javascript" src="resources/js/lib/jquery.ui.datepicker.js"/></script> -->
    <script type="text/javascript" src="resources/js/materialize.min.js"></script>
    <script  type="text/javascript" src="resources/js/home-ads.js"></script>
    <script type="text/javascript" src="resources/js/custom.js"></script>
    <script type="text/javascript" src="resources/js/product.js"></script>
</head>

<body>
<nav>
		<div class="nav-wrapper">

				<a href="home" ><img id="logo_img" src= "resources/images/shopify-bag.png"></a>
	<span id= "nav_title">
		<b>India-Cart</b>
	</span>
			<ul id= "categories_drop" class="right hide-on-med-and-down">
				<li id= "search_bar">
				<form id="searchform" onkeyup="searchForm();" >
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
						</form>
					</li>

		<li><a href="userCart=${pageContext.request.userPrincipal.name}.html"><i class="mdi-action-add-shopping-cart"></i></a></li>

		<li><c:url value="/j_spring_security_logout" var="logoutUrl" />
			<form action="${logoutUrl}" method="post" id="logoutForm"
					style="margin-bottom: 0px;">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</form>
			<c:if test="${pageContext.request.userPrincipal.name != null}">
				<a class='dropdown-button' data-constrainwidth="false"
						data-beloworigin="true" href='#' data-activates='user-details'>
					<i class="mdi-action-account-circle"></i>
				</a>
				<!-- Dropdown Structure -->
				<ul id='user-details' class='dropdown-content'>
					<li >
						<c:choose>
							<c:when test="${pageContext.request.isUserInRole('ROLE_ADMIN')}">
								<a href="adminHome" id="curUser">${pageContext.request.userPrincipal.name}</a>
							</c:when>
							<c:otherwise>
								<a href="" id="curUser">${pageContext.request.userPrincipal.name}</a>
							</c:otherwise>
						</c:choose>
					</li>

					<li><a href="javascript:formSubmit()">Logout</a></li>
				</ul>
			</c:if>
			 <c:if test="${pageContext.request.userPrincipal.name == null}">
			 	<a href="login"><i class="mdi-action-account-circle"></i></a>
			 </c:if>
		</li>
			</ul>
		</div>
	</nav>
	<div id="productDialog" style="display: none;">
			<%@ include file="partials/productForm.jsp"%>
		</div>
	<div class="row">
        <div class="col s12 m4 l3">
          <!-- Grey navigation panel -->
          <c:choose>
          <c:when test="${pageContext.request.isUserInRole('ROLE_ADMIN')}">
          <div>
                 <a class="waves-effect waves-light btn" onclick="addProduct()">Add Product</a>
          </div>
        </c:when>
          </c:choose>
            <ul class="collapsible" data-collapsible="accordion">
                <li>
                    <div class="collapsible-header">
                        <i class="mdi-action-list"></i>BRAND
                    </div>
                    <div class="collapsible-body">
                     <form id="brandFilter" class="filter-form">
					<ul>
					<c:if test="${!empty listbrand}">
                    <c:forEach items="${listbrand}" var="brand">
   					<li>  <input name="brand" type="checkbox" value="${brand}" id="${brand}"/>
      				<label for="${brand}">${brand}</label> </li>
      				</c:forEach>
      				</c:if>
      				</ul>
     
    		</form>
                
                </div>
                </li>
                <li>
                    <div class="collapsible-header">
                        <i class="mdi-action-list"></i>Category
                    </div>
                    <div class="collapsible-body">
                          <form id="categoryFilter" class="filter-form">
					<ul>
					<c:if test="${!empty listcategory}">
                    <c:forEach items="${listcategory}" var="category">
   					<li>  <input name="category" type="checkbox" value="${category.categoryId}" id="${category.categoryName}"/>
      				<label for="${category.categoryName}">${category.categoryName}</label> </li>
      				</c:forEach>
      				</c:if>
      				</ul>
     
    		</form>
                    </div>
                </li>
                <li>
                    <div class="collapsible-header">
                    <i class="mdi-action-list"></i>Maximum Price
                    </div>
                    <div class="collapsible-body">
                        <form class="range-field" id=priceFilter>
     						 <input type="range" id="priceinput" min="0" max="1000000" />
  					  </form>
                    </div>
                 </li>
                  <li>
                    <div class="collapsible-header">
                    <i class="mdi-action-list"></i>Availability
                    </div>
                    <div class="collapsible-body">
                    
                        <form id=stockFilter>
                        <ul>
                        <li>
     					
      	 <input type="checkbox" id="quantityFilter" value="1"/>
      <label for="quantityFilter">Exclude Out of Stock</label>
  					  </li>
  					  </ul>
  					  </form>
                    </div>
                 </li>
                
                
                
                <li>
                    <div class="collapsible-header">
                        <i class="mdi-action-list"></i>
              <a class="waves-effect waves-light btn add-to-cart" id="filterButton" onclick="filter()">Filter</a>
                    </div>
                 </li>
            </ul>
        </div>

<div class="col s12 m8 l9" id="productList">
            <!-- Main page content  -->
            <%@ include file = "search.jsp"%>

        </div>
    </div>

	<footer class="page-footer">
		<%@ include file = "partials/footer.jsp"%>
	</footer>
	

	
</body>
</html>

<script>
$(document).ready(function() {
	$("#categorySelect option[value=" + '${selectedagegroup}' + "]").attr('selected', 'selected'); 
    $('select').material_select();
  });
</script>
