package CharacterComponents;

import CharacterComponents.Classes.JobClass;
import CharacterComponents.Race.Race;
import CharacterComponents.Race.RaceChoice;
import Equipment.Armor.Armor;
import Equipment.Weapons.Weapon;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterBuilder {
    /**
     * Object for the selected race.
     */
    private Race race;
    /**
     * Job class object.
     */
    private JobClass jobClass;
    /**
     * Secondary job class.
     */
    private JobClass secondaryJobClass;
    /**
     * Map of abilityScores and their score.
     */
    private Map<BaseAbilities, Integer> abilityScores;
    /**
     * Map of scores and their modifiers.
     */
    private Map<Integer, Integer> abilityModifiers;
    /**
     * Vision Spectrum.
     */
    private ArrayList<Vision> characterVisionSpectrum;
    /**
     * Equipped armor object.
     */
    private Armor equippedArmor;
    /**
     * Current shield.
     */
    private Armor equippedShield;
    /**
     * Object for equipped current weapon.
     */
    private Weapon equippedWeapon;
    /**
     * Languages a character speaks.
     */
    private List<Languages> language;
    /**
     * Max Hit points.
     */
    private int maxHitPoints;
    /**
     * Current Hit points.
     */
    private int currentHitPoints;
    /**
     * Character's Name.
     */
    private String characterName;
    /**
     * Player's Name.
     */
    private String playerName;
    /**
     * Character's gender.
     */
    private Gender gender;
    /**
     * Naked weight.
     */
    private int nakedWeight;
    /**
     * Current Experience Points.
     */
    private int experiencePoints;
    /**
     * Unallocated Skill Points.
     */
    private int unallocatedSkillPoints;
    /**
     * List of character's skill and rank;
     */
    private Map<Skills, Double> skills;
    /**
     * Spells for each spell level per day.
     */
    private Map<Integer, Integer> spellsPerDay;
    /**
     * Current Level.
     */
    private int level;
    /**
     * Amount of money character owns (in gold).
     */
    private int gold;

    public static CharacterBuilder newInstance() {
        return new CharacterBuilder();
    }

    private CharacterBuilder(){}

    public void addToMaxHitPoints(final int hitPoints) {
        this.maxHitPoints += hitPoints;
    }

    private void rollMaxHitPoints() {
        if(this.race == null) {
            throw new NullPointerException("No race selected");
        }
        switch(getJobClass().getHitDice()) {
            case d4:
                if(getLevel() == 1) {
                    setMaxHitPoints(4 + abilityModifiers.get(abilityScores.get(BaseAbilities.CONSTITUTION)));
                } else {
                    addToMaxHitPoints(Dice.rollAD4() + abilityModifiers.get(abilityScores.get(BaseAbilities.CONSTITUTION)));
                }
                break;
            case d6:
                if(getLevel() == 1) {
                    setMaxHitPoints(6 + abilityModifiers.get(abilityScores.get(BaseAbilities.CONSTITUTION)));
                } else {
                    addToMaxHitPoints(Dice.rollAD6() + abilityModifiers.get(abilityScores.get(BaseAbilities.CONSTITUTION)));
                }
                break;
            case d8:
                if(getLevel() == 1) {
                    setMaxHitPoints(8 + abilityModifiers.get(abilityScores.get(BaseAbilities.CONSTITUTION)));
                } else {
                    addToMaxHitPoints(Dice.rollAD8() + abilityModifiers.get(abilityScores.get(BaseAbilities.CONSTITUTION)));
                }
                break;
            case d10:
                if (getLevel() == 1) {
                    setMaxHitPoints(10 + abilityModifiers.get(abilityScores.get(BaseAbilities.CONSTITUTION)));
                } else {
                    addToMaxHitPoints(Dice.rollAD10() + abilityModifiers.get(abilityScores.get(BaseAbilities.CONSTITUTION)));
                }
                break;
            case d12:
                if (getLevel() == 1) {
                    setMaxHitPoints(12 + abilityModifiers.get(abilityScores.get(BaseAbilities.CONSTITUTION)));
                } else {
                    addToMaxHitPoints(Dice.rollAD12() + abilityModifiers.get(abilityScores.get(BaseAbilities.CONSTITUTION)));
                }
                break;
        }
    }

    public void setRace(final RaceChoice raceChoice) {
        this.race = Race.raceFactory(raceChoice);
    }

    private void adjustStatsForRace() {
        abilityScores.put(BaseAbilities.STRENGTH, abilityScores.get(BaseAbilities.STRENGTH) + race.getAbilityAdjustments().get(BaseAbilities.STRENGTH));
        abilityScores.put(BaseAbilities.DEXTERITY, abilityScores.get(BaseAbilities.DEXTERITY) + race.getAbilityAdjustments().get(BaseAbilities.DEXTERITY));
        abilityScores.put(BaseAbilities.CONSTITUTION, abilityScores.get(BaseAbilities.CONSTITUTION) + race.getAbilityAdjustments().get(BaseAbilities.CONSTITUTION));
        abilityScores.put(BaseAbilities.INTELLIGENCE, abilityScores.get(BaseAbilities.INTELLIGENCE) + race.getAbilityAdjustments().get(BaseAbilities.INTELLIGENCE));
        abilityScores.put(BaseAbilities.WISDOM, abilityScores.get(BaseAbilities.WISDOM) + race.getAbilityAdjustments().get(BaseAbilities.WISDOM));
        abilityScores.put(BaseAbilities.CHARISMA, abilityScores.get(BaseAbilities.CHARISMA) + race.getAbilityAdjustments().get(BaseAbilities.CHARISMA));
    }

    public Character build() {
        adjustStatsForRace();
        rollMaxHitPoints();
        return new Character(this);
    }
}
