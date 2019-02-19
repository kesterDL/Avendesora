package characterTraits.Race;

import characterTraits.Classes.Classes;
import characterTraits.Languages;
import characterTraits.Sizes;
import characterTraits.Vision;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Race {
    /**
     * Racial Ability Score Modifiers.
     */
    private Map<String, Integer> abilityAdjustments = new HashMap<>();
    final private String StrAdjustment = "StrAdjustment";
    final private String DexAdjustment = "DexAdjustment";
    final private String ConAdjustment = "ConAdjustment";
    final private String IntAdjustment = "IntAdjustment";
    final private String WisAdjustment = "WisAdjustment";
    final private String ChaAdjustment = "ChaAdjustment";
    /**
     * Selected race.
     */
    private RaceChoice selectedRace;
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
    private ArrayList<Languages> automaticLanguage = new ArrayList<>();
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
    Sizes size;
    /**
     * Size Modifier
     * @return modifier
     */
    Integer sizeModifier;

    public Map<String, Integer> getRacialAbilityAdjustments() {
        return abilityAdjustments;
    }

    public void setRacialAbilityAdjustments(final Map<String, Integer> abilityAdjustments) {
        this.abilityAdjustments = abilityAdjustments;
    }

    public int getRacialStrAdjustment() {
        return abilityAdjustments.get(StrAdjustment);
    }

    public void setRacialStrAdjustment(final int strAdjustment) {
        abilityAdjustments.put(StrAdjustment,strAdjustment);
    }

    public int getRacialDexAdjustment() {
        return abilityAdjustments.get(DexAdjustment);
    }

    public void setRacialDexAdjustment(final int dexAdjustment) {
        abilityAdjustments.put(DexAdjustment, dexAdjustment);
    }

    public int getRacialConAdjustment() {
        return abilityAdjustments.get(ConAdjustment);
    }

    public void setRacialConAdjustment(final int conAdjustment) {
        abilityAdjustments.put(ConAdjustment, conAdjustment);
    }

    public int getRacialIntAdjustment() {
        return abilityAdjustments.get(IntAdjustment);
    }

    public void setRacialIntAdjustment(final int intAdjustment) {
        abilityAdjustments.put(IntAdjustment, intAdjustment);
    }

    public int getRacialWisAdjustment() {
        return abilityAdjustments.get(WisAdjustment);
    }

    public void setRacialWisAdjustment(final int wisAdjustment) {
        abilityAdjustments.put(WisAdjustment, wisAdjustment);
    }

    public int getRacialChaAdjustment() {
        return abilityAdjustments.get(ChaAdjustment);
    }

    public void setRacialChaAdjustment(final int chaAdjustment) {
        abilityAdjustments.put(ChaAdjustment, chaAdjustment);
    }

    public ArrayList<Classes> getRaceFavoredClasses() {
        return favoredClasses;
    }

    public void setRaceFavoredClasses(final ArrayList<Classes> favoredClasses) {
        this.favoredClasses = favoredClasses;
    }

    public int getRacialExtraSkillPoints() {
        return extraSkillPoints;
    }

    public void setRacialExtraSkillPoints(final int extraSkillPoints) {
        this.extraSkillPoints = extraSkillPoints;
    }

    public int getRacialBonusFeats() {
        return bonusFeats;
    }

    public void setRacialBonusFeats(final int bonusFeats) {
        this.bonusFeats = bonusFeats;
    }

    public int getRacialBaseLandSpeed() {
        return baseLandSpeed;
    }

    public void setRacialBaseLandSpeed(final int baseLandSpeed) {
        this.baseLandSpeed = baseLandSpeed;
    }

    public ArrayList<Languages> getAutomaticRacialLanguage() {
        return automaticLanguage;
    }

    public void setAutomaticRacialLanguage(final ArrayList<Languages> automaticLanguage) {
        this.automaticLanguage = automaticLanguage;
    }

    public ArrayList<Languages> getRacialBonusLanguages() {
        return bonusLanguages;
    }

    public void setRacialBonusLanguages(final ArrayList<Languages> bonusLanguages) {
        this.bonusLanguages = bonusLanguages;
    }

    public ArrayList<Vision> getRacialVision() {
        return vision;
    }

    public void setRacialVision(final ArrayList<Vision> vision) {
        this.vision = vision;
    }

    public Sizes getRaceSize() {
        return size;
    }

    public void setRaceSize(final Sizes size) {
        this.size = size;
        setSizeModifier(size);
    }

    private void setSizeModifier(final Sizes size) {
        switch(size) {
            case FINE:
                this.sizeModifier = 8;
                break;
            case DIMINUTIVE:
                this.sizeModifier = 4;
                break;
            case TINY:
                this.sizeModifier = 2;
                break;
            case SMALL:
                this.sizeModifier = 1;
                break;
            case MEDIUM:
                this.sizeModifier = 0;
                break;
            case LARGE:
                this.sizeModifier = -1;
                break;
            case HUGE:
                this.sizeModifier = -2;
                break;
            case GARGANTUAN:
                this.sizeModifier = -4;
                break;
            case COLOSSAL:
                this.sizeModifier = -8;
                break;
        }
    }

    public Integer getSizeModifier() {
        return this.sizeModifier;
    }

    public void setSelectedRace(final RaceChoice race) {
        this.selectedRace = race;
    }

    public RaceChoice getSelectedRace() {
        return this.selectedRace;
    }
}
