<%@page import="com.visa.prj.entity.Question"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Question</h1>
	
	<%
			Question q = (Question) request.getSession().getAttribute("question");
	%>
	<p> <%= q.getQuestion() %> </p>	
	<p> <%= q.getGuessedAnswer() %> </p>
	<p> Lifes left: <%= q.getLife() %> </p>
	
	<form method="POST" action="GuessLogic" >
		<input type="text" name ="guess"/>
		<button type="submit"> submit </button>
	</form>
	<br/>
	<a href = "logout">End Session</a>

</body>
</html>