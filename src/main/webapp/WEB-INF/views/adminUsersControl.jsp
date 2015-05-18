<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>

<head>
<title>AdminUsersControl</title>

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
	<nav>
		<div class="nav-wrapper">
			<a href="#!"><img id="logo_img"
				src="resources/images/shopify-bag.png"></a> <span id="nav_title"><b>India-Cart</b></span>
			<ul id="categories_drop" class="right hide-on-med-and-down">
				<li><c:url value="/j_spring_security_logout" var="logoutUrl" />
					<form action="${logoutUrl}" method="post" id="logoutForm"
						style="margin-bottom: 0px;">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form> <script>
					function formSubmit() {
						document.getElementById("logoutForm").submit();
					}
				</script> <a class='dropdown-button' data-constrainwidth="false"
					data-beloworigin="true" href='#' data-activates='dropdown1'> <i
						class="mdi-action-account-circle"></i>
				</a> <c:if test="${pageContext.request.userPrincipal.name != null}">
						<!-- Dropdown Structure -->
						<ul id='dropdown1' class='dropdown-content'>
							<li><a href="#!">${pageContext.request.userPrincipal.name}</a></li>
							<li><a href="javascript:formSubmit()">Logout</a></li>
						</ul>
					</c:if></li>
			</ul>
		</div>
	</nav>
	<div>
		<table>
			<thead>
				<tr>
					<th width="10%">SL No</th>
					<th width="20%">Email</th>
					<th width="15%">First Name</th>
					<th width="15%">Last Name</th>
					<c:forEach items="${roles}" var="roles">
						<th width="10%" id="${roles}">${roles}</th>
					</c:forEach>
					<th width="20%"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listUsers}" var="user" varStatus="loopCounter">
					<tr>
						<td><c:out value="${loopCounter.count}" /></td>
						<td><c:out value="${user.email}" /></td>
						<td><c:out value="${user.fName}" /></td>
						<td><c:out value="${user.lName}" /></td>
						<c:forEach items="${roles}" var="role">
							<td><c:set var="flag" value="${0}"></c:set> <c:forEach
									items="${user.userRole}" var="userrole">
									<c:choose>
										<c:when test="${role == userrole.role}">
											<c:set var="flag" value="${1}"></c:set>
										</c:when>
									</c:choose>
								</c:forEach> <c:choose>
									<c:when test="${flag==1}">
										<i class="small mdi-action-done"></i>
										<button onclick="deleteRole('${user.email}','${role}')">Delete</button>
									</c:when>
									<c:otherwise>
										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
										<button onclick="addRole('${user.email}','${role}')">Add This Role</button>
									 <%-- 	<a href="adminAddRole?${user.email}&${role}">Add This Role</a> --%>
									</c:otherwise>
								</c:choose></td>
						</c:forEach>

						<td><nobr>
								<button onclick="addRole(${user.email});">Edit</button>
								<%-- <a onclick="return confirm('Are you sure you want to delete this book?');"
									href="delete/${user.email}">Delete</a>
								<button onclick="deleteRole('${user.email}','${role}')">Delete</button> --%>
							</nobr></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
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
	<!-- Import scripts -->

	<!--  It is advised to put the <script> tags at the end of the document body so they don't block rendering of the page -->
	<script type="text/javascript"
		src='<c:url value="resources/js/lib/jquery-1.10.2.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="resources/js/lib/jquery-ui-1.10.4.custom.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="resources/js/lib/jquery.ui.datepicker.js"/>'></script>

	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="resources/js/materialize.min.js"></script>
	<script type="text/javascript" src="resources/js/home-ads.js"></script>
	<script type="text/javascript" src="resources/js/custom.js"></script>
	<script type="text/javascript">
	function addRole(email,role){
		
		alert(role);
		$.ajax({
            type: "GET",
            url: "adminAddRole",
            contentType : 'application/json; charset=utf-8',
            data: { "role" :role,
            		"email" : email
              }, 
            success :function(result) {
            	location.reload();
           }
        });
		}
	function deleteRole(email,role){
		
		confirm('Are you sure you want to delete this role?');
		$.ajax({
            type: "GET",
            url: "adminDeleteRole",
            contentType : 'application/json; charset=utf-8',
            data: { "role" :role,
            		"email" : email
              }, 
            success :function(result) {
            	location.reload();
           }
        });
		}
	</script>
</body>
</html>