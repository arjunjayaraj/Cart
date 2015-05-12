
$(document).ready(function(){
	
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
	
/*	$("#reg-submit").click(function(){
			var firstName= $('#first-name').val();
			var lastName=$('#last-name').val();
			var password=$('#register-password').val();
			var confirmPassword=$("#confirm-password").val();
			var email=$("#register-email").val();
	if(password !=confirmPassword){
		$('#error-msg').html("Password Mismatch!!!!!!!");
		}
			var search = {
             "fName" : firstName,
             "lName" : lastName,
             "email" : email,
             "password" : password
          }
          $.ajax({
             type: "POST",
             contentType : 'application/json; charset=utf-8',
             dataType : 'json',
             url: "register",
             data: JSON.stringify(search), // Note it is important
             success :function(result) {
            	 alert("123");
              // do what ever you want with data
            }
         });

});*/
});