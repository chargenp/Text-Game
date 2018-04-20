
public class Map
{
    private Room start;
    private Room current;
    
    public Map()
    {
        StartVillage start = new StartVillage("You are inside your home village. " 
        		+ "It is a very small quaint town");
        this.start = start;
        current = start;
    }
    
    public Room getCurrent()
    {
    	return current;
    }
    
    public Room getStart()
    {
        return start;
    }
    
}
