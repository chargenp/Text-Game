package src;

import java.util.Scanner;
import java.util.Stack;
import java.util.Random;

public class Combat 
{
	private boolean inCombat;
	private Scanner input;
	private Hero hero;
	private Monster monster;
	private Game g;
	private Stack<String> actions;
	private Random rng;
	private int heroDamage;
	private int monsterDamage;
	private int count;

	public Combat(Hero hero, Monster monster, Game g)
	{

		rng = new Random();
		actions = new Stack<>();
		this.hero = hero;
		this.monster = monster;
		this.g = g;
		input = this.g.getInput();
		heroDamage = hero.attack();
		monsterDamage = monster.attack();
		inCombat = true;

	}
	
	public Stack<String> getActions()
	{
	    return actions;
	}

	public int smart()
	{
		if (hero.getIntelligence() >= 13)
		{
			System.out.println("\nYou outwit the Troll so that it pays you and heads away\n");
			int goldIncrease = (100 + (100 * (g.getCurrentRoom().getMonster().getLevel() + 1)));
			hero.getInventory().addGold(goldIncrease);
			System.out.println("You gained " + ((int) (monster.experienceReward() * .25)) + " experience points!");
			hero.setExperience(hero.getExperience() + (int) (monster.experienceReward() * .25));
			while (hero.getExperience() >= (100 * (hero.getLevel()) / 2))
			{
				hero.resetHealth();
				count = 3;
				System.out.println("You have leveled up!");
				while (count != 0)
				{        			
					String toIncrease = getIncrease();
					LoadIncrease(toIncrease);
					count--;
				}
				hero.setLevel(hero.getLevel() + 1);
				System.out.printf("\nStrength: %d\tVitality: %d\tAgility: %d\tIntelligence: %d\tCharisma: %d\n\n",  
						hero.getStrength(), hero.getVitality(), hero.getAgility(), hero.getIntelligence(), hero.getCharisma());

			}
			return 2;
		}
		else
		{
			System.out.println("\nYou confuse the troll enough to get a sneak attack in\n");
			this.monster.setHealth(monster.getHealth() - 60);
			return fight();
		}		
	}

	public int charm()
	{
		if (hero.getCharisma() >= 13)
		{
			System.out.println("\nYou are so charming the Troll lets you pass!\n");
			System.out.println("You gained " + monster.experienceReward() + " experience points!");
			hero.setExperience(hero.getExperience() + monster.experienceReward());
			while (hero.getExperience() >= (100 * (hero.getLevel()) / 2))
			{
				hero.resetHealth();
				count = 3;
				System.out.println("You have leveled up!");
				while (count != 0)
				{        			
					String toIncrease = getIncrease();
					LoadIncrease(toIncrease);
					count--;
				}
				hero.setLevel(hero.getLevel() + 1);
				System.out.printf("\nStrength: %d\tVitality: %d\tAgility: %d\tIntelligence: %d\tCharisma: %d\n\n",  
						hero.getStrength(), hero.getVitality(), hero.getAgility(), hero.getIntelligence(), hero.getCharisma());

			}
			return 2;
		}
		else
		{
			System.out.println("\nYou werent quite charming enough, but you were able to get a sneak attack in\n");
			this.monster.setHealth(monster.getHealth() - 60);
			return fight();
		}		
	}

	public int fight()
	{
		System.out.printf("\nYou are fighting a level %d %s", monster.getLevel() + 1, monster.getName());
		while (inCombat)
		{
			printHealth();
			String command = getCommand();
			LoadCommand(command, hero, g);
			while (!actions.isEmpty())
			{
				String tempAction = actions.pop();
				if (tempAction.equals("Monster Attack"))
				{
					int temp = ((rng.nextInt(9) + 1) + monsterDamage);
					System.out.println("Monster Damage : " + temp);
					hero.setHealth(hero.getHealth() - temp);
				}
				if (tempAction.equals("Hero Attack"))
				{
					int temp = ((rng.nextInt(hero.getAgility() + hero.getStrength()) + 1) + heroDamage);
					System.out.println("Hero Damage : " + temp);
					monster.setHealth(monster.getHealth() - temp);
				}
				if (tempAction.equals("Item"))
				{
					hero.getInventory().displayInventory();
					int count = 0;
					for (int i= 0; i < hero.getInventory().getSize(); i++)
					{
						if (hero.getInventory().getArray()[i] != null)
						{
							count ++;
			
						}
					}
					if (count != 0)
					{
						while (true)
						{
							System.out.println("\nSelect an item to use or \"exit\".");
							System.out.print("Command > ");
							System.out.flush();
							String itemInput = input.nextLine();
							if (itemInput.equalsIgnoreCase("potion"))
							{
								Consumable temp = hero.getInventory().getItem("potion");
								temp.consume(hero);
								hero.getInventory().consumeItem("potion");
								break;
							}
							if (itemInput.equalsIgnoreCase("exit"))
							{
								printHealth();
								LoadCommand(getCommand(), hero, g);
								break;
							}
						}
					}
					else
					{
						System.out.println("\nNo items!\n");
					}
				} 
				if (tempAction.equals("Run"))
				{	        		
					if (rng.nextInt(99) + 1 + (hero.getAgility() * 2.5) > 80)
					{
						System.out.println("You Escaped!");
						inCombat = false;
						return 0;
					}
				}
				if (monster.getHealth() <= 0)
				{
					System.out.println("\nYou beat the monster!");
					printHealth();
					inCombat = false;
					System.out.println("You gained " + monster.experienceReward() + " experience points!");
					hero.setExperience(hero.getExperience() + monster.experienceReward());
					while (hero.getExperience() >= (100 * (hero.getLevel()) / 2))
					{
						hero.resetHealth();
						count = 3;
						System.out.println("You have leveled up!");
						while (count != 0)
						{        			
							String toIncrease = getIncrease();
							LoadIncrease(toIncrease);
							count--;
						}
						hero.setLevel(hero.getLevel() + 1);
						System.out.printf("\nStrength: %d\tVitality: %d\tAgility: %d\tIntelligence: %d\tCharisma: %d\n\n",  
								hero.getStrength(), hero.getVitality(), hero.getAgility(), hero.getIntelligence(), hero.getCharisma());

					}
					return 1;
				}
				if (hero.getHealth() <= 0)
				{
					System.out.println("\nThe monster beat you!");
					printHealth();
					inCombat = false;
					return -1;
				}
			}      
		}
		return -1;
	}

	public void printHealth()
	{
		System.out.println("\nHealth: " + hero.getHealth() +"\tMana: " + hero.getMana() + "\t"
				+ "Monster Health: " + monster.getHealth() + "\tMonster Damage: " 
				+ (1 + monsterDamage) + " - " + (10 + monsterDamage) + "\n"
				+ "Hero Speed: " + (hero.getAgility() + (hero.getLevel() * 2)) + "\t\t\tMonster Speed: " 
				+ ((int) (monster.getAgility() + (monster.getAgility() * 1.1))) + "\n");
	}

	public void LoadIncrease(String toIncrease)
	{
		switch (toIncrease)
		{
		case "s":
			hero.setStrength(hero.getStrength() + 1);
			break;
		case "v":
			hero.increaseVitality(1);
			break;
		case "a":
			hero.setAgility(hero.getAgility() + 1);
			break;
		case "i":
			hero.setIntelligence(hero.getIntelligence() + 1);
			break;
		case "c":
			hero.setCharisma(hero.getCharisma() + 1);
			break;
		}
	}

	public String getIncrease()
	{
		System.out.printf("\nYou may increase %d stats, please choose one:"
				+ "\nStrength: %d\tVitality: %d\tAgility: %d\tIntelligence: %d\tCharisma: %d\n", count, 
				hero.getStrength(), hero.getVitality(), hero.getAgility(), hero.getIntelligence(), hero.getCharisma());
		System.out.print("command > ");
		System.out.flush();
		String command = input.nextLine();
		command.toLowerCase();
		if (command.equals("strength") || command.equals("s"))
		{
			return "s";
		}
		else if (command.equals("vitality")|| command.equals("v"))
		{
			return "v";
		}
		else if (command.equals("agility")|| command.equals("a"))
		{
			return "a";
		}
		else if (command.equals("intelligence")|| command.equals("i"))
		{
			return "i";
		}
		else if (command.equals("charisma")|| command.equals("c"))
		{
			return "c";
		}
		else
		{
			return getIncrease();
		}
	}
	public void LoadCommand(String command, Hero hero, Game g)
	{
		if (monster.getAgility() + (monster.getAgility() * 1.1) < (hero.getAgility() + (hero.getLevel() * 2)))
		{
			actions.push("Monster Attack");
		}
		if (command.equalsIgnoreCase("attack"))
		{
			actions.push("Hero Attack");
		}

		if ((monster.getAgility() + (monster.getAgility() * 1.1)) > (hero.getAgility() + (hero.getLevel() * 2)))
		{
			actions.push("Monster Attack");
		}
		if (command.equalsIgnoreCase("Item"))
		{
			actions.push("Item");
		}
		if (command.equalsIgnoreCase("Run"))
		{
			actions.push("Run");
		}
	}

	public String getCommand()
	{

		System.out.println("Actions:\n"
				+ "Attack(" + (1 + heroDamage) + " - " + (hero.getAgility() 
						+ hero.getStrength()+ heroDamage)+ ") Item Run(" + (20 + hero.getAgility() * 2.5) + "%)");
		System.out.print("command > ");
		System.out.flush();
		String command = input.nextLine();
		System.out.println("\n\n");
		command.toLowerCase();
		if (command.equals("attack") || command.equals("a"))
		{
			return "attack";
		}
		else if (command.equals("item") || command.equals("i"))
		{
			for (int i= 0; i < hero.getInventory().getSize(); i++)
			{
				if (hero.getInventory().getArray()[i] != null)
				{
					count ++;
				}
			}
			if (count == 0)
			{
				System.out.println("Inventory is Empty!");
				printHealth();
				return getCommand();
			}
			else
			{
				return "item";
			}
		}
		else if (command.equals("run") || command.equals("r"))
		{
			return "run";
		}
		else
		{
			return getCommand();
		}
	}

}
