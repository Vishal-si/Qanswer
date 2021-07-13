<%@page import="Service.QuestionService"%>
<%@page import="model.Question"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="Stylesheet" href="bootstrap.css">
<title>question</title>
</head>
<body class="container">

		<%
			List<Question> qlist = new QuestionService().displayQuestion();
		
		%>
		<h3 class="text-warning">Question Post</h3>
		<hr>
		
		<%for(Question qobj : qlist) {%>
			<p>
					<b class="text-primary"><%=qobj.getUmobj().getUsername_id()%></b><br>
					<%=qobj.getQues()%>
			</p>
				
			<%} %>

</body>
</html>