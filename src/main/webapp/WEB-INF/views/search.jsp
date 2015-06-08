<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

     <div class="row" >
                <c:if test="${!empty listproducts}">
                    <c:forEach items="${listproducts}" var="product">
                        <div class="col s12 m6 l3">
                            <div class="card product-card">
                                <div class="card-image">
                                    <img class="item-image product-item-image" src="resources/images/${product.productImage}"><span class="card-title" style="color: black">Brand:${product.brand}</span>
                                </div>
                                <div class="card-content product-content">
                                    <p>${product.productName}</p>
                                    <c:choose>
                                    <c:when test="${pageContext.request.isUserInRole('ROLE_ADMIN')}">
                                    <a class="waves-effect waves-light btn product-change"  onclick="editProduct('${product.productId}','${product.productName}','${product.brand}','${product.quantity}','${product.productPrice}','${product.productImage}','${product.category.categoryName}','${product.gender}')">EDIT</a>
                                    <a class="waves-effect waves-light btn product-change" onclick="deleteProduct('${product.productName}','${product.productId}')">DELETE</a>
                                    </c:when>
                                    </c:choose>
                
                                </div>
                                
                                <div class="card-action">
                                    <a class="waves-effect waves-light btn add-to-cart" onclick="addtoCart('${product.productName}');">Add To Cart</a>
                                </div>
                                
                            </div>
                        </div>
                      
                    </c:forEach>
                </c:if>                   
            </div>

