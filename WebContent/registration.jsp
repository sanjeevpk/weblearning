<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	
	<link rel="stylesheet" type="text/css" href="resources/css/main.css" />
	<!-- <script type="text/javascript" src="resources/js/ajax.js"></script> -->
	<script type="text/javascript">
	
	function getXMLObject()  //XML OBJECT
	{
	   var xmlHttp = false;
	   try {
	     xmlHttp = new ActiveXObject("Msxml2.XMLHTTP")  // For Old Microsoft Browsers
	   }
	   catch (e) {
	     try {
	       xmlHttp = new ActiveXObject("Microsoft.XMLHTTP")  // For Microsoft IE 6.0+
	     }
	     catch (e2) {
	       xmlHttp = false   // No Browser accepts the XMLHTTP Object then false
	     }
	   }
	   if (!xmlHttp && typeof XMLHttpRequest != 'undefined') {
	     xmlHttp = new XMLHttpRequest();        //For Mozilla, Opera Browsers
	   }
	   else{
		   alert("Bwroser not supported");
	   }
	   return xmlHttp;  // Mandatory Statement returning the ajax object created
	} 	
	
	var xmlhttp = new getXMLObject();
	
	function ajaxFunction() {
		  if(xmlhttp) {
		  	var name = document.getElementById("nameTextField");
		  	var email = document.getElementById("emailTextField");
		    xmlhttp.open("POST","registration",true); //getname will be the servlet name
		    xmlhttp.onreadystatechange  = handleServerResponse;
		    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		    xmlhttp.send("nameTextField="+name.value+"&emailTextField="+email.value); //Posting txtname to Servlet
		  }
		}
		 
		function handleServerResponse() {
		   if (xmlhttp.readyState == 4) {
			   alert(xmlhttp.status);
		     if(xmlhttp.status == 200) {
		    	 alert("writing result"+xmlhttp.responseText);
		    	 document.getElementById("hello").innerHTML = xmlhttp.responseText; //Update the HTML Form element
		    	 document.getElementById("nameTextField").value = "";
		    	 document.getElementById("nameTextField").focus();
		    	 document.getElementById("emailTextField").value = "";
		     }
		     else {
		        alert("Error during AJAX call. Please try again");
		     }
		   }
		} 
	
		/* function makeRequest() {
		  var xmlHttpRequest = getXMLHttpRequest();
		  var name = document.getElementById("nameTextField");
		  var email = document.getElementById("emailTextField");
		  xmlHttpRequest.onreadystatechange = getReadyStateHandler(xmlHttpRequest);
		  xmlHttpRequest.open("POST", "registration", true);  
		  //xmlHttpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		  xmlHttpRequest.send("name=" + name.value+"&email="+email.value);
		} */
		
		/* function loadXMLDoc()
		{
			var xmlhttp;
			if (window.XMLHttpRequest)
		  		{// code for IE7+, Firefox, Chrome, Opera, Safari
		  			xmlhttp=new XMLHttpRequest();
		  		}
			else
		  		{// code for IE6, IE5
		  			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		  		}
			
			xmlhttp.onreadystatechange=function()
		  	{
		  		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		    		{
		  				alert("Updating");
		    			document.getElementById("hello").innerHTML=xmlhttp.responseText;
		    		}
		  	}
			xmlhttp.open("POST","registration",true);
			xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			xmlhttp.send("nameTextField=Henry&emailTextField=Ford");
		} */
	</script>
	</head>

	<body>
		<form method="POST" action="registration" name ="myForm"> 
			<table>
				<tr>
					<td>
						Name:
					</td>
				</tr>
				<tr>
					<td>
						<input type="text" name="nameTextField" id="nameTextField">
					</td>
				</tr>
				<tr>
					<td>
						Email:
					</td>
				</tr>
				<tr>
					<td>
						<input type="text" name="emailTextField" id="emailTextField">
					</td>
				</tr>
				<tr>
					<td>
					</td>
				</tr>
				<tr>
					<td>
						<input type="button" value="Register" onclick="ajaxFunction()">
					</td>
				</tr>
			</table>
			
		</form> 
		<div id="hello"> 
		</div>
	</body>
</html>