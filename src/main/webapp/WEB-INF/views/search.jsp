<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<div class="row" >
                <c:if test="${!empty listproducts}">
                    <c:forEach items="${listproducts}" var="product">
                        <div class="col s12 m6 l3">
                            <div class="card">
                                <div class="card-image">
                                    <img class="item-image" src="resources/images/${product.productImage}"><span class="card-title" style="color: black">${product.productName}</span>
                                </div>
                                <div class="card-content">
                                    <p>${product.brand}</p>
                                </div>
                                <div class="card-action">
                                    <a class="waves-effect waves-light btn add-to-cart" onclick="Materialize.toast('<span>Added to Cart!</span><a class=&quot;btn-flat yellow-text&quot; href=&quot;#!&quot;>Undo</a>', 3000)">Add To Cart</a>
                                </div>
                            </div>
                        </div>
                      
                    </c:forEach>
                </c:if>                   
            </div>

