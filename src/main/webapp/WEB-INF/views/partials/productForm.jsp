<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form class="pure-form pure-form-aligned">

	<fieldset>
		<legend></legend>

		<div class="pure-control-group">
			<label for="productName">Product Name</label>
			<input id = "productName" name = "productName" placeholder="PRODUCT NAME" required/>
			<label for="brand">Brand Name</label>
			<input id = "brand" name="brand" placeholder="BRAND NAME" />
		</div>
		<div class="pure-control-group">
			<label for="productPrice">Price</label>
			<input id = "productPrice" name="productPrice" placeholder="PRICE" />
			<label for="quantity">Quantity</label>
			<input id = "quantity" name="quantity" placeholder="QUANTITY" />
		</div>

	<div class="pure-control-group">
			<label for="categoryName">Category</label>
			<input id = "categoryName" name="category.categoryName" placeholder="CATEGOEY NAME" />
			<label for="productImage">IMAGE</label>
			<input id = "productImage" type="file" name="productImage" style="width: 220px;" />
		</div>
	<div class="pure-control-group" style="width: 240px;background-color: white; margin-left: 140px;color: black;">
	<select id ="productFormAge" name="gender" style="width:100px;padding-left: 20px;display:none">
					 <option value="MEN">MEN</option>
				      <option value="WOMEN">WOMEN</option>
				      <option value="BOYS">BOYS</option>
				      <option value="GIRLS">GIRLS</option>
				      <option value="UNISEX">UNISEX</option>
			</select>
		</div>
	</fieldset>
</form>
