var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
function searchForm() {
	var searchQuery = $("#searchproduct").val();
	var search = $("#categorySelect").val();
	
		    $.ajax({
            type: "GET",
            url: "productsearch",
            contentType : 'application/json; charset=utf-8',
            data: { "searchproduct" :searchQuery,
            		"category" :search,
            }, 
                     
              success :function(result) {
         $("#productList").html(result);
            		          			
          }});	    
		
}
function deleteProduct(productName,id){
	
	var x = confirm('Are you sure you want to delete this Product? '+productName);
	if (x == true)
	{
	$.ajax({
        type: "GET",
        url: "removeproduct",
        contentType : 'application/json; charset=utf-8',
        data: { "productName" : productName,
        		"id":id
          }, 
        success :function(result) {
        	location.reload();
       }
    });
	}
}
var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
function filter() {
    var select = document.getElementById("brandFilter");
   	var i;
   	var searchQuery = $("#searchproduct").val();
	var search = $("#categorySelect").val();
	var filters={};
	filters.search=searchQuery;
	filters.ageGroup=search
	filters.brand=[];
	filters.category=[];
	filters.availability=0;
	filters.maximumPrice=$("#priceinput").val();
	$('#brandFilter input:checked').each(function() {
			filters.brand.push($(this).attr('value'));
		});
	$('#categoryFilter input:checked').each(function() {
		filters.category.push($(this).attr('value'));
	});



	$('#quantityFilter input:checked').each(function() {
		filters.availability=$(this).attr('value');
	});
		  
		    $.ajax({
            type: "POST",
            url: "filter",
            contentType : 'application/json; charset=utf-8',
            data: JSON.stringify(filters),
            beforeSend: function(xhr){
                xhr.setRequestHeader(header, token);
              },  
              success :function(result) {
         $("#productList").html(result);
            		          			
          }});	    
		
}

var productId;
var productImage;
function addProduct() {
	$("#productDialog").html();
	$('#productDialog').dialog("option", "title", "ADD Product");
	$("#productDialog").dialog('open');
	productId=0;
	productImage=null;
}

function editProduct(id,name,brand,quantity,price,image,category,gender) {
	$("#productName").val(name);
	$("#brand").val(brand);
	$("#productPrice").val(price);
	$("#quantity").val(quantity);
	$("#categoryName").val(category);
	$("#productImage").val(image);
	productId=id;
	$("#productDialog").html();
	$('#productDialog').dialog("option", "title", "Edit Product");
	$("#productDialog").dialog('open');
	$("#productFormAge option[value=" + gender + "]").attr('selected', 'selected'); 
	$('select').material_select();
	}

$(document).ready(function() {
	$('#productDialog').dialog({
		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		top:0,
		width : 850,
		buttons : {
			"Save" : function() {

				
				var product={};
					product.category={};
					product.category.categoryName=document.getElementById("categoryName").value;
					product.quantity=document.getElementById("quantity").value;
					product.productName=document.getElementById("productName").value;
					product.productPrice=document.getElementById("productPrice").value;
					product.brand=document.getElementById("brand").value;
					product.gender=document.getElementById("productFormAge").value;
					product.productImage=document.getElementById("productImage").value;
				var oMyForm = new FormData();
					oMyForm.append("file", file.files[0]);
				if(productId==0){
					product.productId=productId;
					oMyForm.append("product",JSON.stringify(product));
					$.ajax({
				            url: "adproduct",
				            data: oMyForm,
				            dataType: 'text',
				            processData: false,
				            contentType: false,
				            type: 'POST',
				            beforeSend: function(xhr){
				                xhr.setRequestHeader(header, token);
				              },  
				              success :function(result) {
				            	  location.reload();
				            	  filter();
				                   		          			
				          }});	    
				
				}
				else{
					product.productId=productId;
					oMyForm.append("product",JSON.stringify(product));
					$.ajax({
			            url: "upproduct",
			            data: oMyForm,
			            dataType: 'text',
			            processData: false,
			            contentType: false,
			            type: 'POST',
			            beforeSend: function(xhr){
			                xhr.setRequestHeader(header, token);
			              },  
			              success :function(result) {
			            	  location.reload();
			            	  filter();
			                   		          			
			          }});	    
					
					
				}
				
			},
			"Cancel" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#productDialog'));

			$(this).dialog('close');
		}
	});
	
});

function upload(){
	var path = $("#file").val();
	var filename = path.substring(path.lastIndexOf("\\") + 1);
	$("#productImage").val(filename);
}

function addtoCart(productName)
{
	var curUser = $("#curUser").html();
	Materialize.toast('Added To Cart', 1000);
	
	$.ajax({
        type: "GET",
        url: "userAddToCart",
        contentType : 'application/json; charset=utf-8',
        data: { "productname" :productName,
        	"user": curUser
        }, 
          success :function(result) {/* 
       
        	  location.reload();
        		          			
       */}});	    
	}

function resetDialog(form) {
	form.find("input").val("");
}
function formSubmit() {
	document.getElementById("logoutForm").submit();
}
function productDescription(){
	$("#productDescription").css("display", "block")
	$("#backgroundDiv").css("display", "block")
}


