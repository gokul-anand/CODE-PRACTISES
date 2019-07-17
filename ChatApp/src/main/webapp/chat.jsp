<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Online Chat</h1>

	<c:forEach items="${messages}" var="m">
		${m }
		</br>
	</c:forEach>

	<br />
	<br />

	<form method="post" action="ChatServlet">
		<input type="text" name="msg" required />
		<button type="submit">Send Message</button>
	</form>

</body>
</html>