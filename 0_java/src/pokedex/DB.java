package pokedex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB {
	public DB() throws SQLException
	{
	    Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=localDB;user=sa;password=Od1P_DMu_LF2qw3UtGzwX1fxJCv-cB3N");

	    PreparedStatement statement = con.prepareStatement("SELECT * from employees");
		ResultSet set = statement.executeQuery();
		int count = 0;
		while (set.next())
		{
			++count;
			System.out.println("Employee: " + set.getString("name") + "(" + set.getInt("id") + ")");
		}
		System.out.println("Result count: " + count);
	}
}
