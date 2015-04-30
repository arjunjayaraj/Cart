
$(document).ready(function(){

	/*$("#register-submit").click(function(){
		
		var firstName= $('#first-name').val();
		var lastName=$('#last-name').val();
		var password=$('#register-password').val();
		var confirmPassword=$("#confirm-password").val();
		var email=$("#register-email").val();
		
		 if(password !=confirmPassword){
			
			$('#error-msg').html("Password Mismatch!!");
		}
		var data = 'fName='
			+ encodeURIComponent(firstname)
			+ '&amp;lName='
			+ encodeURIComponent(lastname)
			+'&amp;email='
			+encodeURIComponent(email)
			+'&amp;passwd='
			+encodeURIComponent(passwd);
		
		alert(firstName +""+password);
		$.ajax({
		    type : "GET",
		    url : "register",
		    data : data,
		    success : function(response) {
		       alert("Success");
		    },
		    error : function(e) {
		       alert('Error: ' + e);
		    }
		}); 
	});
	*/


	$('.alphabets-only').keydown(function (e) {
		if (e.ctrlKey || e.altKey) {
		e.preventDefault();
		} else {
		var key = e.keyCode;
		if (!((key == 8) ||(key == 32) || (key == 46) || (key >= 35 && key <= 40) || (key >= 65 && key <= 90))) {
		e.preventDefault();
		}
		}
		});
	
	//check for the validity of the email
	function validateEmail(email) {
	    var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
	    return re.test(email);//returns true if the email id is in proper format
	}
	
	
	
});