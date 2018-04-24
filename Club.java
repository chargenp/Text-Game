
public class Club extends Weapon
{
	private double dmgMulti;
	private String name;
	
	public Club()
	{
		dmgMulti = 1.5;
		name = "[Club]";
	}
	
	public int damage(int strength)
	{
		return ((int)((10 + (strength * 2)) * dmgMulti));
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
