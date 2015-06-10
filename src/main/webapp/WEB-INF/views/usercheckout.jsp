<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
	<head>
		<title>Home</title>
		
		<!--Import materialize.css-->
      	<link type="text/css" rel="stylesheet" href="resources/css/materialize.min.css"  media="screen,projection"/>
	  	<link type="text/css" rel="stylesheet" href="resources/css/home.css"  media="screen,projection"/>
    	
    	<!-- Import scripts -->
      	<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
      	<script  type="text/javascript" src="resources/js/materialize.min.js"></script>
      	<script  type="text/javascript" src="resources/js/home-ads.js"></script>
      	<script type="text/javascript" src="resources/js/custom.js"></script>
    	
    	<!--Let browser know website is optimized for mobile-->
      	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
	</head>
	
	<body>
		<nav>
			<%@ include file = "partials/header.jsp"%>
		</nav>
		<div class="container">
<div class ="row">
<div class="col l12 s12 m12">
<form class="col l12 m12 s12" id ="paymentform" action="">
<h3>Billing Information</h3>
      <div class="row">
        <div class="input-field col l4 s12">
          <i class="mdi-action-account-circle prefix"></i>
          <input id="icon_prefix" type="text" class="validate">
          <label for="icon_prefix">First Name</label>
        </div>
         <div class="input-field col l4 s12">
          <i class="mdi-action-account-circle prefix"></i>
          <input id="icon_prefix" type="text" class="validate">
          <label for="icon_prefix">Middle Name</label>
        </div>
         <div class="input-field col l4 s12">
          <i class="mdi-action-account-circle prefix"></i>
          <input id="icon_prefix" type="text" class="validate">
          <label for="icon_prefix">Last Name</label>
        </div>
        <div class="input-field col l4 s12">
          <i class="mdi-communication-phone prefix"></i>
          <input id="icon_telephone" type="tel" class="validate">
          <label for="icon_telephone">Telephone</label>
        </div>
        <div class="input-field col l4 s12">
          <input id="email" type="email" class="validate" disabled="disabled" value="${pageContext.request.userPrincipal.name}">
          <label for="email">Email</label>
        </div>
        <div class="input-field col l4 s12">
          <input id="amount" type="number" class="validate" disabled="disabled" value="${amount}">
          <label for="amount">Amount</label>
        </div>
      </div>
      <h3>Address</h3>
      <div class="row">
        <div class="input-field col l4 s12">
          <input id="houseName" type="text" class="validate">
          <label for="houseName">House Name</label>
        </div>
         <div class="input-field col l4 s12">
          <input id="streetName" type="text" class="validate">
          <label for="streetName">Street Name</label>
        </div>
         <div class="input-field col l4 s12">
          <input id="postOffice" type="text" class="validate">
          <label for="postOffice">Post Office</label>
        </div>
        <div class="input-field col l4 s12">
         <input id="city" type="text" class="validate">
          <label for="city">City</label>
        </div>
        <div class="input-field col l4 s12">
          <input id="state" type="text" class="validate">
          <label for="state">State</label>
        </div>
        
      </div>
        <h3>Payment</h3>
      <div class="row">
        <div class="col s12">
      <ul class="tabs">
        <li class="tab col s3"><a class="active"  href="#card1">Payment using Card</a></li>
        <li class="tab col s3"><a href="#test2">Test 2</a></li>
        <li class="tab col s3"><a href="#test3">Test 3</a></li>
        <li class="tab col s3"><a href="#test4">Test 4</a></li>
      </ul>
    </div>
    <div id="card1" class="col s12"><div style="padding-top: 5%"><script
    src="https://checkout.stripe.com/checkout.js" class="stripe-button"
    data-key="pk_test_6pRNASCoBOKtIshFeQd4XMUh"
    data-amount="${amount}"
    data-name="Demo Site"
    data-description="India cart Payment"
    data-image="resources/images/shopify-bag.png">
  </script>
  	</div>
  </div>
    <div id="test2" class="col s12">Test 2</div>
    <div id="test3" class="col s12">Test 3</div>
    <div id="test4" class="col s12">Test 4</div>
      </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
     </form>
    


</div>
</div>
</div>

	<footer class="page-footer">
		<%@ include file = "partials/footer.jsp"%>
	</footer>
</body>
<script type="text/javascript">
$(function() { 
    $("#paymentform").submit(function() { 
    	var address=$("#houseName").val() +"/n"+$("#streetName").val()+"/n"+$("#postOffice").val()+"/n"+$("#city").val()+"/n";
    	alert(address);
           return false;
    });
});
</script>
</html>
