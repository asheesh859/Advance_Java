<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body>
<h2>Registration page</h2>
	<form action="RegistrationController" method="post">
		Name:<input type="text" name ="name"/>
		Course : <input type="text" name="course"/>
		Email : <input type="text" name="email"/>
		mobile : <input type="text" name="mobile"/>
		<input type="submit" value="submit"/>
	<pre>
	
	</pre>
	
	</form>
	
	<%
			if(request.getAttribute("message")!=null){
				out.println(request.getAttribute("message"));
			}
		
	%>
</body>
</html>