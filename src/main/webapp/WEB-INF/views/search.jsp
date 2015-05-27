<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
  <div class="row" >
                <c:if test="${!empty listproducts}">
                    <c:forEach items="${listproducts}" var="product">
                        <div class="col s12 m6 l3">
                            <div class="card product-card" >
                                <div class="card-image">
                                    <img class="item-image product-item-image" src="resources/images/${product.productImage}" style="max-height: 150px"><span class="card-title" style="color: black">Brand:${product.brand}</span>
                                </div>
                                <div class="card-content product-content" > 
                                    <p>${product.productName}</p>
                                    <p>Price: ${product.productPrice}</p>
                                    <c:choose>
                                    <c:when test="${pageContext.request.isUserInRole('ROLE_ADMIN')}">
                                    <a class="waves-effect waves-light btn product-change"  onclick="editProduct('${product.productId}','${product.productName}','${product.brand}','${product.quantity}','${product.productPrice}','${product.productImage}','${product.category.categoryName}','${product.gender}')">EDIT</a>
                                    <a class="waves-effect waves-light btn product-change" onclick="deleteProduct('${product.productName}')">DELETE</a>
                                    </c:when>
                                    </c:choose>
                                </div>
                                <div class="card-action">
                                    <a class="waves-effect waves-light btn add-to-cart" onclick="Materialize.toast('<span>Added to Cart!</span><a class=&quot;btn-flat yellow-text&quot; href=&quot;#!&quot;>Undo</a>', 3000)">Add To Cart</a>
                                </div>
                            </div>
                        </div>
                      
                    </c:forEach>
                </c:if>                   
            </div>

