package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import src.Monster;
import src.Skeleton;

class ItemTest
{

    @Test
    
    void testMonstersUseItems()
    {
        Monster skeleton = new Skeleton(0);
        assertTrue(skeleton.getWeapon() != null);
    }
}
