package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import src.Game;
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
		boolean temp = test.getCurrent().hasLoot();
		assertTrue(temp, "There is no loot but should be.");
		((TrollBridge)test.getCurrent()).removeLoot();
		temp = test.getCurrent().hasLoot();
		assertTrue(temp, "There is loot but should not be.");
		 
	}
}
