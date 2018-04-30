
public class Potion extends Consumable
{
    private final String name = "Potion";
    private final String description = "A potion that restores 100 hp.";
    
    public Potion()
    {
        
    }
    public String getName()
    {
        return name;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public String toStrint()
    {
        return "Potion";
    }
    
    public void consume(Hero h)
    {
        int temp = h.getHealth() + 100;
        if (temp > h.getMaxHealth())
        {
            h.setHealth(h.getMaxHealth());
        }
        else
        {
            h.setHealth(temp);
        }
    }
}
