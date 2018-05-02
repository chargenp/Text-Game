package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;

import org.junit.jupiter.api.Test;

import src.Combat;
import src.Game;
import src.Hero;
import src.Monster;
import src.Skeleton;

class TechnicalTest
{

    @Test
    void testStack()
    {
        Hero testHero = new Hero("Test", "strong", "boy");
        Monster monster = new Skeleton(0);
        Game g = new Game();
        Combat c1 = new Combat(testHero, monster, g);
        assertTrue(c1.getActions() != null, "Stack should exist but doesn't.");
        c1.LoadCommand("attack", testHero, g);
        Stack<String> testStack = c1.getActions();
        assertFalse(testStack.isEmpty(), "Stack shouldnt be empty but is.");
    }

}
