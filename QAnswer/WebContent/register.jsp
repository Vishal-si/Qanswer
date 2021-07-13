<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Register</title>
<link rel="stylesheet" href="bootstrap.css">
</head>
<body>
	<div>
		<h2 class="alert alert-danger">QAnswer</h2>
		<hr>
	</div>
	
				<div class="data" style="margin-left:400px">
			<div class="row container">
				<form action="login" method="post" class="col-md-6 center">
					<div class="form-group">
						<label for="username">Username</label>
						<input type="text" name="name" class="form-control">
					</div>
					
					<div class="form-group">
						<label for="email">Email</label>
						<input type="email" name="email" class="form-control">
					</div>
					
					<div class="form-group">
						<label for="password">Password</label>
						<input type="password" name="password" class="form-control">
					</div>
					
					
					<div class="form-group">
						<input type="submit" value="Register" name="btn" class="btn btn-warning" class="form-control">
						<a href="Login.jsp" class="btn btn-danger">Allready account</a>
					</div>
				</form>	
			</div>
			</div>
</body>
</html>