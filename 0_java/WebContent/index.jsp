<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="pokedex.DB" %>
<%@ page import="pokedex.Pokemon" %>
<%@ page import="java.util.ArrayList" %>
    
    
<%
	ArrayList<Pokemon> Pokemons = pokedex.DB.GetAllPokemon();
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
	for (Pokemon Pokemon : Pokemons)
	{
		%>
		<tr>
			<td><%= Pokemon.getID() %></td>
			<td><%= Pokemon.getName() %></td>
		</tr>
		<%
	}
%>
	</tbody>
</table>
</body>
</html>