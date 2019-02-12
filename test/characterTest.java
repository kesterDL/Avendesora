import characterTraits.Character;
import characterTraits.Classes.Classes;
import characterTraits.Dice;
import characterTraits.Gender;
import characterTraits.Race.RaceChoice;
import org.junit.Assert;
import org.junit.Test;

public class characterTest {
    Character Loeb = new Character(RaceChoice.HUMAN, Classes.FIGHTER, Gender.MALE);
    @Test
    void rollStats() {
        int stat = Loeb.rollAnAbilityStat();
        Assert.assertTrue(stat > 2 && stat < 19);
    }
}
