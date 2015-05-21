<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="actionUrl" value="save" />
<%-- <%= request.getParameter("buttonName") %>
<c:forEach items="${listUsers}" var="user" varStatus="loopCounter">
<c:if test="${request.getParameter('buttonName') == user.email}">
 --%>
<form class="pure-form pure-form-aligned">

	<fieldset>
		<legend></legend>

		<div class="pure-control-group">
			<label for="name">Email</label>
			<input id = "email" name = "email" placeholder="Email" />
		</div>
		<div class="pure-control-group">
			<label for="fName">First Name</label>
			<input id = "fname" name="fName" placeholder="First Name" />
		</div>
		<div class="pure-control-group">
			<label for="lName">Last Name</label>
			<input id = "lname" name="fName" placeholder="Last Name"/>
		</div>

	</fieldset>
</form>
<%-- 
</c:if>
</c:forEach> --%>
<%-- 
<form:form id="userForm" commandName="user" method="post"
	action="${actionUrl}" class="pure-form pure-form-aligned">

	<fieldset>
		<legend></legend>

		<div class="pure-control-group">
			<label for="name">Email</label>
			<form:input name = "email" path="email" placeholder="Email" />
		</div>
		<div class="pure-control-group">
			<label for="fName">First Name</label>
			<form:input name="merocode" id = "merocode" path="fName" placeholder="First Name" />
		</div>
		<div class="pure-control-group">
			<label for="lName">Last Name</label>
			<form:input path="lName" placeholder="Last Name"/>
		</div>

	</fieldset>
</form:form> --%>