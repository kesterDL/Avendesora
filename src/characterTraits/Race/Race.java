package characterTraits.Race;

import characterTraits.Classes.Classes;
import characterTraits.Languages;
import characterTraits.Sizes;
import characterTraits.Vision;

import java.util.ArrayList;

public class Race {
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
     * Racial Favored Class.
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
    private Languages automaticLanguage;
    /**
     * Number of bonus languages.
     */
    private int bonusLanguages;
    /**
     * Vision types.
     */
    private ArrayList<Vision> vision;
    /**
     * Physical size.
     */
    Sizes size;

    public ArrayList<Integer> getAbilityAdjustments() {
        return abilityAdjustments;
    }

    public void setAbilityAdjustments(ArrayList<Integer> abilityAdjustments) {
        this.abilityAdjustments = abilityAdjustments;
    }

    public int getStrAdjustment() {
        return StrAdjustment;
    }

    public void setStrAdjustment(int strAdjustment) {
        StrAdjustment = strAdjustment;
    }

    public int getDexAdjustment() {
        return DexAdjustment;
    }

    public void setDexAdjustment(int dexAdjustment) {
        DexAdjustment = dexAdjustment;
    }

    public int getConAdjustment() {
        return ConAdjustment;
    }

    public void setConAdjustment(int conAdjustment) {
        ConAdjustment = conAdjustment;
    }

    public int getIntAdjustment() {
        return IntAdjustment;
    }

    public void setIntAdjustment(int intAdjustment) {
        IntAdjustment = intAdjustment;
    }

    public int getWisAdjustment() {
        return WisAdjustment;
    }

    public void setWisAdjustment(int wisAdjustment) {
        WisAdjustment = wisAdjustment;
    }

    public int getChaAdjustment() {
        return ChaAdjustment;
    }

    public void setChaAdjustment(int chaAdjustment) {
        ChaAdjustment = chaAdjustment;
    }

    public ArrayList<Classes> getFavoredClasses() {
        return favoredClasses;
    }

    public void setFavoredClasses(ArrayList<Classes> favoredClasses) {
        this.favoredClasses = favoredClasses;
    }

    public int getExtraSkillPoints() {
        return extraSkillPoints;
    }

    public void setExtraSkillPoints(int extraSkillPoints) {
        this.extraSkillPoints = extraSkillPoints;
    }

    public int getBonusFeats() {
        return bonusFeats;
    }

    public void setBonusFeats(int bonusFeats) {
        this.bonusFeats = bonusFeats;
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

    public int getBonusLanguages() {
        return bonusLanguages;
    }

    public void setBonusLanguages(int bonusLanguages) {
        this.bonusLanguages = bonusLanguages;
    }

    public ArrayList<Vision> getVision() {
        return vision;
    }

    public void setVision(ArrayList<Vision> vision) {
        this.vision = vision;
    }

    public Sizes getSize() {
        return size;
    }

    public void setSize(Sizes size) {
        this.size = size;
    }
}
