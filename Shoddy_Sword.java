
public class Shoddy_Sword extends Weapon
{
	private double dmgMulti;
	private String name;
	
	public Shoddy_Sword()
	{
		dmgMulti = 1.25;
		name = "[Shoddy Sword]";
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
