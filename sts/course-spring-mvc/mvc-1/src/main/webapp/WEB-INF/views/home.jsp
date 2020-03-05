<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Spring Chocolate Store</title>
	<link href="resources/css/core.css" rel="stylesheet"/>
</head>
<body>
<div style="float:right">
	<a href="users?register">Register</a>
</div>

<h1>
	Featured Products  
</h1>

<c:forEach var="item" items="${productList}">
	<c:out value="${item.name}"/> <br/>
</c:forEach>

<h2>
	Customers  
</h2>

<c:forEach var="customer" items="${allCustomers}">
	<a href="users/${customer.name}"><c:out value="${customer.name}"/></a>
</c:forEach>

</body>
</html>
