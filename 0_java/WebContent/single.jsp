<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="pokedex.DB" %>
<%@ page import="pokedex.Pokemon" %>
<%@ page import="java.util.ArrayList" %>
    
    
<%
	Pokemon Pokemon = null;
	ArrayList<Pokemon> Evolutions = null;
	String IDParam = request.getParameter("ID");
	if (IDParam != null && !IDParam.isBlank())
	{
		int ID = Integer.valueOf(IDParam);
		Pokemon = pokedex.DB.GetPokemonByID(ID);
		Evolutions = pokedex.DB.GetEvolutionsByID(ID);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="" method="POST">
	<input type="number" name="ID" value="<%= IDParam %>" />
	<input type="submit" value="Lookup" />
</form>

<%
	if(Pokemon != null)
	{
%>
	<b>Pokemon</b>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><%= Pokemon.getID() %></td>
				<td><%= Pokemon.getName() %></td>
			</tr>
		</tbody>
	</table>
	
	<b>Evolutions</b>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
			</tr>
		</thead>
		<tbody>
		<%
			for (Pokemon evolution : Evolutions)
			{
		%>
			<tr>
				<td><%= evolution.getID() %></td>
				<td><%= evolution.getName() %></td>
			</tr>
		<%
			}
		%>
		</tbody>
	</table>
<%
	} else
	{
		if (IDParam != null && !IDParam.isBlank())
		{
%>	
			<b>No matching Pokemon found</b>
<%

		}
	}
%>
</body>
</html>