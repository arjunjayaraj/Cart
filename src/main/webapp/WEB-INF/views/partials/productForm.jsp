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
		<div class="pure-control-group "  style="width: inherit;">
			<label for="brand">Age Group</label>
			<select id ="productFormAge" name="gender" style="display: none;">
				      <option value="10">10</option>
				      <option value="20">20</option>
				      <option value="30">30</option>
				      <option value="40">40</option>
				      <option value="50">50</option>
				    </select>
		</div>

	</fieldset>
</form>
