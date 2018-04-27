
public class Skeleton extends Monster
{
	private final String name = "Skeleton";
	private int health;
	private int maxHealth;
	private int level;	
	private Weapon weapon;
	private int agility;
	private int strength;

	public Skeleton(int level)
	{
		agility = (6 + (3 * level));
		strength = (5 + (2 * level));
		this.level = level;
		health = (100 + (125 * this.level)); 
		maxHealth = health;
		this.weapon = new Shoddy_Sword();
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
		return weapon.damage(strength, agility);
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
		return (10 + (10 * level));
	}
}
