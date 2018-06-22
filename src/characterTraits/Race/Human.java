package characterTraits.Race;

import characterTraits.Classes.Classes;
import characterTraits.Languages;
import characterTraits.Sizes;
import characterTraits.Vision;

import java.util.ArrayList;

public class Human {
    /**
     * Racial Ability Score Modifiers.
     */
    private ArrayList<Integer> abilityAdjustments = new ArrayList<>();
    private int StrAdjustment;
    private int DexAdjustment;
    private int ConAdjustment;
    private int IntAdjustment;
    private int WisAdjustment;
    private int ChaAdjustment;
    /**
     * Racial Favored Class.
     */
    private ArrayList<Classes> favoredClasses = new ArrayList<>();
    /**
     * Racial Skill Points.
     */
    private int extraSkillPoints = 4;
    /**
     * Bonus Feats.
     */
    private int bonusFeats = 1;
    /**
     * Base Movement Speed on Land.
     */
    private int baseLandSpeed = 30;
    /**
     * Racial Language.
     */
    private Languages automaticLanguage = Languages.COMMON;
    /**
     * Number of bonus languages.
     */
    private int bonusLanguages = 1;
    /**
     * Vision types.
     */
    private ArrayList<Vision> vision = new ArrayList<>();
    /**
     * Physical size.
     */
    Sizes size = Sizes.MEDIUM;

    public Human() {
        StrAdjustment = 0;
        DexAdjustment = 0;
        ConAdjustment = 0;
        IntAdjustment = 0;
        WisAdjustment = 0;
        ChaAdjustment = 0;
        this.abilityAdjustments = abilityAdjustments;
        this.favoredClasses.add(Classes.ANY);
        this.extraSkillPoints = 4;
        this.bonusFeats = 1;
        this.baseLandSpeed = 30;
        this.automaticLanguage = Languages.COMMON;
        this.bonusLanguages = 1;
        vision.add(Vision.NORMAL);
        this.size = Sizes.MEDIUM;
    }


    public Sizes getSize() {
        return size;
    }

    public void setSize(Sizes size) {
        this.size = size;
    }

    public ArrayList<Integer> getAbilityAdjustments() {
        return abilityAdjustments;
    }

    public void setAbilityAdjustments(ArrayList<Integer> abilityAdjustments) {
        this.abilityAdjustments = abilityAdjustments;
    }

    public ArrayList<Classes> getFavoredClasses() {
        return favoredClasses;
    }

    public void setFavoredClasses(Classes favoredClass) {
        favoredClasses.add(favoredClass);
    }

    public int getBaseLandSpeed() {
        return baseLandSpeed;
    }

    public void setBaseLandSpeed(int baseLandSpeed) {
        this.baseLandSpeed = baseLandSpeed;
    }

    public Languages getAutomaticLanguage() {
        return automaticLanguage;
    }

    public void setAutomaticLanguage(Languages automaticLanguage) {
        this.automaticLanguage = automaticLanguage;
    }

    public ArrayList<Vision> getVision() {
        return vision;
    }

    public void addToVisionSet(Vision vision) {
        this.vision.add(vision);
    }

    public int getExtraSkillPoints() {
        return extraSkillPoints;
    }

    public int getBonusFeats() {
        return bonusFeats;
    }

    public int getBonusLanguages() {
        return bonusLanguages;
    }
}
