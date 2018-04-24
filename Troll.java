
public class Troll extends Monster
{
	private final String NAME = "Troll";
	private int health;
	private int level;
	private Item weapon;
	
	public Troll(int level)
	{
		this.level = level;
		health = (300 + (150 * this.level));
		this.weapon = new Club();
	}
	
	public String getName()
	{
		return NAME;
	}
}
