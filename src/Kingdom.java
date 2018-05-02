package src;

public class Kingdom extends Room
{
public boolean visited;
    
	public Kingdom()
	{
		
	}
	
	public void getIntro()
	{   
	    if (!visited)
	    {
	        System.out.println("The great kingdom of the land.\n");
	    }
	    visited = true;
	}
	
	public String getDescription()
	{
	    return "The great capital of the Realm.";
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
		System.out.println("Blacksmith");
		System.out.println();
	}
}
