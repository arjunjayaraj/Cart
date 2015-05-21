$(document).ready(function(){
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