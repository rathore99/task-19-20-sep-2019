<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cheers!!!!</title>
</head>
<body>
<h2>${message}</h2>

<hr>
<p>RollNo : ${student1.rollNo} </p>
<p>Name   : ${student1.name} </p>
<p>Email  : ${student1.email} </p>

<hr>
<h2>Hello User</h2>
<a href="registerStudent">Register New Student</a><br/><br/>
<a href="searchStudent">Search Student</a><br/><br/>
<a href="deleteStudent">Delete Student</a><br/><br/>
<a href="updateStudent">Update Student Details</a><br/><br/>
<a href="showStudents">show Student</a>
</body>
</html>