<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="pokedex.DB" %>
<%@ page import="pokedex.Employee" %>
<%@ page import="java.util.ArrayList" %>
    
    
<%
	ArrayList<Employee> employees = pokedex.DB.GetEmployees();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
	<thead>
		<tr>
			<th>ID</th>
			<th>Name</th>
		</tr>
	</thead>
	<tbody>
<%
	for (Employee employee : employees)
	{
		%>
		<tr>
			<td><%= employee.getID() %></td>
			<td><%= employee.getName() %></td>
		</tr>
		<%
	}
%>
	</tbody>
</table>
</body>
</html>