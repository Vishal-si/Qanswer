<%@page import="Service.AnswerService"%>
<%@page import="Service.QuestionService"%>
<%@page import="model.Question"%>
<%@page import="java.util.List"%>
<%
	String useremail =(String)session.getAttribute("useremail");
	String userid = request.getParameter("userid");
	if(useremail==null || useremail=="user")
	{
		response.sendRedirect("Login.jsp");
	}
	
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get Answer</title>
<link rel="stylesheet" href="bootstrap.css">
</head>
<body>
	<div>
		<h2 class="alert alert-danger">QAnswer</h2>
		<hr>
	</div>
<%List<Question> list = new AnswerService().getAnswerByCompany(userid); %>




<div>
	<table border="1" class="table table-danger">
		<tr>
			<th>Topic</th>
			<th>Sub-topic</th>
			<th>Question</th>
			<th>Answer</th>
			<th>By Company</th>
		</tr>
		
		<%for(Question qlist: list) {%>
			<tr>
				<td><%=qlist.getTopic() %></td>
				<td><%=qlist.getSubTopic() %></td>
				<td><textarea><%=qlist.getQues()%></textarea></td>
				<td><textarea><%=qlist.getAmobj().getAnswer()%></textarea></td>
				<td><%=qlist.getCmobj().getCmpname() %></td>
			</tr>
		<%} %>
	</table>
</div>



</body>
</html>