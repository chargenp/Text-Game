package src;
import java.util.Random;

public class Map
{
    private Random rng;
    private Room start;
    private Room current;
    private Room[] level0;
    
    public Map()
    { 	
        rng = new Random();
        StartVillage start = new StartVillage();
        TrollBridge trollBridge = new TrollBridge(new Troll(0), "Troll bridge");
        this.start = start;
        current = start;
        trollBridge.setFlavorText("spooky bridge, troll appears");
        Room forest1 = new Room(new Skeleton(0), "A forest");
        Room forest2 = new Room(new Treant(0), "A forest 2");
        Room meadow1 = new Room(new Skeleton(1),"A pretty meadow");
        Room meadow2 = new Room(new Skeleton(0),"A pretty meadow 2");
        forest1.setFlavorText("spooooooky");
        forest2.setFlavorText("spooooooky 2");
        meadow1.setFlavorText("peacefull");
        meadow2.setFlavorText("peaceful 2");

        level0 = new Room[4];
        level0[0] = forest1;
        level0[1] = forest2;
        level0[2] = meadow1;
        level0[3] = meadow2;
        
        int tempInt = rng.nextInt(4);
        Room tempRoom1 = level0[tempInt];
        level0[tempInt] = null;
        Room tempRoom2 = null;
    	Room tempRoom3 = null;
    	Room tempRoom4 = null;
        while (tempRoom2 == null || tempRoom3 == null || tempRoom4 == null)
        {
        	tempInt = rng.nextInt(4);
        	if (tempRoom2 == null)
        	{
        		tempRoom2 = level0[tempInt];
        		level0[tempInt] = null;
        	}
        	else if (tempRoom3 == null)
        	{
        		tempRoom3 = level0[tempInt];
        		level0[tempInt] = null;
        	}
        	else if (tempRoom4 == null)
        	{
        		tempRoom4 = level0[tempInt];
        		level0[tempInt] = null;
        	}
        }
        
        trollBridge.setWest(this.start);
        this.start.setEast(trollBridge);
        trollBridge.setEast(tempRoom1);
        tempRoom1.setWest(trollBridge);
        tempRoom1.setNorth(tempRoom2);
        tempRoom1.setEast(tempRoom3);
        tempRoom2.setSouth(tempRoom1);
        tempRoom3.setWest(tempRoom1);
        tempRoom3.setEast(tempRoom4);       
        tempRoom4.setWest(tempRoom3);
    }
    
    public void resetMap()
    {
    	current = start;
    }
    
    public Room getCurrent()
    {
    	return current;
    }
    public void setCurrent(Room room)
    {
    	current = room;
    }
    
    public Room getStart()
    {
        return start;
    }
    
    public void monsterLoad()
    {
    	current.monsterDefeated();
    }
}
