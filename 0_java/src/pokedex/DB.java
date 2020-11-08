package pokedex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DB {
	public static ArrayList<Pokemon> GetAllPokemon() throws SQLException
	{
		ArrayList<Pokemon> Pokemon = new ArrayList<Pokemon>();
	    Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=localDB;user=sa;password=Od1P_DMu_LF2qw3UtGzwX1fxJCv-cB3N");

	    PreparedStatement statement = con.prepareStatement("SELECT * from Pokemon");
		ResultSet set = statement.executeQuery();
		while (set.next())
		{
			Pokemon.add(new Pokemon(set.getInt("id"), set.getString("name")));
		}
		return Pokemon;
	}
	public static Pokemon GetPokemonByID(int ID) throws SQLException
	{
	    Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=localDB;user=sa;password=Od1P_DMu_LF2qw3UtGzwX1fxJCv-cB3N");

	    PreparedStatement statement = con.prepareStatement("SELECT * from Pokemon WHERE ID = ?");
	    statement.setInt(1, ID);

		ResultSet set = statement.executeQuery();
		if (!set.next())
		{
			return null;
		}
		return new Pokemon(set.getInt("id"), set.getString("name"));
	}
	
	public static ArrayList<Pokemon> GetEvolutionsByID(int ID) throws SQLException
	{
		ArrayList<Pokemon> Pokemon = new ArrayList<Pokemon>();
	    Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=localDB;user=sa;password=Od1P_DMu_LF2qw3UtGzwX1fxJCv-cB3N");

	    PreparedStatement statement = con.prepareStatement("SELECT Pokemon.* FROM Evolutions INNER JOIN Pokemon ON Pokemon.ID = Evolutions.EvolutionID WHERE Evolutions.ID = ? ");
	    statement.setInt(1, ID);
	    
		ResultSet set = statement.executeQuery();
		while (set.next())
		{
			Pokemon.add(new Pokemon(set.getInt("id"), set.getString("name")));
		}
		return Pokemon;		
	}
}
