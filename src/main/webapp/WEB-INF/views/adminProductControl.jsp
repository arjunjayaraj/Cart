<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page session="true"%>
<html>
<head>
 <title>Admin Product Control</title>
    

    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="resources/css/materialize.min.css" media="screen,projection" />
    <link type="text/css" rel="stylesheet" href="resources/css/Items.css" media="screen,projection" />
	<link type="text/css" rel="stylesheet" href="resources/css/home.css"  media="screen,projection"/>
	<link type="text/css" rel="stylesheet" href="resources/css/aminProductControl.css"  media="screen,projection"/>
	
    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

</head>
<body>
<nav>
		<%@ include file = "partials/header.jsp"%>
</nav>
<div class="row">
<div class="col s12 m12 l12">
<h3>Products List</h3>
<c:if test="${!empty listproducts}">
    <table class="tg responsive-table">
    <tr>
        <th width="80">productID</th>
        <th width="0">product Name</th>
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
</div>
</div>


<div class="row">
<div class="col s12 m6 l5 card-panel teal">
<form action="addproduct" method="post" enctype="multipart/form-data">
<table>
<!-- <tr><td>Product ID</td><td><input type="number" name="productId"></td></tr> -->
<tr><td>Product Name</td><td><input type="text" name="productName"></td></tr>
<tr><td>Product image</td><td><input type="file" name="productImage"></td></tr>
<tr><td>Product price</td><td><input type="text" name="productPrice"></td></tr>
<tr><td>Product brand</td><td><input type="text" name="brand"></td></tr>
<tr><td>Product quantity</td><td><input type="text" name="quantity"></td></tr>
<tr><td>AGE GROUP</td><td><select id ="categorySelect" name="gender">
				      <option value="MEN">Men</option>
				      <option value="WOMEN">Women</option>
				      <option value="BOYS">Boys</option>
				      <option value="GIRLS">Girls</option>
				      <option value="UNISEX">Unisex</option>
				    </select>
				  </td></tr>
<tr><td>category name</td><td><input type="text" name="category.categoryName"></td></tr>
<tr><td><input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" /></td></tr>
<tr><td></td><td><input type="submit" value="Add Product"></td></tr>
</table>

</form>
<form method="POST" enctype="multipart/form-data"
		action="/upload">
		File to upload: <input type="file" name="file"><br /> Name: <input
			type="text" name="name"><br /> <br /> <input type="submit"
			value="Upload"> Press here to upload the file!
	</form>
</div>

<div class="col s12 m6 l5 card-panel teal">
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
<tr><td></td><td><input type="submit" value="update prodcut"></td></tr>
</table>
</form>
</div>
<div class="col s12 m6 l6 card-panel teal">
<form action="removeproduct" method="post" >
<table class="responsive-table">
<tr><td>Product Name</td><td><input type="text" name="productName"></td></tr>
<tr><td><input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" /></td></tr>
<tr><td></td><td><input type="submit" value="Remove Product"></td></tr>
</table>

</form>
</div>
</div>


	<!--   	  FOOTER	-->

	<footer class="page-footer">
		<%@ include file = "partials/footer.jsp"%>
	</footer>
	

</body>
</html>
<script type="text/javascript"
		src="resources/js/lib/jquery-1.10.2.js"></script>
	<script type="text/javascript"
		src="resources/js/lib/jquery-ui-1.10.4.custom.js"></script>
	<script type="text/javascript"
		src="resources/js/lib/jquery.ui.datepicker.js"/></script>

	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="resources/js/materialize.min.js"></script>
	<script type="text/javascript" src="resources/js/home-ads.js"></script>
	<script type="text/javascript" src="resources/js/custom.js"></script>