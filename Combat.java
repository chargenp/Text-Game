import java.util.Scanner;

public class Combat 
{
	private boolean inCombat;
	private Scanner input;
	private Hero hero;
	private Monster monster;
	private Game g;
	
	public Combat(Hero hero, Monster monster, Game g)
	{
		this.hero = hero;
		this.monster = monster;
		this.g = g;
		input = g.getInput();
		inCombat = true;
		while (inCombat)
		{
			String command = getCommand();
	        handleCommand(command, hero, g);
			inCombat = false;
		}
	}
	
	public void printHealth()
	{
		System.out.println("\nHealth: " + hero.getHealth() +"\tMana: " + hero.getMana() + "\t\t"
				+ "Monster Health: " + monster.getName() + "\n");
	}
	
	public String getCommand()
	{
		System.out.println("Actions:\n"
				+ "Attack Spell Item Run");
		System.out.print("command > ");
        System.out.flush();
        String command = input.nextLine();
        command.toLowerCase();
        if (command.equals("attack"))
        {
        	return command;
        }
        else if (command.equals("spell"))
        {
        	return command;
        }
        else if (command.equals("item"))
        {
        	return command;
        }
        else if (command.equals("run"))
        {
        	return command;
        }
        else
        {
        	return getCommand();
        }
	}
	
	public void handleCommand(String command, Hero hero, Game g)
	{
		
	}
}
