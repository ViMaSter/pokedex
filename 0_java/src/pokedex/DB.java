package pokedex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DB {
	public static ArrayList<Employee> GetEmployees() throws SQLException
	{
		ArrayList<Employee> employees = new ArrayList<Employee>();
	    Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=localDB;user=sa;password=Od1P_DMu_LF2qw3UtGzwX1fxJCv-cB3N");

	    PreparedStatement statement = con.prepareStatement("SELECT * from employees");
		ResultSet set = statement.executeQuery();
		int count = 0;
		while (set.next())
		{
			++count;
			employees.add(new Employee(set.getInt("id"), set.getString("name")));
		}
		return employees;
	}
}
