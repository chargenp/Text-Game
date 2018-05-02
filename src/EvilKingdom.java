package src;

public class EvilKingdom extends Room 
{
	private String description;
	private Monster monster;
	private boolean visited;

	public EvilKingdom()
	{

	}

	public EvilKingdom(Monster monster, String description)
	{
		this.monster = monster;
		this.description = description;
		setLoot(new Potion());
		visited = false;
	}

	public Monster getMonster()
	{
		return this.monster;
	}

	public void getIntro()
	{   
		if (!visited)
		{
			System.out.println("All of your journey is for this moment, now is your shot!\n");
		}
		visited = true;
	}

	public String getDescription()
	{
		return description;
	}

	public String getCommands()
	{
		String commands = "";
		return commands;
	}
	
	public boolean hasMonster()
	{
		return this.monster != null;
	}
	
	public void monsterDefeated()
	{
	    monster = null;
	}

	@Override
	public void getExits()
	{
		if(getNorth() != null)
		{
			System.out.print("North ");
		}
		if(getSouth() != null)
		{
			System.out.print("South ");
		}
		if(getEast() != null)
		{
			System.out.print("East ");
		}
		if(getWest() != null)
		{
			System.out.print("West ");
		}
		if (monster != null)
		{
			System.out.print("fight[" + this.monster.getName() + "] ");
		}
		if (hasLoot())
		{
			System.out.print("loot[" + getLoot().toString() + "] ");
		}
		System.out.println();
	}
}
