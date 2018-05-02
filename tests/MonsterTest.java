package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

import src.Combat;
import src.Game;
import src.Hero;
import src.Monster;
import src.Shoddy_Sword;

class MonsterTest
{

    @Test
    /*
     * Tests that monster entity can be created, combat takes place with damaging factors and rewards.
     */
    void testMonsterCombat()
    {   
        String testInput = "sword\na\na\na\na\n";
        Scanner testScan = new Scanner(testInput);
        Game g = new Game(testScan);
        Hero testHero = new Hero("Test", "strong", "boy");
        testHero.setLevel(20);
        testHero.getInventory().addItem(new Shoddy_Sword());
        testHero.equip(g);
        Monster monster = g.getCurrentRoom().getEast().getMonster();
        assertTrue(monster != null);
        Combat c1 = new Combat(testHero, monster, g);
        c1.charm();
        assertTrue(testHero.getHealth() < testHero.getMaxHealth());
        assertTrue(testHero.getExperience() > 0);
    }

}
