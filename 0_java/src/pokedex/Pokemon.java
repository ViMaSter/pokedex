package pokedex;

public class Pokemon
{
	private int ID;
	private String Name;
	public Pokemon(int ID, String Name)
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