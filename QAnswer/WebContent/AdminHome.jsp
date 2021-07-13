<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Homepage</title>
<link rel="stylesheet" href="bootstrap.css">
</head>
<body class="container">
	<%
		String admin = (String)session.getAttribute("admin");
		if(admin==null)
		{
			response.sendRedirect("Admin.jsp");
		}
	%>

	<div>
		<h3>Admin</h3>
		<hr>
	</div>
	
	<div>
		<nav>
			<ul>
				<li><a href="#">Home</a></li>
				<li><a href="#">About</a></li>
				<li><a href="#">Contact</a></li>
				<li><a href="#">Help</a></li>
				<li><a href="#">Logout</a>
			</ul>
		</nav>
		
		<p>
			QAnswer provide one question with many answer by different different expert.<br>
			QAnswer provide IT relative question...<br>
			QAnswer is open platform which student also share the own knowledge...<br><br>
			<h3 style="color:white">
			</h3>
		</p>
	</div>
	
	<div>
		<section>
			<h3>Company Request</h3>
			<a href="companyRequest.jsp">Check</a>
		</section>
	</div>
	
		<div>
		<section>
			<h3>Total company</h3>
			<a href="totalcompany.jsp">Check</a>
		</section>
	</div>
	
		<div>
		<section>
			<h3>Total user</h3>
			<a href="#">Check</a>
		</section>
	</div>
	
	
		<div>
		<section>
			<h3>Total Posting</h3>
			<a href="#">Check</a>
		</section>
	</div>
	
</body>
</html>