package src;

public class Kraken extends Monster
{
	private final String name = "Kraken";
	private int health;
	private int maxHealth;
	private int level;	
	private int agility;
	private int strength;
	private Weapon weapon;

	public Kraken(int level)
	{
		agility = (14 + (2 * level));
		strength = (8 + (3 * level));
		this.level = level;
		health = (300 + (100 * this.level)); 
		maxHealth = health;
	}
	
	public Weapon getWeapon()
	{
	    return weapon;
	}
	
	public void resetHealth()
	{
		health = maxHealth;
	}
	public String getName()
	{
		return name;
	}
	public int getHealth()
	{
		return health;
	}
	public int getAgility()
	{
		return agility;
	}
	public int attack()
	{
		return ((int)((10 + (agility * 1.5)) + (strength * 2.5)));
	}
	public void setHealth(int health)
	{
		this.health = health;
	}
	public int getLevel()
	{
		return level;
	}
	public int experienceReward()
	{
		return (30 + (35 * level));
	}
}
