<a class="closeButton" onclick=closeBtn();>x</a>
<div id="productDescriptionWrap">
<div id="ImageDiv">
<img alt="product-image" src="resources/images/${product.productImage}" id="images">
</div>
<div id="description">
<p class="productDescriptionTag">Product Name:${product.productName} </p>
<p class="productDescriptionTag">Brand: ${product.brand}</p>
<p class="productDescriptionTag">Price: Rs.${product.productPrice}</p>
<p class="productDescriptionTag">Age Group: ${product.gender}</p>
<p class="productDescriptionTag">Category:${product.category.categoryName}</p>

</div>
</div>
