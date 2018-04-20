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

    public Game() 
    {
        map = new Map();
        this.currentRoom = map.getStart();
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
        	case "stats":
        		System.out.println("Health: " + hero.getHealth());
        		System.out.println("Mana: " + hero.getMana());
        		System.out.println("Strength: " + hero.getStrength());
        		System.out.println("Agility: " + hero.getAgility());
        		System.out.println("Intelligence: " + hero.getIntelligence());
        		System.out.println("Charisma: " + hero.getCharisma());
        		System.out.println("Vitality: " + hero.getVitality());
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
        System.out.println("\"help\" for a list of commands.\n\"exits\" for a list of exits.");
        System.out.println("\"quit\" to quit the game\n\"self\" for information about your character.");
        System.out.println("\"stats\" for character stat display.");
        
    }

    public static void prompt() {
        System.out.print("command > ");
        System.out.flush();
    }

    public static void main(String[] args)
    {  
        Game g = new Game();
        Scanner input = new Scanner(System.in);
        System.out.println("What is your name?");
        String nameTemp = "";
        while (nameTemp.isEmpty())
        {
        	nameTemp = input.nextLine();
        }
        String typeTemp = "";
        Boolean build = true;
        System.out.println("What type of person are you? Strong?");
        while (build)
        {
            typeTemp = input.nextLine();
            if (typeTemp.equalsIgnoreCase("strong"))
            {
                build = false;
            }
        }     
        Hero hero = new Hero(nameTemp, typeTemp); 
        System.out.println("Type \"help\" anytime for a command list.");
        System.out.println(g.describeCurrentRoom());
        prompt();
        while (playing) 
        {
            String command = input.nextLine();
            g.handleCommand(command, hero, g);
            prompt();
        }
    }

    public Room getCurrentRoom()
    {
        return currentRoom;
    }
}
