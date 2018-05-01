package src;

public class StartVillage extends Room
{
    public boolean visited;
    
	public StartVillage()
	{
		super();
	}
	
	public void getIntro()
	{   
	    if (!visited)
	    {
	        System.out.println("After completing your morning chores on the farm, you head inside to see"
	            + "\nyour mother, who is just finishing breakfast.\n");
	    }
	    visited = true;
	}
	
	public String getDescription()
	{
	    return "Your farm at the village you grew up around.";
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
