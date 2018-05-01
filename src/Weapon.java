package src;

public abstract class Weapon extends Item
{
	double dmgMulti;
	public abstract int damage(int strength, int agility);
}
