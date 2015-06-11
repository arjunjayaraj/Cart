<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>


<div class="row">
	<c:if test="${!empty listproducts}">
		<c:forEach items="${listproducts}" var="product">
			<div class="col s12 m6 l3">
				<div class="card product-card">
					<div class="card-image">
						<img class="item-image product-item-image"
							src="resources/images/${product.productImage}"
							onclick="productDescription('${product.productId}')">
					</div>
					<div class="card-content product-content">
						<p>${product.productName}</p>
						<p>Price:${product.productPrice}</p>


						<sec:authorize access="hasRole('ROLE_ADMIN')">




							<a class="waves-effect waves-light btn product-change"
								onclick="editProduct('${product.productId}','${product.productName}','${product.brand}','${product.quantity}','${product.productPrice}','${product.productImage}','${product.category.categoryName}','${product.gender}')">EDIT</a>
							<a class="waves-effect waves-light btn product-change"
								onclick="deleteProduct('${product.productName}','${product.productId}')">DELETE</a>
						</sec:authorize>


					</div>
					<c:if test="$(product.quantity)!=0">
						<div class="card-action">
							<a class="waves-effect waves-light btn add-to-cart"
								onclick="addtoCart('${product.productName}');">Add To Cart</a>
						</div>
					</c:if>

				</div>
			</div>

		</c:forEach>
	</c:if>
</div>
>>>>>>> dev

