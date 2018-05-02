package src;
import java.util.Random;

public class Map
{
    private Random rng;
    private Room start;
    private Room current;
    private Room[] level0;
    private Room[] level1;
    private Room[] level2;
    
    public Map()
    { 	
        rng = new Random();
        StartVillage start = new StartVillage();
        TrollBridge trollBridge = new TrollBridge(new Troll(0), "Troll bridge");
        this.start = start;
        current = start;
        trollBridge.setFlavorText("spooky bridge, troll appears");
        Room forest1 = new Room(new Treant(0), "A forest");
        Room forest2 = new Room(new Spider(0), "A darken forest");
        Room meadow = new Room(new Skeleton(1),"A peaceful meadow");
        Room field = new Room(new Skeleton(0),"Gentle rolling fields");
        forest1.setFlavorText("An ancient forest. The trees seem as old as time and creak as if talking to each other.");
        forest2.setFlavorText("Shadows surround the forest, and large webs permiate the trees.");
        meadow.setFlavorText("");
        field.setFlavorText("");
        level0 = new Room[4];
        level0[0] = forest1;
        level0[1] = forest2;
        level0[2] = meadow;
        level0[3] = field;
        
        Room swamp = new Room(new Skeleton(2), "An erie swamp");
        swamp.setFlavorText("A dismal swamp filled with strange moving things under the waters.");
        Room witchDen = new Room(new Skeleton(3), "A witches Den");
        witchDen.setFlavorText("An old witches den. Hopefully it is abandoned.");
        Room forestL1 = new Room(new Treant(0), "A forest");
        forestL1.setFlavorText("A forest that looks normal, but upon close inspection signs of decay are prevalent.");
        Room crag = new Room(new Skeleton(3), "Rocky Crag");
        crag.setFlavorText("A rocky crag prodruding from the edge of a desert");
        level1 = new Room[4];
        level1[0] = swamp;
        level1[1] = witchDen;
        level1[2] = forestL1;
        level1[3] = crag;
        
        Room sea = new Room(new Kraken(3), "A deadly Sea");
        Room sea2 = new Room(new Skeleton(4), "A deadly Sea");
        sea2.setFlavorText("The dead haunt these Seas praying upon weak crews.");
        sea.setFlavorText("The misleadingly calm waters bring many to their doom.");
        level2 = new Room[2];
        level2[0] = sea;
        level2[1] = sea2;
        
        Room deathValley = new Room(new Skeleton(6), "Death valley");
        deathValley.setFlavorText("As soon as you step foot on the shore the heat swallows"
        		+ "\nyou. Before you is a mountain range. The only pass through to the evil "
        		+ "\nkingdom is well known: Death Valley.");
        Room FireMountain = new Room(new Pheonix(3), "Fire Mountain");
        FireMountain.setFlavorText("Heat and lava surround you. Ahead you can see the dark kingdom, but "
        		+ "the Pheonix is know to prey upon travellers here");
        
        //Level 0 procedure
        int tempInt = rng.nextInt(4);
        Room tempRoom1 = level0[tempInt];
        level0[tempInt] = null;
        Room tempRoom2 = null;
    	Room tempRoom3 = null;
    	Room tempRoom4 = null;
        while (tempRoom2 == null || tempRoom3 == null || tempRoom4 == null)
        {
        	tempInt = rng.nextInt(4);
        	if (tempRoom2 == null)
        	{
        		tempRoom2 = level0[tempInt];
        		level0[tempInt] = null;
        	}
        	else if (tempRoom3 == null)
        	{
        		tempRoom3 = level0[tempInt];
        		level0[tempInt] = null;
        	}
        	else if (tempRoom4 == null)
        	{
        		tempRoom4 = level0[tempInt];
        		level0[tempInt] = null;
        	}
        }       
        trollBridge.setWest(this.start);
        this.start.setEast(trollBridge);
        trollBridge.setEast(tempRoom1);
        tempRoom1.setWest(trollBridge);
        tempRoom1.setNorth(tempRoom2);
        tempRoom1.setEast(tempRoom3);
        tempRoom2.setSouth(tempRoom1);
        tempRoom3.setWest(tempRoom1);
        tempRoom3.setEast(tempRoom4);       
        tempRoom4.setWest(tempRoom3);
        Kingdom midTown = new Kingdom();
        tempRoom4.setEast(midTown);
        midTown.setWest(tempRoom4);
        
        //Level 1
        tempInt = rng.nextInt(4);
        tempRoom1 = level1[tempInt];
        level1[tempInt] = null;
        tempRoom2 = null;
    	tempRoom3 = null;
    	tempRoom4 = null;
        while (tempRoom2 == null || tempRoom3 == null || tempRoom4 == null)
        {
        	tempInt = rng.nextInt(4);
        	if (tempRoom2 == null)
        	{
        		tempRoom2 = level1[tempInt];
        		level1[tempInt] = null;
        	}
        	else if (tempRoom3 == null)
        	{
        		tempRoom3 = level1[tempInt];
        		level1[tempInt] = null;
        	}
        	else if (tempRoom4 == null)
        	{
        		tempRoom4 = level1[tempInt];
        		level1[tempInt] = null;
        	}
        }
        midTown.setNorth(tempRoom1);
        tempRoom1.setSouth(midTown);
        tempRoom1.setWest(tempRoom2);
        tempRoom1.setNorth(tempRoom3);
        tempRoom2.setEast(tempRoom1);
        tempRoom2.setNorth(tempRoom4);
        tempRoom3.setSouth(tempRoom1);
        tempRoom3.setWest(tempRoom4);
        tempRoom4.setSouth(tempRoom2);
        tempRoom4.setEast(tempRoom3);
        
      //Level 2 procedure
        tempInt = rng.nextInt(2);
        tempRoom1 = level2[tempInt];
        level2[tempInt] = null;
        for (int i = 0; i < 2; i++)
        {
        	if (level2[i] != null)
        	{
        		tempRoom2 = level2[i];
        		level2[i] = null;
        	}
        }
        
        midTown.setEast(tempRoom1);
        tempRoom1.setWest(midTown);
        tempRoom1.setEast(tempRoom2);
        tempRoom2.setWest(tempRoom1);
        tempRoom2.setEast(deathValley);
        deathValley.setWest(tempRoom2);
        deathValley.setEast(FireMountain);
        FireMountain.setWest(deathValley);
        EvilKingdom evilKingdom = new EvilKingdom(new Warlock(4), "The Evil Kingdom.");
        FireMountain.setEast(evilKingdom);
        evilKingdom.setWest(FireMountain);
    }
    
    public void resetMap()
    {
    	current = start;
    }
    
    public Room getCurrent()
    {
    	return current;
    }
    public void setCurrent(Room room)
    {
    	current = room;
    }
    
    public Room getStart()
    {
        return start;
    }
    
    public void monsterLoad()
    {
    	current.monsterDefeated();
    }
}
