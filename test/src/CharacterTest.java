package src;

import characterTraits.Character;
import characterTraits.Classes.Classes;
import characterTraits.Race.RaceChoice;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;


public class CharacterTest {
    Character Loeb;

    @Before
    public void generateCharacter() {
        Loeb = new Character();
    }

    @Test
    public void testRolls() {
        boolean outsideBounds = false;
        LinkedList<Integer> rolls = new LinkedList<>();

        for(int i = 0; i < 1000 ; i++) {
            rolls.add(Loeb.rollAnAbilityStat());
        }
        for (int i = 0; i < 1000 ; i++) {
            if (rolls.get(i) > 18 || rolls.get(i) < 3) {
                outsideBounds = true;
            }
        }
        Assert.assertFalse(outsideBounds);
    }

    @Test
    public void testRace() {
        Loeb.setRaceChoice(RaceChoice.HUMAN);
        Assert.assertTrue(Loeb.getSpeed() == 30);
    }

    @Test
    public void testClass() {
        Character John = new Character(RaceChoice.HUMAN, Classes.FIGHTER);
        Assert.assertTrue(John.getUnallocatedSkillPoints() > 0);
    }

    @Test
    public void testModifiers() {
        Loeb.setIntelligence(12);
        Assert.assertTrue(Loeb.getIntelligence() == 12);
        Assert.assertEquals(1, Loeb.getIntelligenceModifier(), 0);

        Loeb.setStrength(16);
        Assert.assertEquals(3, Loeb.getStrengthModifier(), 0);
    }

    @Test
    public void testSavingThrows() {
        Character John = new Character(RaceChoice.HUMAN, Classes.FIGHTER);
        // Fort Saving
        Assert.assertEquals((2 + John.getConstitutionModifier()), John.getFortitudeSavingThrow(), 0);
        // Reflex Saving
        Assert.assertEquals(John.getDexterityModifier(), John.getReflexSavingThrow(),0);
        // Will Saving
        Assert.assertEquals(John.getWisdomModifier(), John.getWillSavingThrow(), 0);
    }

}
