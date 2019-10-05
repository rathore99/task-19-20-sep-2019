<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update </title>
</head>
<body>
<form:form action="updateRecord" method="POST" modelAttribute="student1">
<form:input path="rollNo" name="rollNo" value="${student1.rollNo}"/><br/><br/>
<form:input path="name" name="name" value="${student1.name}"/><br/><br/>
<form:input path="email" name="email" value="${student1.email}"/><br/><br/>
<input type="submit" value="update">
</form:form>
</body>
</html>