
public class StartVillage extends Room
{
	public StartVillage()
	{
		super();
	}
	
	public void getIntro()
	{
		System.out.println("You wake up early on a bright sunny day on your small farm just outside"
				+ "\na tiny village upon leaving your bed you run into your mother, just serving breakfast.\n");
	}
	
	public String getCommands()
	{
		String commands = "";
		return commands;
	}
	
	public void blacksmith(Hero hero, Game g)
	{
		
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
		System.out.println("Blacksmith Bed");
		System.out.println();
	}
}
