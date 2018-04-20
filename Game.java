import java.util.Scanner;

/**
 * 
 * @author Jeremy Latham, Nicole Young
 */
public class Game 
{
    private Room currentRoom;
    private Map map;

    public Game() 
    {
        map = new Map();
        this.currentRoom = map.getStart();
    }

    public String describeCurrentRoom() 
    {
        return currentRoom.getDescription();
    }

    public void handleCommand(String command)
    {
        command = command.toLowerCase();
        switch (command)
        {
            case "quit":
                System.exit(0);
            case "help" :
                handleHelp();
                break;
            case "exits":
                handleExit();
                break;
            case "look":
                handleLook();
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
        System.out.println("\"quit\" to quit the game");
        
    }
    public void handleLook()
    {
        System.out.println(currentRoom.getDescription());
    }

    public void handleExit()
    {

        if (currentRoom.getEast() != null)
        {
            System.out.print("east ");
        }
        if (currentRoom.getNorth() != null)
        {
            System.out.print("north ");
        }
        if (currentRoom.getSouth() != null)
        {
            System.out.print("south ");
        }
        if (currentRoom.getWest() != null)
        {
            System.out.print("west ");
        }
        System.out.println();
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
        while (input.hasNext()) 
        {
            String command = input.nextLine();
            g.handleCommand(command);
            prompt();
        }
    }

    public Room getCurrentRoom()
    {
        return currentRoom;
    }

    public boolean handleDesert(String command)
    {
        command = command.toLowerCase();
        String boar = "boar";
        String meerkat = "meerkat";

        if (command.equals(boar) || command.equals(meerkat))
        {
            System.out.println("You found them! Congradulations! This means no worries for the rest of your days!");
            handleCommand(command);
            return true;
        }
        else
        {
            handleCommand(command);
        }
        return false;
    }
    public boolean handleGraveyard(String command)
    {
        command = command.toLowerCase();
        String poke = "poke";
        if (command.equals(poke))
        {
            System.out.println("They fell on you and you died. Good job.");
            return true;
        }
        else
        {
            handleCommand(command);
        }
        return false;
    }
}
