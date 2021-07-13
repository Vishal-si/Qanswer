<%@page import="java.util.List"%>
<%@page import="model.UserModel"%>
<%@page import="Service.UserService"%>
<%@page import="Service.QuestionService"%>
<%@page import="model.Question"%>
<%
	String cmpemail =(String)session.getAttribute("cmpemail");
	if(cmpemail==null)
	{
		response.sendRedirect("companyLogin.jsp");
	}
	


%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Post Answer</title>
</head>
<body>
	<div>
		<h3>Welcome</h3>
	</div>
	
	
	<div>
		<table border="1">
			<tr>
				<th>Question id</th>
				<th>Topic</th>
				<th>Sub topic</th>
				<th>Question</th>
				<th>Date</th>
				<th>By User</th>
				<th>Post Answer</th>
			</tr>
			
			<% List<Question> qlist = new QuestionService().displayAllQuestion();%>
			
			<%for(Question qobj:qlist) {%>
				<tr>
					<td><%=qobj.getQuestion_id()%></td>
					<td><%=qobj.getTopic()%></td>
					<td><%=qobj.getSubTopic()%></td>
					<td><%=qobj.getQues()%></td>
					<td><%=qobj.getDate()%></td>
					<td><%=qobj.getUmobj().getUsername_id()%></td>
					<th><a href="submitanswer.jsp?id=<%=qobj.getQuestion_id()%>">Click</a></th>
				</tr>
			
			<%} %>
		
		</table>
	
	</div>
	
</body>
</html>