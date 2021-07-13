<%@page import="model.UserModel"%>
<%@page import="Service.UserService"%>
<%
	String useremail =(String)session.getAttribute("useremail");
	String userid = request.getParameter("userid");
	if(useremail==null || useremail == "user")
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
<link rel="stylesheet" href="bootstrap.css">
<title>Post</title>
	<script>
		function check()
		{
			var textbox = document.getElementById("textbox");
			if(textbox.value.length>50 && textbox.value.length<500)
			{
				alert("successed");
			}
			else
			{
				alert("input 50-500 characters long");
			}
		}
	
	</script>

</head>
<body>
	<div>
		<h2  class="alert alert-danger">QAnswer</h2>
		<hr>
	</div>
	<div class="data" style="margin-left:400px">
			<div class="row container ">
				<form action="post" method="post" class="col-md-6 center">
					<div class="form-group">
						<label for="username">Username</label>
						<input type="text" value=<%=userid%> name="userid" readonly class="form-control">
					</div>
					
					<div class="form-group">
						<label for="topic">Topic</label>
						<input type="text" name="topic" class="form-control">
					</div>
					
					<div class="form-group">
						<label for="subtopic">Sub-topic</label>
						<input type="text" name="subtopic" class="form-control">
					</div>
					
					<div class="form-group">
						<label for="question">Question</label>
						<textarea name="question" class="form-control" id="textbox"></textarea>
					</div>
					
					<div class="form-group">
						<input type="submit" value="submit" class="btn btn-warning" class="form-control" onclick="check()">
					</div>
					

				</form>	
			</div>
			</div>

</body>
</html>