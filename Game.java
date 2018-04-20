import java.util.Scanner;

/**
 * 
 * @author Jeremy Latham, Daniel Trombley, Nicole Young
 *
 */
public class Game 
{
    private Room currentRoom;

    public Game(Room startingRoom) 
    {
        this.currentRoom = startingRoom;
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
        }
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

    public static void main(String[] args) {
        Boolean egg = false;
        Scanner input = new Scanner(System.in);
        Room forest = new Room("A magical forest, totally not like the example given.");
        Room rock = new Room("A huge rock full of pride.");
        Room graveyard = new Room("It's a graveyard full of large mammalian bones. Not elephants. Don't poke it.");
        Room wateringHole = new Room("It's a watering hole. This where the animals come to get drunk");
        Room ravine = new Room("A large ravine with lots of antelopes. There's a lion corpse in the corner.");
        Room shadowLands = new Room("This is where the light doesn't touch. Full of Scar(s).");
        Room desert = new Room("A large desert. Look for the meerkat and the boar.");
        Room river = new Room("A river flowing from the base of a waterfall. There's a nice log running across the waterfall.");
        Room start = rock;

        forest.setWest(rock);
        forest.setNorth(desert);
        forest.setSouth(river);
        rock.setNorth(ravine);
        rock.setWest(shadowLands);
        rock.setEast(forest);
        rock.setSouth(wateringHole);
        graveyard.setSouth(shadowLands);
        graveyard.setEast(ravine);
        wateringHole.setNorth(rock);
        wateringHole.setEast(river);
        ravine.setSouth(rock);
        ravine.setEast(desert);
        ravine.setWest(graveyard);
        shadowLands.setEast(rock);
        shadowLands.setNorth(graveyard);
        desert.setWest(ravine);
        desert.setSouth(forest);
        river.setNorth(forest);
        river.setWest(wateringHole);       

        Game g = new Game(start);
        System.out.println(g.describeCurrentRoom());
        prompt();
        while (input.hasNext()) 
        {
            String command = input.nextLine();
            if (g.getCurrentRoom() == graveyard)
            {
                if (g.handleGraveyard(command) == true)
                {
                    input.close();
                    break;
                }
            }
            else if ((g.getCurrentRoom() == desert) && egg == false)
            {
                if (g.handleDesert(command) == true);
                {
                    egg = true;
                    g.eggDesert(desert);
                }
                System.out.println(g.describeCurrentRoom());
                prompt();
            }
            else
            {
                g.handleCommand(command);
                System.out.println(g.describeCurrentRoom());
                prompt();
            }

        }
    }

    public Room getCurrentRoom()
    {
        return currentRoom;
    }

    public void eggDesert(Room r)
    {
        r.setDescription("Just a desert.");
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
