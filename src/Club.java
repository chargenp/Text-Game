package src;

public class Club extends Weapon
{
	private double dmgMulti;
	private String name;
	
	public Club()
	{
		dmgMulti = 1.5;
		name = "[Club]";
	}
	
	public int damage(int strength, int agility)
	{
		return ((int)((10 + (strength * 1.5)) * dmgMulti));
	}
	
	public String getName()
	{
		return name;
	}
	
	public String toString()
	{
		return name;
	}
}
