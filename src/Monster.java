package src;

public abstract class Monster 
{
	String name;
	int health;
	int level;	
	Weapon weapon;
	int agility;
	int strength;
	int maxHealth;
	
	public abstract String getName();
	public abstract int getHealth();
	public abstract int getAgility();
	public abstract int attack();
	public abstract void setHealth(int health);
	public abstract int getLevel();
	public abstract int experienceReward();
	public abstract void resetHealth();
	public abstract Weapon getWeapon();
}
