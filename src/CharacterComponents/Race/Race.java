package CharacterComponents.Race;

import CharacterComponents.Classes.Classes;
import CharacterComponents.Languages;
import CharacterComponents.Sizes;
import CharacterComponents.Vision;
import java.util.List;
import java.util.Map;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public interface Race {
    /**
     * Racial Ability Score Modifiers.
     */
    Map<String, Integer> getAbilityAdjustments();
    /**
     * Racial Favored JobClass.
     */
    List<Classes> getFavoredClasses();
    /**
     * Racial Skill Points.
     */
    int getRacialSkillPoints();
    /**
     * Base Movement Speed on Land.
     */
    int getBaseLandSpeed();
    /**
     * Racial Language.
     */
    List<Languages> getAutomaticLanguage();
    /**
     * Number of bonus languages.
     */
    List<Languages> getBonusLanguages();
    /**
     * Vision types.
     */
    List<Vision> getVision();
    /**
     * Physical size.
     */
    Sizes getSize();
    /**
     * Race Type.
     */
    RaceChoice getRace();

    static Race raceFactory(RaceChoice raceChoice) {
        switch(raceChoice) {
            case HUMAN:
                return new Human();
            case DWARF:
                return new Dwarf();
            default:
                throw new NotImplementedException();
        }
    }

}
