package src;

import characterTraits.Character;
import characterTraits.Classes.Classes;
import characterTraits.Gender;
import characterTraits.Race.RaceChoice;
import org.junit.jupiter.api.Test;

public class CharacterTest {
    Character Loeb = new Character(RaceChoice.HUMAN, Classes.FIGHTER, Gender.MALE);

    @Test
    public void testRolls() {

    }
}
