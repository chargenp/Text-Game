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
	public int fight()
	{
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
	        		hero.setHealth(hero.getHealth() - ((rng.nextInt(9) + 1) + monsterDamage));
	        	}
	        	if (tempAction.equals("Hero Attack"))
	        	{
	        		monster.setHealth(monster.getHealth() - ((rng.nextInt(9) + 1) + heroDamage));
	        	}
	        	if (tempAction.equals("Item"))
	        	{

	        	}
	        	if (tempAction.equals("Run"))
	        	{	        		
	        		if (rng.nextInt(99) + 1 + (hero.getAgility() * 3) > 80)
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
	        		if (hero.getExperience() >= (100 * hero.getLevel()))
	        		{
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
		System.out.println("\nHealth: " + hero.getHealth() +"\tMana: " + hero.getMana() + "\t\t"
				+ "Monster Health: " + monster.getHealth() + "\n");
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
		if (monster.getAgility() < hero.getAgility())
		{
			actions.push("Monster Attack");
		}
		if (command.equalsIgnoreCase("attack"))
		{
			actions.push("Hero Attack");
		}
		if (command.equalsIgnoreCase("Item"))
		{
			actions.push("Item");
		}
		if (command.equalsIgnoreCase("Run"))
		{
			actions.push("Run");
		}
		if (monster.getAgility() > hero.getAgility())
		{
			actions.push("Monster Attack");
		}
	}
	
	public String getCommand()
	{
		System.out.println("Actions:\n"
				+ "Attack Item Run");
		System.out.print("command > ");
        System.out.flush();
        String command = input.nextLine();
        command.toLowerCase();
        if (command.equals("attack") || command.equals("a"))
        {
        	return "attack";
        }
        else if (command.equals("item") || command.equals("i"))
        {
        	return "attack";
        }
        else if (command.equals("run") || command.equals("r"))
        {
        	return command;
        }
        else
        {
        	return getCommand();
        }
	}

}
