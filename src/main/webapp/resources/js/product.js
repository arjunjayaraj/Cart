$(document).ready(function(){
	$("#searchproduct").keyup( function() {
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
						
				});
				
					
					
			    
				
		});

function deleteProduct(productName){
	
	var x = confirm('Are you sure you want to delete this Product? '+productName);
	if (x == true)
	{
	$.ajax({
        type: "GET",
        url: "removeproduct",
        contentType : 'application/json; charset=utf-8',
        data: { "productName" : productName
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
	for (i = 0; i < select.length; i++) {
        if (select[i].checked) {
           filters.brand.push(select[i].value);
        }
    }
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
function addProduct() {
	$("#productDialog").html();
	$('#productDialog').dialog("option", "title", "ADD Product");
	$("#productDialog").dialog('open');
	productId=0;
}

function editProduct(id,name,brand,quantity,price,image,category,gender) {
	$("#productDialog").html();
	$('#productDialog').dialog("option", "title", "Edit Product");
	$("#productDialog").dialog('open');
	$("#productName").val(name);
	$("#brand").val(brand);
	$("#productPrice").val(price);
	$("#quantity").val(quantity);
	$("#categoryName").val(category);
	productId=id;
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
					product.productImage=[];
					product.category.categoryName=document.getElementById("categoryName").value;
					product.quantity=document.getElementById("quantity").value;
					product.productName=document.getElementById("productName").value;
					product.productPrice=document.getElementById("productPrice").value;
					product.brand=document.getElementById("brand").value;
					product.gender=document.getElementById("productFormAge").value;
					product.productImage=document.getElementById("productImage").value;
					console.log(product);
				if(productId==0){
					product.productId=productId;
					$.ajax({
		        	    type: "POST",
		       	    	url: "adproduct",
			            contentType : 'application/json; charset=utf-8',
			            data: JSON.stringify(product),
			            beforeSend: function(xhr){
			                xhr.setRequestHeader(header, token);
			              },
			    	    success :function(result) {
			        	    	location.reload();
			           		}
			        	});
				
				}
				else{
					$.ajax({
		        	    type: "POST",
		       	    	url: "upproduct",
			            contentType : 'application/json; charset=utf-8',
			            data: JSON.stringify(product),
			            beforeSend: function(xhr){
			                xhr.setRequestHeader(header, token);
			              },
			    	    success :function(result) {
			        	    	location.reload();
			           		}
			        	});
					
					
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

function resetDialog(form) {
	form.find("input").val("");
}
function formSubmit() {
	document.getElementById("logoutForm").submit();
}




