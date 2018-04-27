import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * 
 * @author Jeremy Latham, Nicole Young
 */
public class Game 
{
    private Room currentRoom;
    private Map map;
    private static boolean playing = true;
    private int bsGreet = 0;
    private Dialog dialog;
    private Scanner input;
    private String inputList;
    private boolean troll;

    public Game() 
    {
        troll = false;
    	input = new Scanner(System.in);
        map = new Map();
        this.currentRoom = map.getStart();  
        dialog = new Dialog();
        inputList = "";
    }

    public String describeCurrentRoom() 
    {
        return currentRoom.getDescription();
    }
    
    public void RoomEnter(Room next, Game g)
    {
        if (next == map.getStart())
        {
            troll = false;
        }
        if (currentRoom instanceof TrollBridge && troll)
        {
            System.out.println("\nThe troll wont let you pass!\n");
            return;
        }
    	currentRoom = next;
    	g.map.setCurrent(next);
    	System.out.println(currentRoom.getDescription());
    	currentRoom.getIntro();
    	if (next instanceof TrollBridge)
    	{
    	    if (next.getMonster() != null)
    	    {
    	        troll = true;
    	    }
    	}
    }

    public void handleCommand(String command, Hero hero, Game g)
    {
        command = command.toLowerCase();
        switch (command)
        {
        	/*
        	 * Help pulled from javatutorialhq.com and howtodoinjava.com for save
        	 */
        	case "save":
        		String currentDirectory;
        		File file = new File("save.txt");
        		File heroFile = new File("heroFile.txt");
        		currentDirectory = file.getAbsolutePath();
        		System.out.println("Saving to : " + currentDirectory);
        		try
        		{
        		file.createNewFile();
        		heroFile.createNewFile();
        		FileWriter fwrite = new FileWriter(file);
        		FileWriter hWrite = new FileWriter(heroFile);
        		BufferedWriter writer = new BufferedWriter(fwrite);
        		BufferedWriter hWriter = new BufferedWriter(hWrite);
        		writer.append(inputList);
        		String temp = hero.getSave();
        		temp += " " + g.map.getCurrent().getMonster();
        		hWrite.append(temp);
        		writer.close();
        		hWriter.close();
        		}
        		catch (IOException io)
        		{
        			System.out.println("\nSave Error\n");
        		}
        		break;
        	case "charm":
        		if (g.map.getCurrent().hasMonster())
        		{
        			if (g.map.getCurrent().getMonster() instanceof Troll)
        			{
        				Combat charm = new Combat(hero, g.map.getCurrent().getMonster(), g);
        				int win = charm.charm();
        				switch (win)
            			{
            			case -1:  
            				hero.resetHealth();
            				g.map.resetMap();
            				currentRoom = g.map.getCurrent();
            				System.out.println("\nYou wake up back at home, feeling like you had a terrible dream\n");
            				System.out.println(currentRoom.getDescription() + "\n");
            				break;
            			case 0:
            				break;
            			case 1:
            				int goldIncrease = (100 + (100 * g.currentRoom.getMonster().getLevel()));
            				System.out.printf("You recieve %d gold\n", goldIncrease);
            				hero.getInventory().addGold(goldIncrease);
            				System.out.println(currentRoom.getDescription());
            				Monster tempMonster = g.currentRoom.getMonster();
            				g.currentRoom.monsterDefeated();
            				if (tempMonster instanceof Troll)
            				{
            				        troll = false;
            				}
            				break;
            			default:
            				break;
        			}
        		}       		
        		break;
        		}
        	case "outsmart":
        		if (g.map.getCurrent().hasMonster())
        		{
        			if (g.map.getCurrent().getMonster() instanceof Troll)
        			{
        				Combat smart = new Combat(hero, g.map.getCurrent().getMonster(), g);
        				int win = smart.smart();
        				switch (win)
            			{
            			case -1:
            			    g.currentRoom.getMonster().resetHealth();
            				hero.resetHealth();
            				g.map.resetMap();
            				currentRoom = g.map.getCurrent();
            				System.out.println("\nYou wake up back at home, feeling like you had a terrible dream\n");
            				System.out.println(currentRoom.getDescription() + "\n");
            				break;
            			case 0:
            				break;
            			case 1:
            				int goldIncrease = (100 + (100 * g.currentRoom.getMonster().getLevel()));
            				System.out.printf("You recieve %d gold\n", goldIncrease);
            				hero.getInventory().addGold(goldIncrease);
            				System.out.println(currentRoom.getDescription());
            				Monster tempMonster = g.currentRoom.getMonster();
            				g.currentRoom.monsterDefeated();
            				if (tempMonster instanceof Troll)
            				{
            				        troll = false;
            				}
            				break;
            			default:
            				break;
            			}
        			}
        		}       	
        		break;
        	case "inv" :
        		hero.getInventory().displayInventory();
        		System.out.println("Equipped: ");
        		hero.displayEquip();
        		System.out.println();
        		break;
        	case "fight":
        		if (g.map.getCurrent().hasMonster())
        		{
        			Combat c = new Combat(hero, g.map.getCurrent().getMonster(), g);
        			int win = c.fight();
        			switch (win)
        			{
        			case -1:
        			    
        				hero.resetHealth();
        				g.map.resetMap();
        				currentRoom = g.map.getCurrent();
        				System.out.println("\nYou wake up back at home, feeling like you had a terrible dream\n");
        				System.out.println(currentRoom.getDescription() + "\n");
        				break;
        			case 0:
        				break;
        			case 1:
        				int goldIncrease = (100 + (100 * g.currentRoom.getMonster().getLevel()));
        				System.out.printf("You recieve %d gold\n", goldIncrease);
        				hero.getInventory().addGold(goldIncrease);
        				System.out.println(currentRoom.getDescription());
        				Monster tempMonster = g.currentRoom.getMonster();
        				g.currentRoom.monsterDefeated();
        				if (tempMonster instanceof Troll)
        				{
        				        troll = false;
        				}
        				break;
        			}
        		}
        		break;
        	case "mother":
        		System.out.println(g.dialog.getMother());
        		break;
        	case "equip":
        		hero.equip(g);
        		break;
    		case "blacksmith":
    		    if (getCurrentRoom() instanceof StartVillage && bsGreet == 0)
    		    {
    		        System.out.println(dialog.getBlacksmith());
    		        bsGreet++;
    		    }
    		    else if (getCurrentRoom() instanceof StartVillage && bsGreet == 1)
    			{
    				System.out.println(dialog.getBlacksmith());
    				System.out.println("The blacksmith gives you a shoddy sword!\n"
    						+ "Dont forget to equip it!\n");
    				hero.getInventory().addItem(new Shoddy_Sword());
    				bsGreet++;
    			}
    			else
    			{
    			    System.out.println(dialog.getBlacksmith());
    			}
        		break;
        	case "self":
        		hero.getDescription();
        		break;
        	case "bed":
        		if (getCurrentRoom() instanceof StartVillage);
        		System.out.println("You give up and go back to bed. The kingdom is doomed. Thanks.");
        		handleCommand("quit", hero, g);
        		break;
        	case "stats":
        	    System.out.println("Max Health: " + hero.getMaxHealth());
        		System.out.println("Health: " + hero.getHealth());
        		System.out.println("Level: " + hero.getLevel());
        		System.out.println("Experience: " + hero.getExperience());
        		System.out.println("Next Level: " + ((100 * (hero.getLevel()) / 2)));
        		System.out.println("Mana: " + hero.getMana());
        		System.out.println("Strength: " + hero.getStrength());
        		System.out.println("Agility: " + hero.getAgility());
        		System.out.println("Intelligence: " + hero.getIntelligence());
        		System.out.println("Charisma: " + hero.getCharisma());
        		System.out.println("Vitality: " + hero.getVitality());
        		System.out.println();
        		break;
            case "quit":
                playing = false;
                System.exit(0);
                break;
            case "help" :
                handleHelp();
                break;
            case "exits":
            	g.map.getCurrent().getExits();
                break;
            case "east":
                if (currentRoom.getEast() != null)
                {
                	RoomEnter(currentRoom.getEast(), g);
                }
                break;
            case "west": 
                if (currentRoom.getWest() != null)
                {
                	RoomEnter(currentRoom.getWest(), g);

                }
                break;
            case "south":
                if (currentRoom.getSouth() != null)
                {
                	RoomEnter(currentRoom.getSouth(), g);
                }
                break;
            case "north":
                if (currentRoom.getNorth() != null)
                {
                	RoomEnter(currentRoom.getNorth(), g);
                }
                break;
            default:
                handleHelp();
                break;
        }
        if (!(command.equals("equip") || command.equals("help") || command.equals("exits") || command.equals("fight")))
    	{
    		inputList += command + " ";
        }
    }

    public void handleHelp()
    {
        System.out.println("\"help\" for a list of commands.\n\"exits\" for a list of exits and interactions.");
        System.out.println("\"quit\" to quit the game\n\"self\" for information about your character.");
        System.out.println("\"stats\" for character stat display.\n\"inv\" to display inventory and equipment.");
        System.out.println("\"equip\" to equip items from inventory.\n \"save\" to save.\n");
        
    }

    public static void prompt() 
    {
        System.out.print("command > ");
        System.out.flush();
    }
    
    public void newGame(Game g)
    {
    	System.out.println("It’s been years since there has been any adventure in the small town of "
                + "\nPurdue. Long days and quiet nights, the same routine day in and day out. It is just a "
                + "\nsimple mother and her child on their farm trying to make due. This is where our story begins….\n");
            System.out.println("Are you a boy, or a girl?");
            String gender = "";
            boolean gen = true;
            while (gen)
            {
                gender = input.nextLine();
                if (gender.equalsIgnoreCase("boy"))
                {
                    gen = false;
                }
                else if (gender.equalsIgnoreCase("girl"))
                {
                    gen = false;
                }
                else
                {
                    System.out.println("\nWrong input. Please type 'boy' or 'girl' without the quotes.\n");
                }
            }
            System.out.println("What is your name?");
            String nameTemp = "";
            while (nameTemp.isEmpty())
            {
            	nameTemp = input.nextLine();
            }
            String typeTemp = "";
            Boolean build = true;
            System.out.println("What type of person are you? Strong? Agile? Smart? Choose one.");
            while (build)
            {
                typeTemp = input.nextLine();
                if (typeTemp.equalsIgnoreCase("strong"))
                {
                    build = false;
                }
                else if (typeTemp.equalsIgnoreCase("agile"))
                {
                    build = false;
                }
                else if (typeTemp.equalsIgnoreCase("smart")) 
                {   
                    build = false;
                }
                else
                {
                    System.out.println("\nWrong input. Please type 'strong' 'agile' or 'smart' without the quotes.\n");
                }
            }     
            Hero hero = new Hero(nameTemp, typeTemp, gender); 
            System.out.println("\nType \"help\" anytime for a command list.\n");
            ((StartVillage)g.map.getCurrent()).getIntro();
            System.out.println(g.dialog.getMother());
            inputList += gender + " " + nameTemp + " " + typeTemp + " ";
            prompt();
            while (playing) 
            {
                String command = input.nextLine();
                handleCommand(command, hero, g);
                prompt();
            }
    }
    
    public void loadGame(Game g)
    {
    	File loadFile = new File("save.txt");
    	File heroLoadFile = new File("heroFile.txt");
		try
		{
			Scanner load = new Scanner(loadFile);
			Scanner heroLoad = new Scanner(heroLoadFile);
			System.out.println("It’s been years since there has been any adventure in the small town of "
	                + "\nPurdue. Long days and quiet nights, the same routine day in and day out. It is just a "
	                + "\nsimple mother and her child on their farm trying to make due. This is where our story begins….\n");
	            System.out.println("Are you a boy, or a girl?");
	            String gender = load.next();
	            inputList += gender + " ";
	            System.out.println("command > " + gender);
	            System.out.println("What is your name?");
	            String nameTemp = load.next();
	            inputList += nameTemp + " ";
	            System.out.println("command > " + nameTemp);
	            String typeTemp = load.next();
	            inputList += typeTemp + " ";
	            System.out.println("What type of person are you? Strong? Agile? Smart? Choose one.");
	            System.out.println("command > " + typeTemp);
	            Hero hero = new Hero(nameTemp, typeTemp, gender); 
	            System.out.println("\nType \"help\" anytime for a command list.\n");
	            ((StartVillage)g.map.getCurrent()).getIntro();
	            System.out.println(g.dialog.getMother());
	            while (load.hasNext())
            	{
	                System.out.print("command > ");
	                System.out.flush();
            		String command = load.next();
            		System.out.println(command);
            		handleCommand(command, hero, g);
            	}
            	load.close();
            	int tempInt = heroLoad.nextInt();
            	hero.setLevel(tempInt);
            	hero.setExperience(heroLoad.nextInt());
            	hero.setStrength(heroLoad.nextInt());
            	hero.setVitality(heroLoad.nextInt());
            	hero.setAgility(heroLoad.nextInt());
            	hero.setIntelligence(heroLoad.nextInt());
            	hero.setCharisma(heroLoad.nextInt());
            	hero.setHealth(heroLoad.nextInt());
            	hero.setMaxHealth(heroLoad.nextInt());
            	hero.getInventory().loadGold(heroLoad.nextInt());
            	String tempWeapon = heroLoad.next();
            	tempWeapon = tempWeapon.trim();
            	// Stringbuilder idea gotten from stack overflow
            	StringBuilder str = new StringBuilder(tempWeapon);
            	str.deleteCharAt(tempWeapon.length() - 1);
            	str.deleteCharAt(0);
            	tempWeapon = str.toString();
            	hero.loadCreateWeapon(tempWeapon);
            	String temp = heroLoad.next();
            	if (temp.equals("null"))
            	{
            		g.map.monsterLoad();
            	}
            	heroLoad.close();
            	prompt();
	            while (playing) 
	            {            	
	                String command = input.nextLine();
	                handleCommand(command, hero, g);
	                prompt();
	            }
		}
		catch (FileNotFoundException ex)
		{
			System.out.println("No save file found. Starting new game\n");
			newGame(g);
		}
    }

    public static void main(String[] args)
    {  
        Game g = new Game(); 
        System.out.println("\"New\" game or \"Load\"?");
        System.out.print("command > ");
        System.out.flush();
        boolean start = true;
        String startStatus = "";
        while (start)
        {
        	startStatus = g.input.nextLine();
        	if (startStatus.equalsIgnoreCase("new"))
        	{
        		start = false;
        		g.newGame(g);
        	}
        	if (startStatus.equalsIgnoreCase("load"));
        	{
        		g.loadGame(g);
        	}
        }
        
    }
    
    public Room getCurrentRoom()
    {
        return currentRoom;
    }
    
    public Scanner getInput()
    {
    	return input;
    }
}
