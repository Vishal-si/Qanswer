<%@page import="Service.AnswerService"%>
<%@page import="model.AnswerModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="Stylesheet" href="bootstrap.css">
<title>answer</title>
</head>
<body class="container">
	<div>
		<h3 class="text-warning">Answer Post</h3>
		<hr>
		
		
		<%
			String useremail = (String)session.getAttribute("useremail");
			List<AnswerModel> alist = new AnswerService().getAllAnswerInDisplay(); 
		
		%>

			<%for(AnswerModel amobj : alist) {%>
			<input type="hidden" value="<%=useremail%>" name="user">
			<input type="hidden" value="<%=amobj.getAnsid()%>">		
			<p>
					<b class="text-warning"><%=amobj.getCmobj().getCmpname()%></b><br>
					<%=amobj.getAnswer()%><br><br>
					<a href="like?id=<%=amobj.getAnsid()%>&user=<%=useremail%>" class="btn btn-warning">Like</a>
					<a href="dislike?id=<%=amobj.getAnsid()%>&user=<%=useremail%>" class="btn btn-danger">Dislike</a>
					<a href="comment.jsp?id=<%=amobj.getAnsid()%>" class="btn btn-primary">Comment</a>										
					<hr>
					
			</p>
		
				
			<%} %>
			
			
	</div>

</body>
</html>