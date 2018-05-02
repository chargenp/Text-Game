package src;

public class Spider extends Monster
{
	private final String name = "Spider";
	private int health;
	private int maxHealth;
	private int level;	
	private int agility;
	private int strength;

	public Spider(int level)
	{
		agility = (16 + (2 * level));
		strength = (8 + (1 * level));
		this.level = level;
		health = (150 + (50 * this.level)); 
		maxHealth = health;
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
		return ((int)((10 + (agility * 1.5)) + (strength * 1.1)));
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
		return (15 + (20 * level));
	}
}

