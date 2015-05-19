<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:url var="actionUrl" value="adminUserEdit" />

<form:form id="userForm" commandName="user" method="post"
	action="${actionUrl}">

		<label for="name">Email</label>
		<form:input name = "customerId" path="name" placeholder="Book Name" />
		<label for="code">First Name</label>
			<form:input name="merocode" id = "merocode" path="code" placeholder="Code" maxlength="15" />
			<label for="price">Last Name</label>
			<form:input path="price" placeholder="Price"
				maxlength="10" />
			<label for="authors">Password</label>
			<form:input path="password" placeholder="Password" />
</form:form>