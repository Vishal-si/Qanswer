
<!DOCTYPE html>
<%@page import="Service.AnswerService"%>
<%@page import="model.AnswerModel"%>
<%@page import="java.util.Set"%>
<%@page import="Service.CompanyService"%>
<%@page import="model.UserModel"%>
<%@page import="java.util.Map"%>
<%@page import="Service.UserService"%>
<%@page import="Service.QuestionService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Question"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>QAnswer</title>
<link rel="Stylesheet" href="indexStyle.css"/>
<link rel="Stylesheet" href="bootstrap.css">
</head>
<body>

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

		
	<div class="menu">
	<%

	
		String useremail = (String)session.getAttribute("useremail");
	
		String uid;
	
		
		if(useremail==null)
		{
			uid="user";
		}
		else
		{
			UserService usobj = new UserService();
			uid= usobj.getUseridFromEmail(useremail);
		}
	
	%>
	
		<nav class="navbar navbar-inverse">
			<ul>
				<li><a href="#">Home</a></li>
				<li><a href="post.jsp?userid=<%=uid%>">Post</a></li>
				<li><a href="get.jsp?userid=<%=uid%>">Get</a></li>
				<li><a href="register.jsp">Register</a><li>
				<li><a href="companyLogin.jsp">Company</a><li>
				<li><a href="#">About</a></li>
				<li><a href="#">Contact</a></li>
				<li><a href="#">Help</a></li>
				<li><a href="logout.jsp">Logout</a></li>
			</ul>
		</nav>
		
		<p>
			QAnswer provide one question with many answer by different different expert.<br>
			QAnswer provide IT relative question...<br>
			<h5 style="color:white">
			Welcome:<%=uid%>
			</h5>
		</p>
	</div>
			<div class="data">
			<div class="row container">
				<form action="post" method="post" class="col-md-6 center">
					<div class="form-group">
						<label for="username">Username</label>
						<input type="text" value=<%=uid%> name="userid" readonly class="form-control">
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
			
			<div class="question">			
			<div class="row container">
				<div class="col-lg-12">
					<iframe src="questionframe.jsp" class="responsive-iframe"></iframe>
				</div>
			</div>
			</div>
			
			<div class="answer">
			<div class="row container">
				<div class="col-lg-12">
					<iframe src="answerframe.jsp" class="responsive-iframe"></iframe>
				</div>
			</div>
			</div>


	

	
	
</body>
</html>