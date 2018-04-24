
public class Dialog 
{
    private String charName;
	private String mother;
	private String blacksmith;
	private int motherCount;
	private int blacksmithCount;
	
	public Dialog()
	{
	    motherCount = 0;
	    blacksmithCount = 0;
	}
	public void setCharName(String name)
	{
	       charName = name;
	}
	
	public void setMotherCount(int count)
	{  
	    this.motherCount = count;
	}
	
	public void setBlacksmithCount(int count)
	{
	    this.blacksmithCount = count;
	}
	public String getMother()
	{
	    switch (motherCount)
	    {
	        case 0:
	            mother = "Good morning my dear child. Have you heard the news? The King's daughter has"
	                + "\nkidnapped by the Warlock. The people in the village have always talked about a "
	                + "\nday like this coming, but I just wasn't sure when it would be. They spoke of a "
	                + "\nprophecy that would bring our savior. There are strange clouds forming around "
	                + "\nFire Mountain and beginning to come this way. I’m afraid of what’s going to happen. "
	                + "\nI know you're curious my child, so don't wander too far."
	                + "\n\nShe is right. You noticed the clouds forming this morning as you started your daily "
	                + "\nchores. Something uneasy was in the air, you could feel it with every breath. Adventure"
	                + "\nwas finally here. Or maybe it's just time to go back to bed.\n"
	                + "\nThe blacksmith in town has travelled all over the world and always knows the news. "
	                + "\nMaybe he could be of help.\n";
	            motherCount++;
	            return mother;
	        case 2:
	        	mother = "World ending scary PH.";
	        	motherCount++;
	            return mother;    
	    }
	    return "Hello my dear child.";
	}
	
	public String getBlacksmith()
	{
	    switch(blacksmithCount)
	    {
	        case 0:
	            blacksmith = "Afternoon Mister.\n\n"
	                + "What can I do you for today, kid. Did you break your shovel again, or does your axe need sharpening?\n\n"
	                + "No not today. I came to ask about the mysterious clouds. They seem to be heading towards the farm "
	                + "\nand darkness is taking over the sky.\n\n"
	                + "I just got news from the city and heard the townsfolk were talking about the darkness coming because "
	                + "\nthe Warlock stole the King's daughter. They say that the old Warlock is brewing up something mighty "
	                + "\nnasty. Story has it, that he needs the princess' blood so he can cast his spell and surround "
	                + "\neverything with darkness, he overthrow the kingdom and darkness will reign supreme.\n\n"
	                + "My mother talked of a prophecy of someone who could save us.\n\n"
	                + "Prophecy. Ha! Who in their right mind is going to do that?\n\n\n"
	                + "This is your chance. Maybe you have a right mind and will return home to your mother and farm.\n"
	                + "Or maybe you can keep talking to the blackmsith and start an adventure!";
	            motherCount++;
	            blacksmithCount++;
	            return blacksmith;
	        case 1:
	        	blacksmith = "If nobody else will save her, then I will!\n\n"
	        			+ "Kid, you’re crazy. You can’t! There is more than just clouds on that path. There are enemies you "
	        			+ "\nwill encounter stronger than you can imagine, seas full of creatures that you have never even "
	        			+ "\nheard of, and valleys that are so hot they can kill you in seconds.\n\n"
	        			+ "Don’t put your limits on me. Just because you and everyone else is scared, doesn’t mean "
	        			+ "\nI have to be. I’m going.\n\n"
	        			+ "Well kid I can’t stop you but I won’t allow you to go out there without a weapon. Take my old sword."
	        			+ "\nmaybe it will help you on your way. Here is a map aswell so you dont get lost. There are items you "
	        			+ "\nwill need to help you along the way, without them you will never survive. Please take my advice "
	        			+ "\nand stay on track. Word of advice kid, trolls aren’t always dangerous.\n";
	        	blacksmithCount++;
	        	setMotherCount(3);
				return blacksmith;
            default:
                return "Good'ay young'in.";
	    }
	}
}
