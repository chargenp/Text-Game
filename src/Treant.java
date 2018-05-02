package src;

public class Treant extends Monster
{
	private final String name = "Treant";
	private int health;
	private int maxHealth;
	private int level;	
	private int agility;
	private int strength;

	public Treant(int level)
	{
		agility = (4 + (1 * level));
		strength = (16 + (4 * level));
		this.level = level;
		health = (300 + (350 * this.level)); 
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
		return ((int)((10 + (strength * 1.5)) * 1.3));
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
		return (40 + (50 * level));
	}
}
