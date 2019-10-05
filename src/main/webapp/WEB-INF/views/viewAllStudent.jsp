<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student</title>
</head>
<body>
	<c:forEach var="student" items="${studentList}">
				<p>RollNo: ${student.rollNo} </p>
				<p>Name: ${student.name} </p>
				<p>E-mail: ${student.email} </p>
				<hr> 
			</c:forEach>
</body>
</html>