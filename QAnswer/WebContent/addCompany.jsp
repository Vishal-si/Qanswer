<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add company</title>
</head>
<body>
<div>
	<h2>Add Company</h2>
</div>

<div>
	<form action="registration" method="post">
		<table>	
			<tr>
				<td>Name</td>
				<td><input type="text" name="cmpname">
			</tr>
			
			<tr>
				<td>Email Address</td>
				<td><input type="email" name="email">
			</tr>
			
			<tr>	
				<td>Password</td>
				<td><input type="password" name="password">
			</tr>
			
			<tr>
				<td>city</td>
				<td><input type="text" name="city">
			</tr>
			
			<tr>
				<td>Country</td>
				<td><input type="text" name="country">
			</tr>
			
			<tr>
				<td>Website</td>
				<td><input type="text" name="website">
			</tr>
			
			
			<tr>
				<td>
				</td>
				
				<td><input type="submit" name="btn" value="Register"></td>
			</tr>
		</table>
		
	</form>
	
</div>

</body>
</html>