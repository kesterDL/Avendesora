package src;

import characterTraits.Character;
import characterTraits.Classes.Classes;
import characterTraits.Race.RaceChoice;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Map;


public class CharacterTest {
    Character Loeb;

    @Before
    public void generateCharacter() {
        Loeb = new Character();
        Loeb.defaultCharacterStats();
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
    public void testHumanRace() {
        Loeb.setRaceObject(RaceChoice.HUMAN);
        Assert.assertTrue(Loeb.getSpeed() == 30);
    }

    @Test
    public void testDwarfRace() {
        Character John = new Character();
        John.defaultCharacterStats();
        int charisma = John.getCharisma();
        int con = John.getConstitution();

        John.setRaceObject(RaceChoice.DWARF);
        Assert.assertEquals(John.getConstitution(), con + 2, 0);
        Assert.assertEquals(John.getCharisma(), charisma - 2, 0);
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

    @Test
    public void testDwarfCleric() {
        Character muffin = new Character(RaceChoice.DWARF, Classes.CLERIC);
    }

    @Test
    public void dailySpells() {
        Character John = new Character(RaceChoice.HUMAN, Classes.CLERIC);
        int wisScore = John.getWisdom();
        Map<Integer, Integer>bonus = John.getJobObject().getBonusSpells();
        for (Integer key: bonus.keySet()) {
            System.out.println("bonus key: " + key);
        }
        if(wisScore < 12) {
            Assert.assertEquals(10, John.getJobObject().getBonusSpells().keySet().size(),0);
        } else {
            switch (wisScore) {
                case 12:
                case 13:
                    Assert.assertEquals(2, John.getJobObject().getBonusSpells().keySet().size(), 0);
                    Assert.assertEquals(John.getJobObject().getBonusSpells().get(0), 0, 0);
                    Assert.assertEquals(John.getJobObject().getBonusSpells().get(1), 1, 0);
                    break;
                case 14:
                case 15:
                    Assert.assertEquals(3, John.getJobObject().getBonusSpells().keySet().size(), 0);
                    Assert.assertEquals(John.getJobObject().getBonusSpells().get(0), 0, 0);
                    Assert.assertEquals(John.getJobObject().getBonusSpells().get(1), 1, 0);
                    Assert.assertEquals(John.getJobObject().getBonusSpells().get(2), 1, 0);
                    break;
                case 16:
                case 17:
                    Assert.assertEquals(4, John.getJobObject().getBonusSpells().keySet().size(), 0);
                    Assert.assertEquals(John.getJobObject().getBonusSpells().get(0), 0, 0);
                    Assert.assertEquals(John.getJobObject().getBonusSpells().get(1), 1, 0);
                    Assert.assertEquals(John.getJobObject().getBonusSpells().get(2), 1, 0);
                    Assert.assertEquals(John.getJobObject().getBonusSpells().get(3), 1, 0);
                    break;
                case 18:
                case 19:
                    Assert.assertEquals(5, John.getJobObject().getBonusSpells().keySet().size(), 0);
                    Assert.assertEquals(John.getJobObject().getBonusSpells().get(0), 0, 0);
                    Assert.assertEquals(John.getJobObject().getBonusSpells().get(1), 1, 0);
                    Assert.assertEquals(John.getJobObject().getBonusSpells().get(2), 1, 0);
                    Assert.assertEquals(John.getJobObject().getBonusSpells().get(3), 1, 0);
                    Assert.assertEquals(John.getJobObject().getBonusSpells().get(4), 1, 0);
                    break;
                default:

            }
        }

    }

}
