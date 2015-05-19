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
		<%@ include file = "partials/header.jsp"%>
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
					<td>
						<c:set var="flag" value="${0}"></c:set>
						<c:forEach items="${user.userRole}" var="userrole">
							<c:choose>
								<c:when test="${role == userrole.role}">
									<c:set var="flag" value="${1}"></c:set>
								</c:when>
							</c:choose>
						</c:forEach>
						<c:choose>
							<c:when test="${flag==1}">
								<i class="small mdi-action-done"></i>
								<button onclick="deleteRole('${user.email}','${role}')">Delete This Role</button>
							</c:when>
							<c:otherwise>
								<button onclick="addRole('${user.email}','${role}')">Add This Role</button>
							</c:otherwise>
						</c:choose>
					</td>
				</c:forEach>
					<td>
						<nobr>
							<button onclick="editInfo(${user.email});">Edit</button>
							<button onclick="deleteUser('${user.email}');">Delete</button>
						</nobr>
					</td>
				</tr>
		</c:forEach>
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

	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="resources/js/materialize.min.js"></script>
	<script type="text/javascript" src="resources/js/home-ads.js"></script>
	<script type="text/javascript" src="resources/js/custom.js"></script>
	<script>
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
		
		var x = confirm('Are you sure you want to delete this role?');
		if (x == true)
		{
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
	}
	function deleteUser(email){
		
		var x = confirm('Are you sure you want to delete this User? '+email);
		if (x == true)
		{
		$.ajax({
            type: "GET",
            url: "adminUserDelete",
            contentType : 'application/json; charset=utf-8',
            data: { "email" : email
              }, 
            success :function(result) {
            	location.reload();
           }
        });
		}
		
		function addUser() {
			$('#bookDialog').dialog("option", "title", 'Add User');
			$('#bookDialog').dialog('open');
		}

		function editUser(id) {

			$.get("editUserLoad", function(result) {

				$("#bookDialog").html(result);

				$('#bookDialog').dialog("option", "title", 'Edit User');

				$("#bookDialog").dialog('open');

				initializeDatePicker();
			});
		}
		
	}
	</script>
</body>
</html>