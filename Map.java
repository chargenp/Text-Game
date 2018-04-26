import java.util.Random;

public class Map
{
    private Random rng;
    private Room start;
    private Room current;
    private Room TrollBridge;
    private Room[] level0;
    
    public Map()
    { 	
        rng = new Random();
        StartVillage start = new StartVillage();
        this.start = start;
        current = start;
        TrollBridge = new Room(new Troll(0), "Troll bridge");
        TrollBridge.setFlavorText("spooky bridge, troll appears");
        Room forest1 = new Room("A forest");
        Room forest2 = new Room("A forest 2");
        Room meadow1 = new Room("A pretty meadow");
        Room meadow2 = new Room("A pretty meadow 2");
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
        Room tempRoom2;
        Room tempRoom3;
        Room tempRoom4;
        
        
        TrollBridge.setWest(this.start);
        this.start.setEast(TrollBridge);
        
    }
    
    public Room getTrollMap()
    {
        return TrollBridge;
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
    
}
