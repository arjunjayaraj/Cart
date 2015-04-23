
$(document).ready(function(){

	//check the validity on login submit
	$('#login-submit').click(function(){
		alert("dsaf");
		var loginEmail= $('#login-email').val();
		var loginPassword=$('#login-password').val();
		if(validateEmail(loginEmail)){
			$('#error-msg').html("");
		
		}
		else{
			$('#error-msg').html("Invalid email/password");
		}
	});
	
//	$("#register-submit").click(function(){
//		var firstName= $('#first-name').val();
//		var lastName=$('#last-name').val();
//		var password=$('#register-password').val();
//		var confirmPassword=$("#confirm-password").val();
//		var email=$("#register-email").val();
//		if(firstName==""|| lastName==""){
//			$('#error-msg').html("Enter your name");
//		}
//		else if(email==""){
//			$('#error-msg').html("Enter your email id");
//		}
//		else if(confirmPassword=="" || password== ""){
//			$('#error-msg').html("Enter password");
//		}
//		else if(password !=confirmPassword){
//			alert("sadsa");
//			$('#error-msg').html("Password Mismatch!!");
//		}
//	});
	function validateRegisterForm() {
		var firstName= $('#first-name').val();
		var lastName=$('#last-name').val();
		var password=$('#register-password').val();
		var confirmPassword=$("#confirm-password").val();
		var email=$("#register-email").val();
		if(firstName==""|| lastName==""){
			$('#error-msg').html("Enter your name");
			return false;
		}
		else if(email==""){
			$('#error-msg').html("Enter your email id");
			return false;
		}
		else if(confirmPassword=="" || password== ""){
			$('#error-msg').html("Enter password");
			return false;
		}
		else if(password !=confirmPassword){
			$('#error-msg').html("Password Mismatch!!");
			alert("sadsa");
			return false;
		}
		else {
			return true;
		}
	}

	
	
	//check for the validity of the email
	function validateEmail(email) {
	    var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
	    return re.test(email);//returns true if the email id is in proper format
	}
	
	
	
});