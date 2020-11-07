package pokedex;

public class Employee
{
	private int ID;
	private String Name;
	public Employee(int ID, String Name)
	{
		this.ID = ID;
		this.Name = Name;
	}
	public int getID() {
		return ID;
	}
	public String getName() {
		return Name;
	}
}