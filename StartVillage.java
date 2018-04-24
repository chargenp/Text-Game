
public class StartVillage extends Room
{
	public StartVillage()
	{
		super();
	}
	
	public void getIntro()
	{
		System.out.println("After completing your morning chores on the farm, you head inside to see"
		    + "\nyour mother, who is just finishing breakfast.\n");
	}
	
	public String getCommands()
	{
		String commands = "";
		return commands;
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
		System.out.println("Blacksmith Bed Mother");
		System.out.println();
	}
}
