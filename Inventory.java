
public class Inventory 
{
	private Item[] inventory;
	private Item[] equipped;
	private int size;
	
	public Inventory()
	{
	    size = 20;
		inventory = new Item[size];
		equipped = new Item[size];
		
	}
	   
    public void addItem(Item item)
    {
    	int i = 0;
    	while (inventory[i] != null && i < size)
    	{
    		i++;
    	}
    	inventory[i] = item;
    }
    
    public void equip(Item toEquip)
    {
    	int small = -1;
    	for (int i = 0; i < size; i++)
    	{
    		if (toEquip.toString().equals(inventory[i].toString()))
    		{
    			if (toEquip instanceof Weapon)
    			{
    				for (int k = 0; k < size; k++)
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
    
    public void displayInventory()
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
    	int count = 0;
    	for (int i = 0; i < size; i++)
    	{
    		if (equipped[i] != null)
    		{
    			System.out.print(equipped[i].getName() + " ");
    			System.out.print("\n\n");
    		}
    		else
    		{
    			count++;
    		}
    	}
    	if (count == size)
    	{
    		System.out.println("Nothing Equipped!\n");
    	}
    }
}
