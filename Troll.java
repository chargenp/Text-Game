
public class Troll extends Monster
{
	private final String NAME = "Troll";
	private int health;
	private int level;
	private Weapon weapon;
	private final int agility = 9;
	private final int strength = 12;
	
	public Troll(int level)
	{
		this.level = level;
		health = (300 + (150 * this.level)); 
		this.weapon = new Club();
	}
	
	public int experienceReward()
	{
		return (30 + (30 * level));
	}
	
	public int getLevel()
	{
		return level;
	}
	
	public String getName()
	{
		return NAME;
	}

	public int getAgility()
	{
		return agility;
	}
	
	public int getHealth()
	{
		return health;
	}
	
	public void setHealth(int health)
	{
		this.health = health;
	}
	
	public int attack()
	{
		return weapon.damage(strength, agility);
	}
	
}
