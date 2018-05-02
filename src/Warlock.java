package src;

public class Warlock extends Monster
{
	private final String name = "Warlock";
	private int health;
	private int maxHealth;
	private int level;	
	private int agility;
	private int strength;

	public Warlock(int level)
	{
		agility = (16 + (2 * level));
		strength = (24 + (3 * level));
		this.level = level;
		health = (600 + (150 * this.level)); 
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
		return ((int)((10 + (agility * 1.5)) + (strength * 2)));
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
		return 1;
	}
}
