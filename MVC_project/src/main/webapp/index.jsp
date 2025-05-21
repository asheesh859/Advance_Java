<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign in</title>
</head>
<body>
 <form action="login" method="post">
 
 	Email : <input type="text" name="email"/>
 	Password : <input type="password" name ="password"/>
 	
 	<input type="submit" value="Sign in"/> 
 	
 	<%
 		if(request.getAttribute("error")!=null){
 			out.println(request.getAttribute("error"));
 		}
 	%>
 </form>
</body>
</html>