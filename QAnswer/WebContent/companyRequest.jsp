<%@page import="Service.CompanyService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.CompanyModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Company Request</title>
<link rel="stylesheet" href="bootstrap.css">
</head>
<body >
	<div class="alert alert-warning">
		<h3>QAnswer</h3>
		<hr>
	</div>
	
	<div>
		<h2>Company Request</h2>
	</div>
	
	<div>
		<%
			List<CompanyModel> list = new CompanyService().totalRequest();
		 %>
		 <table class="table table-danger">
		 	<tr>
		 		<td>Company Id</td>
		 		<td>Company Name</td>
		 		<td>Email Address</td>
		 		<td>Password</td>
		 		<td>City</td>
		 		<td>Country</td>
		 		<td>Website</td>
		 		<td>Approve</td>
		 	</tr>
		 	
		 	<%
		 	for(CompanyModel cmobj:list) {
		 	%>
		 	<tr>
		 		<td><input type="text" value=<%=cmobj.getCmpid()%> name="cmpid"></td>
		 		<td><input type="text" value=<%=cmobj.getCmpname()%> name="cmpname"></td>
		 		<td><input type="text" value=<%=cmobj.getEmail() %> name="email"></td>
		 		<td><input type="password" value=<%=cmobj.getPassword()%> name="password"></td>
		 		<td><input type="text" value=<%=cmobj.getCity()%> name="city"></td>
		 		<td><input type="text" value=<%=cmobj.getCountry()%> name="country"></td>
		 		<td><input type="text" value=<%=cmobj.getWebsite()%> name="website"></td>
		 		<td><a href="register?id=<%=cmobj.getCmpid()%>">Approved</a></td>
		 	</tr>
		 	<%} %>
		 	
		 	
		 </table>
	</div>
</body>
</html>