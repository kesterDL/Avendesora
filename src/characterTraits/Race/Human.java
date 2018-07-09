package characterTraits.Race;

import characterTraits.Classes.Classes;
import characterTraits.Languages;
import characterTraits.Sizes;
import characterTraits.Vision;

import java.util.ArrayList;
import java.util.Arrays;

public class Human extends Race{
    /**
     * Racial Ability Score Modifiers.
     */
    private ArrayList<Integer> abilityAdjustments;
    private int StrAdjustment;
    private int DexAdjustment;
    private int ConAdjustment;
    private int IntAdjustment;
    private int WisAdjustment;
    private int ChaAdjustment;
    /**
     * Racial Favored JobClass.
     */
    private ArrayList<Classes> favoredClasses = new ArrayList<>();
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
    private Languages automaticLanguage;
    /**
     * Number of bonus languages.
     */
    private int bonusLanguages;
    /**
     * Vision types.
     */
    private ArrayList<Vision> vision = new ArrayList<>();
    /**
     * Physical size.
     */
    Sizes size;

    public Human() {
        StrAdjustment = 0;
        DexAdjustment = 0;
        ConAdjustment = 0;
        IntAdjustment = 0;
        WisAdjustment = 0;
        ChaAdjustment = 0;
        this.abilityAdjustments = new ArrayList<>(Arrays.asList(StrAdjustment, DexAdjustment, ConAdjustment, IntAdjustment, WisAdjustment, ChaAdjustment));
        this.favoredClasses.add(Classes.ANY);
        this.extraSkillPoints = 4;
        this.bonusFeats = 1;
        this.baseLandSpeed = 30;
        this.automaticLanguage = Languages.COMMON;
        this.bonusLanguages = 1;
        vision.add(Vision.NORMAL);
        this.size = Sizes.MEDIUM;
    }

    @Override
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
