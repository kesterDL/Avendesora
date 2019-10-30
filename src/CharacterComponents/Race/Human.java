package CharacterComponents.Race;

import CharacterComponents.Classes.Classes;
import CharacterComponents.Languages;
import CharacterComponents.Sizes;
import CharacterComponents.Vision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

import static CharacterComponents.Languages.*;

@Setter
@Getter
public class Human implements Race {
    /**
     * Racial Ability Score Modifiers.
     */
    private Map<String, Integer> abilityAdjustments;

    final private static String STR_ADJUSTMENT = "StrAdjustment";
    final private static String DEX_ADJUSTMENT = "DexAdjustment";
    final private static String CON_ADJUSTMENT = "ConAdjustment";
    final private static String INT_ADJUSTMENT = "IntAdjustment";
    final private static String WIS_ADJUSTMENT = "WisAdjustment";
    final static private String CHA_ADJUSTMENT = "ChaAdjustment";
    /**
     * Racial Favored JobClass.
     */
    private List<Classes> favoredClasses;
    /**
     * Racial Skill Points.
     */
    private int racialSkillPoints;
    /**
     * Base Movement Speed on Land.
     */
    private int baseLandSpeed;
    /**
     * Racial Language.
     */
    private List<Languages> automaticLanguage;
    /**
     * Number of bonus languages.
     */
    private List<Languages> bonusLanguages;
    /**
     * Vision types.
     */
    private List<Vision> vision;
    /**
     * Physical size.
     */
    private Sizes size;
    /**
     * Race Type.
     */
    private RaceChoice race;

    public Human() {
        vision = new ArrayList<>(Arrays.asList(Vision.NORMAL));
        favoredClasses = new ArrayList<>(Arrays.asList(Classes.ANY));
        automaticLanguage = new ArrayList<>(Arrays.asList(Languages.COMMON));
        bonusLanguages = new ArrayList<>(Arrays.asList(GIANT, COMMON,
                HALFLING, DWARVEN, ELVEN, GNOME, GOBLIN, ORC, GIANT, TERRAN, UNDERCOMMON));
        generateRacialAdjustmentMap();
        this.racialSkillPoints = 4;
        this.baseLandSpeed = 30;
        this.size = Sizes.MEDIUM;
        this.race = RaceChoice.HUMAN;
    }

    private void generateRacialAdjustmentMap() {
        abilityAdjustments = new HashMap<>();
        abilityAdjustments.put(STR_ADJUSTMENT, 0);
        abilityAdjustments.put(DEX_ADJUSTMENT, 0);
        abilityAdjustments.put(CON_ADJUSTMENT, 0);
        abilityAdjustments.put(INT_ADJUSTMENT, 0);
        abilityAdjustments.put(WIS_ADJUSTMENT, 0);
        abilityAdjustments.put(CHA_ADJUSTMENT, 0);
    }
}
