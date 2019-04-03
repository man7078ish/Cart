<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="c" %>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Add New Product To The Cart</h1>
<table>
<c:form action="added.obj" modelAttribute="my">
<tr><td>User Id:<c:input path="user_Id" />
<tr><td>Product Id:<c:input path="prod_Id" />
<tr><td>Price:<c:input path="price" />
<tr><td> Quantity:<c:input path="quantity"/>
<tr><td><input type = "submit" value="Add">
</c:form>
</table>
</body>
</html>