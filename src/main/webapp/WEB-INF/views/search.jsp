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
                                    <a class="waves-effect waves-light btn add-to-cart" onclick="addtoCart('${product.productName}');">Undo</a>', 3000)">Add To Cart</a>
                                </div>
                            </div>
                        </div>
                      
                    </c:forEach>
                </c:if>                   
            </div>

<script>
addtoCart(productName)
{
	var curUser = $("#curUser").html();
	alert(productName);
	$.ajax({
        type: "GET",
        url: "userAddToCart",
        contentType : 'application/json; charset=utf-8',
        data: { "productname" :productName,
        	"user": curUser
        }, 
          success :function(result) {
        	  location.reload();
        		          			
      }});	    
	}
</script>