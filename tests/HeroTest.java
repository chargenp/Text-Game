package tests;

import src.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class HeroTest {
	
	@Test
	void testNameAndDescription() {
		Hero test = new Hero("Test", "strong", "boy");
		assertEquals(test.getName(), "Test");
		String actualDescription = test.getDescription();
		String expectedDescription = "You are a young farm-boy "
				+ "of nondescript features and easily blend into a crowd";
		assertEquals(actualDescription, expectedDescription);
	}
	
	@Test
	void testStats()
	{
		Hero test = new Hero("Test", "strong", "boy");
		assertEquals(11, test.getAgility());
		assertEquals(15, test.getStrength());		
		assertEquals(7, test.getIntelligence());
		assertEquals(13, test.getVitality());
		assertEquals(9, test.getCharisma());
		Hero test2 = new Hero("Test", "agile", "girl");
		assertEquals(14, test2.getAgility());
        assertEquals(8, test2.getStrength());       
        assertEquals(11, test2.getIntelligence());
        assertEquals(8, test2.getVitality());
        assertEquals(15, test2.getCharisma());
	}
	
	@Test
	void testStatImprovement()
	{
		Hero test = new Hero("Test", "strong", "boy");
		test.setAgility(test.getAgility() + 1);
		test.setStrength(test.getStrength() + 2);
		test.setVitality(test.getVitality() + 3);
		test.setIntelligence(test.getIntelligence() + 4);
		test.setCharisma(test.getIntelligence() + 5);
		assertEquals(12, test.getAgility());
		assertEquals(17, test.getStrength());
		assertEquals(16, test.getVitality());
		assertEquals(11, test.getIntelligence());
		assertEquals(16, test.getCharisma());
	}
}
