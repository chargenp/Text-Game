import java.util.Scanner;

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

    public Game() 
    {
    	input = new Scanner(System.in);
        map = new Map();
        this.currentRoom = map.getStart();  
        dialog = new Dialog();
    }

    public String describeCurrentRoom() 
    {
        return currentRoom.getDescription();
    }

    public void handleCommand(String command, Hero hero, Game g)
    {
        command = command.toLowerCase();
        switch (command)
        {
        	case "inv" :
        		hero.getInventory().displayInventory();
        		System.out.println("Equipped: ");
        		hero.displayEquip();
        		System.out.println();
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
    			if (getCurrentRoom() instanceof StartVillage && bsGreet == 1)
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
        		System.out.println("Health: " + hero.getHealth());
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
                    currentRoom = currentRoom.getEast();
                }
                break;
            case "west": 
                if (currentRoom.getWest() != null)
                {
                    currentRoom = currentRoom.getWest();
                }
                break;
            case "south":
                if (currentRoom.getSouth() != null)
                {
                    currentRoom = currentRoom.getSouth();
                }
                break;
            case "north":
                if (currentRoom.getNorth() != null)
                {
                    currentRoom = currentRoom.getNorth();
                }
                break;
            default:
                handleHelp();
                break;
        }
    }

    public void handleHelp()
    {
        System.out.println("\"help\" for a list of commands.\n\"exits\" for a list of exits and interactions.");
        System.out.println("\"quit\" to quit the game\n\"self\" for information about your character.");
        System.out.println("\"stats\" for character stat display.\n\"inv\" to display inventory and equipment.");
        System.out.println("\"equip\" to equip items from inventory\n");
        
    }

    public static void prompt() 
    {
        System.out.print("command > ");
        System.out.flush();
    }

    public static void main(String[] args)
    {  
        Game g = new Game(); 
        System.out.println("It’s been years since there has been any adventure in the small town of "
            + "\nPurdue. Long days and quiet nights, the same routine day in and day out. It is just a "
            + "\nsimple mother and her child on their farm trying to make due. This is where our story begins….\n");
        System.out.println("Are you a boy, or a girl?");
        String gender = "";
        boolean gen = true;
        while (gen)
        {
            gender = g.input.nextLine();
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
        	nameTemp = g.input.nextLine();
        }
        g.dialog.setCharName(nameTemp);
        String typeTemp = "";
        Boolean build = true;
        System.out.println("What type of person are you? Strong? Agile? Smart? Choose one.");
        while (build)
        {
            typeTemp = g.input.nextLine();
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
        prompt();
        while (playing) 
        {
            String command = g.input.nextLine();
            g.handleCommand(command, hero, g);
            prompt();
        }
    }
    
    public Room getCurrentRoom()
    {
        return currentRoom;
    }
    
    public Scanner input()
    {
    	return input;
    }
}
