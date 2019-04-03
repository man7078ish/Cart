<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="b"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<b:form modelAttribute="my" >
		<table border="2">

			<tr>
				<th>UserId
				<th>ProductId
				<th>Price
				<th>Quantity 
				<c:forEach items="${list}" var="list">
				<tr>
							<td>${list.user_Id}
							<td>${list.prod_Id}
							<td>${list.price}
							<td>
							${list.quantity}
							<td><a href="increment.obj?cartid=${list.user_Id}">+</a>
						<td><a href="decrement.obj?cartid=${list.user_Id}">-</a>
				</tr>
				</c:forEach>
      		</table>
      		 <a href="add.obj">Add new product to the cart</a><br>
      <a href="delete.obj">Delete product from the cart</a>
       <a href="order.obj">Place order</a>
      		
	</b:form>
</body>
</html>