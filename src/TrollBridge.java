package src;

public class TrollBridge extends Room
{
    private String description;
    private Room south;
    private Room north;
    private Room east;
    private Room west;
    private Monster monster;
    private boolean visited;
    private String flavorText;
    private Consumable loot;
    
    public TrollBridge()
    {   
    	loot = new Potion();
        flavorText = "";
        visited = false;
        description = "";
    }
    
    public void setFlavorText(String text)
    {
        this.flavorText = text;
    }
    
    public void monsterDefeated()
    {
        this.monster = null;
    }
    
    public void getIntro()
    {
        if (!visited)
        {
            visited = true;
            System.out.println(flavorText);
        }
    }
    
    public TrollBridge(String description)
    {
        this.description = description;
    }
    
    public TrollBridge(Monster monster, String description)
    {
        this.monster = monster;
        this.description = description;
    }
    
    public boolean hasMonster()
    {
        return monster != null;
    }
    
    public Monster getMonster()
    {
        return this.monster;
    }
    
    public void getExits()
    {
        if (east != null)
        {
            System.out.print("east ");
        }
        if (north != null)
        {
            System.out.print("north ");
        }
        if (south != null)
        {
            System.out.print("south ");
        }
        if (west != null)
        {
            System.out.print("west ");
        }
        if (monster != null)
        {
            System.out.print("fight[" + this.monster.getName() + "] ");
        }
        if (monster != null)
        {
            System.out.print("charm[" + this.monster.getName() + "] ");
        }
        if (monster != null)
        {
            System.out.print("outsmart[" + this.monster.getName() + "] ");
        }
        if (hasLoot())
        {
            System.out.print("loot[" + this.loot.toString() + "] ");
        }
        System.out.println();
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
    
    public void removeLoot()
    {
    	loot = null;
    }
}
