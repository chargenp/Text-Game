package src;


public class Hero
{
	private Inventory inventory;
    private String name;
    private String gender;
    private int level;
    private int health;
    private int strength;
    private int agility;
    private int intelligence;
    private int charisma;
    private int vitality;
    private int mana;
    private Weapon weapon;
    private int experience;
    private int maxHealth;
    private String description;
    
    public Hero(String name, String build, String gender)
    {
        this.name = name;
        this.gender = gender;
        experience = 0;
        if (build.toLowerCase().equals("strong"))
        {
        	strength = 14;
        	agility = 10;
        	intelligence = 7;
        	charisma = 9;
        	vitality = 12;
        }
        if (build.toLowerCase().equals("agile"))
        {
            strength = 8;
            agility = 14;
            intelligence = 9;
            charisma = 13;
            vitality = 8;
        }
        if (build.toLowerCase().equals("smart"))
        {
            strength = 7;
            agility = 8;
            intelligence = 14;
            charisma = 9;
            vitality = 12;
        }
        health = 100 + vitality * 10;
        maxHealth = health;
        mana = intelligence * 10;
        level = 0;
        inventory = new Inventory();
        weapon = null;
        if (gender == "boy")
        {
        	strength++;
        	agility++;
        	vitality++;
        }
        else
        {
        	intelligence += 2;
        	charisma += 2;
        }
        description = String.format("You are a young farm-%s of nondescript features "
        		+ "and easily blend into a crowd", gender);
        
    }
    
    public void resetHealth()
    {
    	health = maxHealth;
    }
    
    public int attack()
    {
    	if (weapon == null)
    	{
    		return 1;
    	}
    	return weapon.damage(strength, agility);
    }
    
    public String getDescription()
    {
    	return description;
    }
    
    public void setMana(int mana)
    {
    	this.mana = mana;
    }
    
    public int getMana()
    {
    	return mana;
    }
    
    public int getMaxHealth()
    {
        return maxHealth;
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
    public void increaseVitality(int increase)
    {
        this.vitality += increase;
        maxHealth = 100 + this.vitality * 10;
        health += 10 * increase;
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
    
    public void setExperience(int xp)
    {
    	experience = xp;
    }
    
    public int getExperience()
    {
    	return experience;
    }
    
    public int getLevel()
    {
    	return level;
    }
    
    public Inventory getInventory()
    {
    	return inventory;
    }
    
    public String getGender()
    {
    	return gender;
    }
    
    public void loadCreateWeapon(String weapon)
    {
        if (weapon.equalsIgnoreCase("sword"))
        {
            this.weapon = new Shoddy_Sword();
            inventory.equipLoad(this.weapon);
        }
        
    }
    
    public void equip(Game g)
    {
    	if (inventory.checkEquipment(this))
    	{
    		System.out.println("Choose what to equip or \"cancel\".\n");
    		inventory.displayEquipment();
			switch (g.getInput().nextLine().toLowerCase())
			{
				case "sword":
					weapon = new Shoddy_Sword();
					inventory.equip(weapon);
				break;
				case "cancel":
					break;
				default:
					System.out.println("Incorrect choice!\n");
					equip(g);
			}
    	}
    	else
    	{
    		System.out.println("You have nothing to equip!\n");
    	}
    }
    
    public void setMaxHealth(int maxHealth)
    {
        this.maxHealth = maxHealth;
    }
    
    public void displayEquip()
    {
    	inventory.displayEquipped();
    }
    
    public String getSave()
    {
        String temp = String.format("%d %d %d %d %d %d %d %d %d %d %s", 
            level, experience, strength, vitality, agility, intelligence, charisma, health, 
            maxHealth, inventory.getGold(), inventory.invSave());
        return temp;
    }
}
