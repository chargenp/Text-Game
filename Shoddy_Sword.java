
public class Shoddy_Sword extends Weapon
{
	private double dmgMulti;
	private String name;
	private String description;
	
	public Shoddy_Sword()
	{
		dmgMulti = 1.25;
		name = "[Shoddy Sword]";
		description = "A sword mdae with poor craftsmanship";
	}
	
	public int damage(int strength)
	{
		return ((int)((10 + (strength * 10)) * dmgMulti));
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public String toString()
	{
		return name;
	}
}
