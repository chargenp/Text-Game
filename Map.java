
public class Map
{
    private Room start;
    
    public Map()
    {
        Room startVillage = new Room("Your home. You've worked the lands around here all your life");
        start = startVillage;
    }
    
    public Room getStart()
    {
        return start;
    }
    
}
