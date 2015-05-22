$(document).ready(function(){
//$("#searchproduct").keyup( function() {
//			var searchQuery = $("#searchproduct").val();
//			var search = $("#categorySelect").val();
//			
//	 		window.alert(search);
//			    $.ajax({
//		            type: "GET",
//		            url: "productsearch",
//		            contentType : 'application/json; charset=utf-8',
//		            data: { "searchproduct" :searchQuery,
//		            		"category" :search,
//		            }, 
//		          
//		              success :function(result) {
//		         $("#productList").html(result);
//		            		          			
//		          }});	    
			    

					$("#searchproduct").keyup( function() {
					var searchQuery = $("#searchproduct").val();
					var search = $("#categorySelect").val();
					
			 		window.alert(search);
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



