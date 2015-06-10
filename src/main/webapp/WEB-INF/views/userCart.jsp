<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="_csrf" content="${_csrf.token}"/>
    <!-- default header name is X-CSRF-TOKEN -->
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
	<!--Import materialize.css-->
<link href="resources/css/materialize.css" rel="stylesheet">
		<link href="resources/css/materialize.min.css" rel="stylesheet">
		<link href="resources/css/login.css" rel="stylesheet">
		<link type="text/css" rel="stylesheet" href="resources/css/home.css" media="screen,projection" />

	<!--Let browser know website is optimized for mobile-->
	<meta name="viewport"
			content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title>UserCart</title>
</head>
<body>
	<nav>
		<%@ include file = "partials/header.jsp"%>
	</nav>

	<div>
		<h1>Cart</h1>
	</div>
	<div>
		<table style="margin-left: 10%;">
            <c:set var="subtotal" value="${0}"></c:set>
			<thead>
				<tr>
					<th width="20%">ITEM</th>
					<th width="10%">QTY</th>
					<th width="10%">PRICE</th>
					<th width="10%">SUBTOTAL</th>
					<th width="10%">DELETE</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listCart}" var="cart">
					<tr>
						 <c:set var="total" value="${total+ (cart.product.productPrice*cart.qty)}"></c:set> 
						<td>
						<img src="resources/images/${cart.product.productImage}" style="width: 10%;height:auto;">	
						<c:out value="${cart.product.productName}"/>
								</td>
						<td><input id="quantity${cart.cartId}" type="text" value="${cart.qty}" style="width:31%;height: auto;"/>
						<a href= "javascript:updateQuantity('${cart.cartId}','${cart.qty}')" style="display: block;">save</a></td>
						<td><c:out value="${cart.product.productPrice}"/></td>
						<td><c:out value="${cart.product.productPrice*cart.qty}"></c:out></td>
						<td><button onclick="deleteitem('${cart.cartId}')">Delete</button> </td>
					</tr>
				</c:forEach>
				
			
				<c:if test="${!empty listCart}">
					<tr>
				<td></td><td></td>
				<td>TOTAL</td><td><c:out value="${total}"></c:out></td>
				<td><button onclick="deleteallitems()">Delete All</button> </td>
				</tr>
				<tr>
				<td></td>
				<td></td>
				<td><button class="btn waves-effect waves-light" type="submit" name="placeOrder">PLACE ORDER
    <i class="mdi-content-send right"></i>
  </button></td>
				</tr>
				</c:if>
				
				
			</tbody>
		</table>
	</div>
	<!--   	  FOOTER	-->

	<footer class="page-footer">
		<%@ include file = "partials/footer.jsp"%>
	</footer>
	
	
	<!-- Import scripts -->

	<!--  It is advised to put the <script> tags at the end of the document body so they don't block rendering of the page -->
	<script type="text/javascript"
		src="resources/js/lib/jquery-1.10.2.js"></script>
	<script type="text/javascript"
		src="resources/js/lib/jquery-ui-1.10.4.custom.js"></script>
	<script type="text/javascript"
		src="resources/js/lib/jquery.ui.datepicker.js"/></script>
<!-- 
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script> -->
		<script src="resources/js/materialize.js"></script>
		<script src="resources/js/materialize.min.js"></script>
	<script type="text/javascript" src="resources/js/materialize.min.js"></script>
	<script type="text/javascript" src="resources/js/home-ads.js"></script>
	<script type="text/javascript" src="resources/js/custom.js"></script>
<script>
var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
function updateQuantity(id,curqty){
	var curUser = $("#curUser").html();
	var newqty=$("#quantity"+id).val();
	if(newqty!=curqty){
	$.ajax({
		type:"GET",
		url: "cartUpdateQuantity",
        contentType : 'application/json; charset=utf-8',
        data: {"quantity":newqty,
        	   "id":id,
        	   },
		beforeSend: function(xhr){
            xhr.setRequestHeader(header, token);
          },  
          success :function(result) {
        	  location.reload();
          }})	
         
		
	}
	
	
}


</script>
</body>
</html>
