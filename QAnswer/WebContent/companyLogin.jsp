<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Company</title>
</head>
<body>
	<div>
		<h2>QAnswer</h2>
		<hr>
	</div>
	<form action="registration" method="post">
	<table>
		<tr>
			<td>Email</td>
			<td><input type="email" name="email"></td>
		</tr>
		
		<tr>
			<td>Password</td>
			<td><input type="password" name="password"></td>
		</tr>
	
		<tr>
			<td></td>
			<td><input type="submit" value="Login" name="btn"></td>
		</tr>	
		
		<tr>
			<td><a href="addCompany.jsp">Register Company</a></td>
		</tr>
		
	</table>
</form>
</body>
</html>