<%@page import="Service.CompanyService"%>
<%@page import="model.CompanyModel"%>
<%@page import="Service.QuestionService"%>
<%@page import="model.Question"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Submit</title>

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
	<%
		String quesid = request.getParameter("id");
		String cmpemail =(String)session.getAttribute("cmpemail");
		
		QuestionService qsobj = new QuestionService();
		Question qobj =(Question)qsobj.getQuestionfromid(quesid);
		
		CompanyService csobj = new CompanyService();
		CompanyModel cmobj =(CompanyModel)csobj.getCompanyNameByEmail(cmpemail);
	%>
	<div>
		<h2>QAnswer</h2>
		<hr>
	</div>
	<form action="submit" method="post">
	<div>
			<table>
				<tr>
				<td><input type="hidden" value=<%=cmobj.getCmpname()%> name="cmpname"></td>
				<td><input type="hidden" value=<%=quesid%> name="quesid"></td>
				</tr>
				<tr>
					<td>Question</td>
					<td><textarea name="ques"><%=qobj.getQues()%></textarea></td>
				</tr>
				<tr>
					<td>Post Answer</td>
					<td><textarea name="answer" id="textbox"></textarea></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Submit" onclick="check()"></td>
				</tr>
			</table>		
	</div>
	</form>
	
</body>
</html>