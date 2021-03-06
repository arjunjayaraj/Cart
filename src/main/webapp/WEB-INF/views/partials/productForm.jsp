<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form class="pure-form pure-form-aligned" id="productForm">

	<fieldset>
		<legend></legend>
	<label id="error-msg" style="color: red"></label>
		<div class="pure-control-group">
		
			<label for="productName">Product Name</label>
			<input id = "productName" name = "productName" placeholder="PRODUCT NAME" required/>
			<label for="brand">Brand Name</label>
			<input id = "brand" name="brand" placeholder="BRAND NAME" />
		</div>
		<div class="pure-control-group">
			<label for="productPrice">Price</label>
			<input id = "productPrice" name="productPrice" placeholder="PRICE" type="number"/>
			<label for="quantity">Quantity</label>
			<input id = "quantity" name="quantity" placeholder="QUANTITY" type="number"/>
		</div>

	<div class="pure-control-group">

			<label for="productImage">IMAGE</label>
			<input id = "productImage" type="text" name="productImage" disabled="disabled" />
			<input type="file" name="file" id="file" />
    		<input type="button" value="upload"  onclick="upload();"/>
			</div>
			<div class="pure-control-group">
			<table>
			<tr>
			<td><label for="categoryName">Category</label>
			<input id = "categoryName" name="category.categoryName" placeholder="CATEGOEY NAME" /></td>
			<td>Age Group</td>
			<td><div id="formselectdiv">
			<select id ="productFormAge" name="gender" >
					 <option value="MEN">MEN</option>
				      <option value="WOMEN">WOMEN</option>
				      <option value="BOYS">BOYS</option>
				      <option value="GIRLS">GIRLS</option>
				      <option value="UNISEX">UNISEX</option>
			</select></div></td>
			</tr>
			</table>
			</div>
		
		</fieldset>
	
</form>

