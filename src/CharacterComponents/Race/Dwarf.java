package CharacterComponents.Race;

import CharacterComponents.Classes.Classes;
import CharacterComponents.Languages;
import CharacterComponents.Sizes;
import CharacterComponents.Vision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Dwarf implements Race {

    /**
     * Racial Ability Score Modifiers.
     */
    private Map<String, Integer> abilityAdjustments = new HashMap<>();

    final private static String STR_ADJUSTMENT = "StrAdjustment";
    final private static String DEX_ADJUSTMENT = "DexAdjustment";
    final private static String CON_ADJUSTMENT = "ConAdjustment";
    final private static String INT_ADJUSTMENT = "IntAdjustment";
    final private static String WIS_ADJUSTMENT = "WisAdjustment";
    final static private String CHA_ADJUSTMENT = "ChaAdjustment";
    /**
     * Racial Favored JobClass.
     */
    private ArrayList<Classes> favoredClasses;
    /**
     * Racial Skill Points.
     */
    private int extraSkillPoints;
    /**
     * Bonus Feats.
     */
    private int bonusFeats;
    /**
     * Base Movement Speed on Land.
     */
    private int baseLandSpeed;
    /**
     * Racial Language.
     */
    private ArrayList<Languages> automaticLanguage;
    /**
     * Number of bonus languages.
     */
    private ArrayList<Languages> bonusLanguages;
    /**
     * Vision types.
     */
    private ArrayList<Vision> vision;
    /**
     * Physical size.
     */
    private Sizes size;

    public Dwarf() {
        vision = new ArrayList<>(Arrays.asList(Vision.NORMAL, Vision.DARK_VISION));
        automaticLanguage = new ArrayList<>(Arrays.asList(Languages.COMMON, Languages.DWARVEN));
        bonusLanguages = new ArrayList<>(Arrays.asList(Languages.GIANT, Languages.GNOME,
                Languages.GOBLIN, Languages.ORC, Languages.TERRAN, Languages.UNDERCOMMON));
        favoredClasses = new ArrayList<>(Arrays.asList(Classes.FIGHTER));
        abilityAdjustments.put(STR_ADJUSTMENT, 0);
        abilityAdjustments.put(DEX_ADJUSTMENT, 0);
        abilityAdjustments.put(CON_ADJUSTMENT, 2);
        abilityAdjustments.put(INT_ADJUSTMENT, 0);
        abilityAdjustments.put(WIS_ADJUSTMENT, 0);
        abilityAdjustments.put(CHA_ADJUSTMENT, -2);
        this.extraSkillPoints = 4;
        this.bonusFeats = 1;
        this.baseLandSpeed = 20;
        this.size = Sizes.MEDIUM;
    }

}
