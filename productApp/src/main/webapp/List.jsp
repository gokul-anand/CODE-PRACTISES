<%@page import="com.visa.prj.entity.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> Product List</h1>
	<table border = '1'>
		<tr>
			<th> ID </th> <th> Name </th> <th> Price </th>
		</tr>
		
		<%
			List<Product> products  =(List<Product>) request.getAttribute("products");
			for(Product p: products){
		%>
			<tr>
				<th>  <%= p.getId() %> </th>
				<th> <%= p.getName() %>  </th>
				<th>  <%= p.getPrice() %> </th>
			</tr>
		<%
			}
		%>
		
	</table>
</body>
</html>