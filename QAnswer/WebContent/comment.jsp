<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String username=(String)session.getAttribute("useremail");
	String ansid = request.getParameter("id");
	if(username==null)
	{
		response.sendRedirect("answerframe.jsp");
	}

%>

<form action="comment" method="post">
<div>
	<div>
		<label>Comment</label>
		<input type="hidden" value="<%=username%>" name="user"><br>
		<input type="hidden" value="<%=ansid %>" name="ansid"><br>
		<textarea name="comment"></textarea> 
	</div>
	
	<div>
		<input type="submit" value="submit">
	</div>

</div>
</form>
</body>
</html>