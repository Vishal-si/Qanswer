<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="bootstrap.css">
<title>Admin Login</title>
</head>
<body class="container">
		<h3>Admin</h3>
		<hr>
		<div class="card" style="width:400px">
		<form action="admin" method="post" class="form-group">
		
			<div class="card-body">
				<label>Email</label><br>
				<input type="email" name="email" class="form-control"><br>
				
				<label>Password</label><br>
				<input type="password" name="password" class="form-control"><br>
				
				<input type="submit" value="submit" class="btn btn-warning">
			</div>
		</form>
		</div>

</body>
</html>