
public class Hero
{
	private Item[] inventory;
    private String name;
    private int level;
    private int health;
    private int strength;
    private int agility;
    private int intelligence;
    private int charisma;
    private int vitality;
    private int mana;
    
    public Hero(String name, String build)
    {
        this.name = name;
        if (build.toLowerCase().equals("strong"))
        {
        	strength = 13;
        	agility = 8;
        	intelligence = 7;
        	charisma = 10;
        	vitality = 12;
        }
        health = vitality * 10;
        mana = intelligence * 10;
        level = 1;
    }
    
    public void getDescription()
    {
    	
    }
    
    public void setMana(int mana)
    {
    	this.mana = mana;
    }
    
    public int getMana()
    {
    	return mana;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getHealth()
    {
    	return health;
    }
    
    public void setHealth(int health)
    {
    	this.health = health;
    }
    
    public int getStrength()
    {
    	return strength;
    }
    
    public void setStrength(int strength)
    {
    	this.strength = strength;
    }
    
    public int getAgility()
    {
    	return agility;
    }
    
    public void setAgility(int agility)
    {
    	this.agility = agility;
    }
    
    public void setIntelligence(int intellegence)
    {
    	this.intelligence = intellegence;
    }
    
    public int getIntelligence()
    {
    	return intelligence;
    }
    
    public int getVitality()
    {
    	return vitality;
    }
    
    public void setVitality(int vitality)
    {
    	this.vitality = vitality;
    }
    
    public int getCharisma()
    {
    	return charisma;
    }
    
    public void setCharisma(int charisma)
    {
    	this.charisma = charisma;
    
    }
    
    public void setLevel(int level)
    {
    	this.level = level;
    }
    
    public int getLevel()
    {
    	return level;
    }
    
    public Item[] getInventory()
    {
    	return inventory;
    }
    
    public void addInventory(Item item)
    {
    	
    }
}
