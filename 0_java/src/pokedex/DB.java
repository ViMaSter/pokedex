package pokedex;

import java.sql.Connection;
import java.io.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sun.security.util.IOUtils;

public class DB {		
	private static String readString(InputStream inputStream) throws IOException {

	    ByteArrayOutputStream into = new ByteArrayOutputStream();
	    byte[] buf = new byte[4096];
	    for (int n; 0 < (n = inputStream.read(buf));) {
	        into.write(buf, 0, n);
	    }
	    into.close();
	    return new String(into.toByteArray(), "UTF-8");
	}
	
	private static String GetConnectionString() throws ClassNotFoundException, IOException
	{		
        Class.forName("com.mysql.jdbc.Driver"); 
		return readString(DB.class.getClassLoader().getResourceAsStream("/pokedex/config/remotedb.txt"));
	}
	
	public static ArrayList<Pokemon> GetAllPokemon() throws SQLException, ClassNotFoundException, IOException
	{ 
		ArrayList<Pokemon> Pokemon = new ArrayList<Pokemon>();
	    Connection con = DriverManager.getConnection(GetConnectionString());

	    PreparedStatement statement = con.prepareStatement("SELECT * from Pokemon");
		ResultSet set = statement.executeQuery();
		while (set.next())
		{
			Pokemon.add(new Pokemon(set.getInt("id"), set.getString("name")));
		}
		return Pokemon;
	}
	public static Pokemon GetPokemonByID(int ID) throws SQLException, ClassNotFoundException, IOException
	{ 
	    Connection con = DriverManager.getConnection(GetConnectionString());

	    PreparedStatement statement = con.prepareStatement("SELECT * from Pokemon WHERE ID = ?");
	    statement.setInt(1, ID);

		ResultSet set = statement.executeQuery();
		if (!set.next())
		{
			return null;
		}
		return new Pokemon(set.getInt("id"), set.getString("name"));
	}
	
	public static ArrayList<Pokemon> GetEvolutionsByID(int ID) throws SQLException, ClassNotFoundException, IOException
	{
		ArrayList<Pokemon> Pokemon = new ArrayList<Pokemon>();
	    Connection con = DriverManager.getConnection(GetConnectionString());

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
