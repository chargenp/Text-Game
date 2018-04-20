public class Room 
{
    private String description;
    private Room south;
    private Room north;
    private Room east;
    private Room west;
    
    public Room()
    {
        description = "";
    }
    
    public Room(String description)
    {
        this.description = description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
    
    public void setNorth(Room north)
    {
        this.north = north;
    }
    
    public void setSouth(Room south)
    {
        this.south = south;
    }
    
    public void setEast(Room east)
    {
        this.east = east;
    }
    
    public void setWest(Room west)
    {
        this.west = west;
    }
    
    public Room getNorth()
    {
        return north;
    }
    
    public Room getEast()
    {
        return east;
    }
    
    public Room getWest()
    {
        return west;
    }
    
    public Room getSouth()
    {
        return south;
    }
    
    public String getDescription()
    {
        return description;
    }
}
