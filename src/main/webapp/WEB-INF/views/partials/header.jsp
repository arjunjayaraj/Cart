<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="nav-wrapper">
	<a href="home" ><img id="logo_img" src= "resources/images/shopify-bag.png"></a>
	<span id= "nav_title">
		<b>India-Cart</b>
	</span>
	<ul id= "categories_drop" class="right hide-on-med-and-down">
		<li id= "search_bar">
			<form>
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

				
				<div class="input-field arrange col l2 s2 m2">
					<input id="search" type="search" required>
					<label for="search"><i class="mdi-action-search"></i></label>
				</div>
			</form>
		</li>
		<li><a href="userCart.html"><i class="mdi-action-add-shopping-cart"></i></a></li>
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
					<li>
						<c:choose>
							<c:when test="${pageContext.request.isUserInRole('ROLE_ADMIN')}">
								<a href="adminHome">${pageContext.request.userPrincipal.name}</a>
							</c:when>
							<c:otherwise>
								<a href="">${pageContext.request.userPrincipal.name}</a>
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
<!-- <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script> -->
<script>
	function formSubmit() {
		document.getElementById("logoutForm").submit();
	}
	 
</script>		