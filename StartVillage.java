
public class StartVillage extends Room
{
	public StartVillage()
	{
		super();
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
	}
}
