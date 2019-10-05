<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register </title>
</head>
<body>
<form:form action="saveStudent" modelAttribute="student">
<form:label path="rollNo">Roll No</form:label><br/>
<form:input  path="rollNo" type="number"/><br/><br/>
<form:errors path="rollNo"></form:errors>
<form:label path="name">Name</form:label><br/>
<form:input path="name" type="text"/><br/><br/>
<form:errors path="name"></form:errors>
<form:label path="email">email</form:label><br/>
<form:input path="email" type="email"/><br/><br/>
<form:errors path="email"></form:errors>
<input type="submit" value="register"><br/><br/>
</form:form>
</body>
</html>
