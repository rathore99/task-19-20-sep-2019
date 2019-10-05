<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search here</title>
</head>
<body>

<h4>Enter roll no of student you want to ${operationName}</h4>
	<form:form action="${operationName}">
		<input type="number" name="rollNo"/>
		<input type="submit" value="search">
	</form:form>
</body>
</html>