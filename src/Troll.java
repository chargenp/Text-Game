package src;

public class Troll extends Monster
{
	private final String NAME = "Troll";
	private int health;
	private int maxHealth;
	private int level;
	private Weapon weapon;
	private int agility;
	private int strength;
	
	public Troll(int level)
	{
		this.agility = (5 + (2 * level));
		this.strength = (6 + (6 * level));
		this.level = level;
		health = (300 + (150 * this.level)); 
		maxHealth = health;
		this.weapon = new Club();
	}
	public void resetHealth()
	{
		this.health = maxHealth;
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
