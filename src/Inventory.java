package src;

public class Inventory 
{
	private Item[] inventory;
	private Item[] equipped;
	private int size;
	private final int EQUIP_SIZE = 4;
	private int gold;
	
	public Inventory()
	{
	    size = 5;
		inventory = new Item[size];
		equipped = new Item[EQUIP_SIZE];
		gold = 100;
	}
	
	public Item[] getArray()
	{
	    return inventory;
	}
	public int getSize()
	{
	    return size;
	}
	
	public int getGold()
	{
		return gold;
	}
	
	public void loadGold(int amount)
	{
	    gold = amount;
	}
	
	public void addGold(int amount)
	{
		gold += amount;
	}
	
	public void removeGold(int amount)
	{
		gold -= amount;
	}
	
	public Consumable getItem(String itemName)
	{
	    for (int i = 0; i < size; i++)
        {
            if (inventory[i].toString().equalsIgnoreCase(itemName))
            {
                Consumable temp = ((Consumable)inventory[i]);
                return temp;
            }
        }
	    return null;
	}
	
	public void consumeItem(String itemName)
	{
	    for (int i = 0; i < size; i++)
	    {
	        if (inventory[i].toString().equalsIgnoreCase(itemName))
	        {
	            inventory[i] = null;
	        }
	    }
	}

    public void addItem(Item item)
    {
    	int i = 0;
    	while (i < size)
    	{
    	    if (inventory[i] == null)
    	    {
    	        break;
    	    }
    		i++;
    	}
    	if (i >= size)
    	{
    	    System.out.println("Inventory full.");
    	    return;
    	}
    	inventory[i] = item;
    }
    
    public void addItem(String item)
    {
        int i = 0;
        Item temp = null;
        while (inventory[i] != null && i < size)
        {
            i++;
        }
        if (i > size)
        {
            System.out.println("Inventory full.");
            return;
        }
        switch (item)
        {
            case "Potion":
            	temp = new Potion();
        }
        inventory[i] = temp;
    }
    
    public void equip(Item toEquip)
    {
    	int small = -1;
    	for (int i = 0; i < size; i++)
    	{
    		if(inventory[i] != null)
    		{
    			if (toEquip.toString().equals(inventory[i].toString()))
    			{
    				if (toEquip instanceof Weapon)
    				{
    					for (int k = 0; k < EQUIP_SIZE; k++)
    					{
    						if (equipped[k] == null)
    						{
    							if (small == -1)
    							{
    								small = k;
    							}
    						}
    						else if (equipped[k] instanceof Weapon)
    						{
    							Item temp = equipped[k];
    							equipped[k] = toEquip;
    							inventory[i] = null;
    							addItem(temp);
    						}
    					}
    					if (small != -1)
    					{
    						equipped[small] = toEquip;
    						inventory[i] = null;
    						return;
    					}
    				}
    			}	
    		}
    	}
    }
    public void equipLoad(Weapon weapon)
    {
    	for (int i = 0; i < EQUIP_SIZE; i++)
    	{
    		if (equipped[i] == null)
    		{
    			equipped[i] = weapon;
    			return;
    		}
    	}
    }
    
    public void displayInventory()
    {
    	System.out.println("Gold: " + gold + "\n");
    	for (int i = 0; i < size; i++)
    	{
    		if (inventory[i] != null)
    		{
    			System.out.print("[" + inventory[i].getName() + "] ");
    			
    		}
    		else
    		{
    			System.out.print("[] ");
    		}
    	}
    	System.out.print("\n\n");
    }
    
    public String invSave()
    {
        String temp = size + "\n";
        for (int i = 0; i < size; i++)
        {
            if (inventory[i] != null)
            {
                temp += inventory[i].getName() + "\n";
                
            }
            else
            {
                temp += "x" + "\n";
            }
        }
        for (int i = 0; i < EQUIP_SIZE; i++)
        {
            if (equipped[i] != null)
            {
                temp += equipped[i] + "\n";
            }
            else 
            {
            	temp += "x\n";
            }
        }
        return temp;
    }
    
    public boolean checkEquipment(Hero hero)
    {
    	int count = 0;
    	for (int i = 0; i < size; i++)
    	{
    		if (inventory[i] != null)
    		{
    			if (inventory[i] instanceof Weapon)
    			{
    				count++;
    			}
    		}
    	}
    	return count > 0;
    }
    
    public void displayEquipment()
    {
    	int count = 0;
    	for (int i = 0; i < size; i++)
    	{
    		if (inventory[i] != null)
    		{
    			System.out.print(inventory[i].getName() + " ");
    			System.out.print("\n\n");
    		}
    		else
    		{
    			count++;
    		}
    	}
    	if (count == size)
    	{
    		System.out.println("Your inventory is empty!\n");
    	}
    }
    
    public void displayEquipped()
    {
    	for (int i = 0; i < EQUIP_SIZE; i++)
    	{
    		if (equipped[i] != null)
    		{
    			System.out.print(equipped[i].getName() + " ");			
    		}
    		else
    		{
    			System.out.print("[] ");
    		}
    	}	
		System.out.print("\n\n");
    }
}
