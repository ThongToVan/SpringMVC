<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="10" width="70%" cellpadding="2">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Salary</th>
			<th>Designation</th>
			<th>edit </th>
			<th>delete</th>
		</tr>
		<c:forEach var="emp" items="${list}">
			<tr>
				<td>${emp.id}</td>
				<td>${emp.name }</td>
				<td>${emp.salary }</td>
				<td>${emp.designation }</td>
				<td><a href="editemp/${emp.id}">edit</a>
				<td><a href="deleteemp/${emp.id}">delete</a>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="emform">Add Employee</a> 
</body>
</html>