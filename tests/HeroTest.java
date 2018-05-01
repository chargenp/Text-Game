package tests;

import src.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class HeroTest {
	
	@Test
	void testName() {
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
	}
	
	void testStatImprovement()
	{
		Hero test = new Hero("Test", "strong", "boy");
		test.setAgility(test.getAgility() + 1);
		assertEquals(12, test.getAgility());
	}
}
