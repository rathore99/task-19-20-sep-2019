<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Student</title>
</head>
<body>
	<form:form action="delete" method="POST" modelAttribute="student">
		<form:select path="rollNo" name="rollNo">
			<c:forEach var="student" items="${studentList}">
				<form:option value="${student.rollNo}" label="${student.name}"></form:option>
			</c:forEach>
			<input type="submit" value="submit">
		</form:select>

	</form:form>
</body>
</html>