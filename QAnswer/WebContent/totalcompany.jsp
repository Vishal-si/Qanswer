<%@page import="Service.CompanyService"%>
<%@page import="model.CompanyModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Company</title>
<link rel="stylesheet" href="bootstrap.css">
<body>
	<div class="alert alert-warning">
		<h3>QAnswer</h3>
	</div>
	<div>
		<h2>Total company</h2>
	</div>
	
	<div>
		<%
			List<CompanyModel> list = new CompanyService().totalCompany();
		 %>
		 <table border="1" class="table table-danger">
		 	<tr>
		 		<td>Company Id</td>
		 		<td>Company Name</td>
		 		<td>Email Address</td>
		 		<td>Password</td>
		 		<td>City</td>
		 		<td>Country</td>
		 		<td>Website</td>
		 	</tr>
		 	
		 	<%
		 	for(CompanyModel cmobj:list) {
		 	%>
		 	<tr>
		 		<td><input type="text" value=<%=cmobj.getCmpid()%> name="cmpid" readonly></td>
		 		<td><input type="text" value=<%=cmobj.getCmpname()%> name="cmpname" readonly></td>
		 		<td><input type="text" value=<%=cmobj.getEmail() %> name="email" readonly></td>
		 		<td><input type="password" value=<%=cmobj.getPassword()%> name="password" readonly></td>
		 		<td><input type="text" value=<%=cmobj.getCity()%> name="city" readonly></td>
		 		<td><input type="text" value=<%=cmobj.getCountry()%> name="country" readonly></td>
		 		<td><input type="text" value=<%=cmobj.getWebsite()%> name="website" readonly></td>
	
		 	</tr>
		 	<%} %>
		 	
		 	
		 </table>
	</div>

</body>
</html>