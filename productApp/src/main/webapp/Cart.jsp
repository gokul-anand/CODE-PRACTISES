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
	Welcome,${user}
	<br />
	<a href="LoginServlet"> Sign out</a>
	<h1>Product List Using JSTL</h1>
	<table border='1'>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Price</th>
			<th>Select</th>
		</tr>

		<c:forEach items="${cart}" var="p">
			<tr>
				<td>${p.id}</td>
				<!--  Should have matching getters -->
				<td>${p.name}</td>
				<td>${p.price}</td>
			</tr>
		</c:forEach>

	</table>
	<a href = "products" >Back to Product</a>
</body>
</html>
