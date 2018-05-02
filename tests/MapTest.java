package tests;

import static org.junit.jupiter.api.Assertions.*;
import src.Dialog;
import src.Map;
import src.TrollBridge;

import org.junit.jupiter.api.Test;

class MapTest {

	@Test
	void testRoomDescription()
	{
		Map test = new Map();
		assertEquals("Your farm at the village you grew up around.", test.getCurrent().getDescription());
	}
	
	@Test
	void testMonsters() 
	{
		Map test = new Map();
		test.setCurrent(test.getCurrent().getEast());
		assertTrue( test.getCurrent().hasMonster(), "There is no Monster in the room but should be.");
	}

	@Test
	void testItems()
	{
		Map test = new Map();
		test.setCurrent(test.getCurrent().getEast());
		assertTrue(((TrollBridge)test.getCurrent()).hasLoot(), "There is no loot but should be.");
		((TrollBridge)test.getCurrent()).removeLoot();
		assertFalse(((TrollBridge)test.getCurrent()).hasLoot(), "There is loot but should not be.");		 
	}
	
	@Test
	void testMapChanges()
	{
	    Dialog d = new Dialog();
	    d.getMother();
	    String test = d.getMother();
	    assertEquals("Hello my dear child.", test);
	    d.getBlacksmith();
	    assertEquals("World ending scary PH.", d.getMother());	    
	}
	
	@Test
	void testRandomlyGenerated()
	{	    
	    String string0 = "";
	    String string1 = "";
	    String string2 = "";
	    String string3 = "";
	    int count = 0;
	    for (int i = 0; i < 4; i++)
	    {
	        Map test = new Map();
	        test.setCurrent(test.getCurrent().getEast().getEast());
	        String temp = test.getCurrent().getDescription();
	        switch (i)
	        {
	            case 0:
	                string0 = temp;
	                break;
	            case 1:
	                string1 = temp;
	                break;
	            case 2:
	                string2 = temp;
	                break;
	            case 3:
	                string3 = temp;
	                break;
	        }
	    }
	    if (!(string0.equals(string1)))
        {
            count++;
        }
	    if (!(string0.equals(string2)))
        {
            count++;
        }
	    if (!(string0.equals(string3)))
        {
            count++;
        }
	    if (!(string1.equals(string2)))
        {
            count++;
        }
	    if (!(string1.equals(string3)))
        {
            count++;
        }
	    if (!(string2.equals(string3)))
        {
            count++;
        }
	    assertNotEquals(0, count);
	}
}
