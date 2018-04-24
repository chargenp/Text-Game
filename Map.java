
public class Map
{
    private Room start;
    private Room current;
    
    public Map()
    { 	
        StartVillage start = new StartVillage();
        this.start = start;
        current = start;
        Room bridge = new Room(new Troll(1), "Troll bridge");
        bridge.setWest(start);
        start.setEast(bridge);
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
