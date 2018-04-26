
public class Shoddy_Sword extends Weapon
{
	private double dmgMulti;
	private String name;
	
	public Shoddy_Sword()
	{
		dmgMulti = 1.25;
		name = "[Sword]";
	}
	
	public int damage(int strength, int agility)
	{
		return ((int)((10 + (strength * 2) + (agility * 2.5)) * dmgMulti));
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
