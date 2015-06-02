<html>
<head>
 <meta name="_csrf" content="${_csrf.token}"/>
    <!-- default header name is X-CSRF-TOKEN -->
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
 <link type="text/css" rel="stylesheet" href="resources/css/materialize.min.css" media="screen,projection" />
	    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

</head>
<body>
<h2>Spring MVC file upload example</h2>

<form method="POST" action="upload"
    enctype="multipart/form-data">

<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
    Please select a file to upload : <input type="file" name="file" id="file" />
    <input type="button" value="upload"  onclick="test();"/>

</form>


</body>
<script type="text/javascript"
		src="resources/js/lib/jquery-1.10.2.js"></script>
	<script type="text/javascript"
		src="resources/js/lib/jquery-ui-1.10.4.custom.js"></script>
	<script type="text/javascript"
		src="resources/js/lib/jquery.ui.datepicker.js"/></script>

	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="resources/js/materialize.min.js"></script>
	<script type="text/javascript" src="resources/js/home-ads.js"></script>
	<script type="text/javascript" src="resources/js/custom.js"></script>
</html>
<script>
var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
function test(){
		var searchQuery = $("#file").val();
		var filename = searchQuery.substring(searchQuery.lastIndexOf("\\") + 1);
		var oMyForm = new FormData();
		oMyForm.append("file", file.files[0]);
	
		    $.ajax({
            url: "imageupload",
            data: oMyForm,
            dataType: 'text',
            processData: false,
            contentType: false,
            type: 'POST',
            beforeSend: function(xhr){
                xhr.setRequestHeader(header, token);
              },  
              success :function(result) {
                   		          			
          }});	    
}


</script>