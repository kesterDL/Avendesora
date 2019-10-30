package CharacterComponents;

import CharacterComponents.Creation.GenerateCharacterStats;
import Equipment.Armor.*;
import Equipment.Weapons.LongSword;
import Equipment.Weapons.Weapon;
import Equipment.Weapons.WeaponList;
import CharacterComponents.Classes.Classes;
import CharacterComponents.Classes.Cleric;
import CharacterComponents.Classes.Fighter;
import CharacterComponents.Classes.JobClass;
import CharacterComponents.Race.Race;
import CharacterComponents.Race.RaceChoice;

import java.util.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

@Getter
@Setter
@NoArgsConstructor
public class Character {
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

    public Character(RaceChoice raceChoice, Classes jobClass) {
        // Level 1
        setLevel(1);
        nakedWeight = 0;
        experiencePoints = 0;
        unallocatedSkillPoints = 0;
        // Roll Ability Stats
        GenerateCharacterStats statsCreator = new GenerateCharacterStats();
        statsCreator.generateRandomCharacterStats();
        abilityScores = statsCreator.getAbilityScores();
        abilityModifiers = statsCreator.getAbilityModifiers();
        // Set RaceChoice and JobClass and adjust stats accordingly
        setRace(raceChoice);
        setClass(jobClass);
        setSpellsPerDay(calculateSpellsPerDay());
        // General Character Info
        rollMaximumHitPoints();
        setGold(100);
        calculateGrapple();
        defaultArmor();
        defaultWeapon();
        setExperiencePoints(0);
    }

    public Character(CharacterBuilder builder) {
        this.race = builder.getRace();
        this.jobClass = builder.getJobClass();
        this.secondaryJobClass = builder.getSecondaryJobClass();
        this.abilityScores = builder.getAbilityScores();
        this.abilityModifiers = builder.getAbilityModifiers();
        this.characterVisionSpectrum = builder.getCharacterVisionSpectrum();
        this.equippedArmor = builder.getEquippedArmor();
        this.equippedShield = builder.getEquippedShield();
        this.equippedWeapon = builder.getEquippedWeapon();
        this.language = builder.getLanguage();
        this.maxHitPoints = builder.getMaxHitPoints();
        this.currentHitPoints = builder.getCurrentHitPoints();
        this.characterName = builder.getCharacterName();
        this.playerName = builder.getPlayerName();
        this.gender = builder.getGender();
        this.nakedWeight = builder.getNakedWeight();
        this.experiencePoints = builder.getExperiencePoints();
        this.unallocatedSkillPoints = builder.getUnallocatedSkillPoints();
        this.skills = builder.getSkills();
        this.spellsPerDay = builder.getSpellsPerDay();
        this.level = builder.getLevel();
        this.gold = builder.getGold();
    }

    private int calculateReflexSavingThrow(final int magicMod) {
        getJobClass().calculateReflexSave(abilityModifiers.get(abilityScores.get(BaseAbilities.DEXTERITY)));
        return (getJobClass().getReflexSave()
            + abilityModifiers.get(abilityScores.get(BaseAbilities.DEXTERITY))
            + magicMod);
    }

    private int calculateFortitudeSavingThrow(final int magicMod) {
        getJobClass().calculateFortitudeSave(getLevel());
        return getJobClass().getFortitudeSave()
            + abilityModifiers.get(abilityScores.get(BaseAbilities.CONSTITUTION)
            + magicMod);
    }

    private int calculateWillSavingThrow(final int magicMod) {
        getJobClass().calculateWillSave(getLevel());
        return getJobClass().getWillSave()
            + abilityModifiers.get(abilityScores.get(BaseAbilities.WISDOM)
            + magicMod);
    }

    public void defaultArmor() {
        Integer armorClass = 10 + abilityModifiers.get(abilityScores.get(BaseAbilities.DEXTERITY));
        if (race.getRace() == RaceChoice.GNOME || race.getRace() == RaceChoice.HALFLING){
            armorClass += 1;
        }
        Shield buckler = new ShieldBuckler();
        Armor leatherArmor = new LeatherArmor();
        setEquippedShield(ShieldTypes.BUCKLER);
        setEquippedArmor(leatherArmor);
        subtractGold(buckler.getCost());
        armorClass += buckler.getArmorBonus() + leatherArmor.getArmorBonus();
        setArmorClass(armorClass);
    }

    public void chooseArmorClass() {
        Integer armorClass = 10 + abilityModifiers.get(abilityScores.get(BaseAbilities.DEXTERITY));
        RaceChoice race = getRace().getSelectedRace();
        if (race == RaceChoice.GNOME || race == RaceChoice.HALFLING){
            armorClass += 1;
        }
        armorClass += selectLightArmor();
        armorClass += selectShield();
        setArmorClass(armorClass);
    }

    private Integer selectShield() {
        Scanner user_input = new Scanner(System.in);
        ArrayList<ShieldTypes> shieldList = new ArrayList<>(Arrays.asList(ShieldTypes.NONE,ShieldTypes.BUCKLER,ShieldTypes.LIGHT_WOODEN,
                ShieldTypes.LIGHT_STEEL, ShieldTypes.HEAVY_WOODEN, ShieldTypes.HEAVY_STEEL, ShieldTypes.TOWER));
        String selection;
        Integer intSelection = 0;
        Boolean validSelection = false;
        Integer bonus = 0;

        while (!validSelection) {
            System.out.println("Select the number for the shield you would like to carry. ");
            int item = 1;
            for (ShieldTypes type: shieldList) {
                System.out.println(item + ": " + type.toString());
                item++;
            }
            selection = user_input.next();
            intSelection = Integer.parseInt(selection);
            // Accept input and assign the stat
            if (intSelection < 1 || intSelection > 7) {
                System.out.println("Select a number from the list of available shields");
                System.out.println();
            } else {
                validSelection = true;
                switch (intSelection){
                    case 1:
                        this.equippedShield = ShieldTypes.NONE;
                        break;
                    case 2:
                        Shield buckler = new ShieldBuckler();
                        this.equippedShield = ShieldTypes.BUCKLER;
                        subtractGold(buckler.getCost());
                        bonus += buckler.getArmorBonus();
                        break;
                    case 3:
                        // TODO:
                        break;
                    case 4:
                        // TODO:
                        break;
                    default:
                        // TODO:
                }
            }
        }
        return bonus;
    }

    private Integer selectLightArmor() {
        Scanner user_input = new Scanner(System.in);
        ArrayList<ArmorList> armorListList = new ArrayList<>(Arrays.asList(EquippedArmor.PADDED, EquippedArmor.LEATHER,
                EquippedArmor.STUDDED_LEATHER, EquippedArmor.CHAIN_SHIRT));
        ArmorList armor = EquippedArmor.LEATHER;
        String selection;
        Integer intSelection = 0;
        Boolean validSelection = false;
        Integer armorBonus = 0;

        while (!validSelection) {
            System.out.println("Select the number for the armor you would like to wear. ");
            int item = 1;
            for (ArmorList type: armorListList) {
                System.out.println(item + ": " + type.toString());
                item++;
            }
            selection = user_input.next();
            intSelection = Integer.parseInt(selection);
            // Accept input and assign the stat
            if (intSelection < 1 || intSelection > 4) {
                System.out.println("Select a number from the list of available armor");
                System.out.println();
            } else {
                validSelection = true;
                switch (intSelection){
                    case 1:
                        Armor paddedArmor = new PaddedArmor();
                        if (ableToUseArmor(paddedArmor) ==  TRUE) {
                            System.out.println("Armor Selected Padded");
                            setEquippedArmor(paddedArmor);
                        } else {
                            validSelection = FALSE;
                        }
                        break;
                    case 2:
                        Armor leatherArmor = new LeatherArmor();
                        if (ableToUseArmor(leatherArmor) ==  TRUE) {
                            System.out.println("Armor Selected: Leather");
                            setEquippedArmor(leatherArmor);
                        } else {
                            validSelection = FALSE;
                        }
                        break;
                    case 3:
                        // TODO:
                        this.EquippedArmor = EquippedArmor.STUDDED_LEATHER;
                        break;
                    case 4:
                         // TODO:
                        this.EquippedArmor = EquippedArmor.CHAIN_SHIRT;
                        break;
                    default:
                        // TODO:
                        validSelection = true;
                        this.EquippedArmor = EquippedArmor.LEATHER;
                }

                setEquippedArmor(getEquippedArmor().getArmor());
                armorBonus += getEquippedArmor().getArmorBonus();
                subtractGold(getEquippedArmor().getCost());
            }
        }
        return armorBonus;

    }

    private ArmorCategory selectArmorClass() {
        Scanner user_input = new Scanner(System.in);
        ArmorCategory armorClass = null;
        String selection;
        Integer intSelection = 0;
        Boolean validSelection = false;

        while (!validSelection) {
            ArrayList<ArmorCategory> armorTypes = new ArrayList<>(Arrays.asList(ArmorCategory.LIGHT, ArmorCategory.MEDIUM, ArmorCategory.HEAVY));
            System.out.println("Select the number for the type armor you would like to wear. ");
            int item = 1;
            for (ArmorCategory type: armorTypes) {
                System.out.println(item + ": " + type.toString());
                item++;
            }
            selection = user_input.next();
            intSelection = Integer.parseInt(selection);
            // Accept input and assign the stat
            if (intSelection < 1 || intSelection > 3) {
                System.out.println("Select a number from the list of available armor types");
                System.out.println();
            } else {
                validSelection = true;
                switch (intSelection){
                    case 1:
                        armorClass = ArmorCategory.LIGHT;
                    case 2:
                        armorClass = ArmorCategory.MEDIUM;
                    case 3:
                        armorClass = ArmorCategory.HEAVY;
                    default:
                        armorClass = ArmorCategory.LIGHT;
                }
            }
        }

        return armorClass;
    }

    public int getInitiativeModifier(final int additionalMod) {
        if (abilityModifiers.get(abilityScores.get(BaseAbilities.DEXTERITY)) > 0) {
            return abilityModifiers.get(abilityScores.get(BaseAbilities.DEXTERITY))+ additionalMod;
        } else {
            return 0;
        }
    }

    public void addToMaxHitPoints(final int hitPoints) {
        this.maxHitPoints += hitPoints;
    }

    public void addToExperiencePoints(final int xp) {
        this.experiencePoints += xp;
    }

    public void addToUnallocatedSkillPoints(final int points) {
        this.unallocatedSkillPoints += points;
    }

    public void setClass(final Classes jobClass) {
        jobClass = JobClass(jobClass);
        switch(jobClass) {
            case FIGHTER:
                JobClass fighter = new Fighter(getIntelligenceModifier(), getLevel());
                setJobClass(fighter);
                adjustForClass(BaseAbilities.STRENGTH);
                break;
            case CLERIC:
                JobClass cleric = new Cleric(getIntelligenceModifier(), getLevel(), Deities.PELOR);
                setJobClass(cleric);
                adjustForClass(BaseAbilities.STRENGTH);
        }
    }

    private void adjustForClass(final BaseAbilities ability) {
        if(getJobClass() != null) {
            getJobClass().setNumberOfFeats(getJobClass().calculateNumberOfFeats(getIntelligenceModifier()));
            addToUnallocatedFeats(getJobClass().getNumberOfFeats());
            setBaseAttackBonus(calculateBaseAttackBonus(getLevel(),
                    ability, getRace().getSizeModifier()));
            addToUnallocatedSkillPoints(getJobClass().getSkillPoints());
            calculateReflexSavingThrow(0);
            calculateFortitudeSavingThrow(0);
            calculateWillSavingThrow(0);
        }
    }

    public Integer calculateBaseAttackBonus(final int level, final BaseAbilities ability, final int sizeModifier) {
        int skillModifier = 0;
        if(ability.equals(BaseAbilities.STRENGTH)) {
            skillModifier = abilityModifiers.get(abilityScores.get(BaseAbilities.STRENGTH));
        } else if (ability.equals(BaseAbilities.DEXTERITY)) {
            skillModifier = abilityModifiers.get(abilityScores.get(BaseAbilities.DEXTERITY));
        }
        return getJobClass().calculateBaseAttackBonus(level) + skillModifier + sizeModifier;
    }

    public void addToVisionSet(Vision vision) {
        this.characterVisionSpectrum.add(vision);
    }

    public void addToLanguages(final Languages language) {
        this.language.add(language);
    }

    private void setBaseAttackBonus(final int level) {
        getJobClass().setBaseAttackBonus(level);
        this.BaseAttackBonus =  getJobClass().getBaseAttackBonus();
    }

    public void calculateGrapple() {
        this.Grapple = getBaseAttackBonus() + getStrengthModifier() + getRace().getSizeModifier();
    }

    public void firstTimeRankSkill(final Skills skill, final double points) {

        if(points > getUnallocatedSkillPoints()) {
            System.out.println("Not Enough Skill Points");
        } else if(points % 0.5 == 0 && getUnallocatedSkillPoints() >= 0.5) {
            List<Skills> classSkills = getJobClass().getClassSkills();

            if (classSkills.contains(skill) && points <= 4.0) {
                skills.put(skill, points);
                unallocatedSkillPoints -= points;
            } else if(!classSkills.contains(skill) && points <= 4.0) {
                double nonClassrank = points / 2.0;
                skills.put(skill, nonClassrank);
                unallocatedSkillPoints -= points;
            }else {
                System.out.println("Max rank at level 1 is 4, or 2 for non class skills");
            }
        }

    }

    public Double getSkillRank(final Skills skill) {
        if(skills.containsKey(skill)){
            return skills.get(skill);
        } else {
            return 0.0;
        }
    }

    public void defaultWeapon() {
        LongSword longSword =  new LongSword();
        setEquippedWeapon(WeaponList.SWORD_LONG);
        setEquippedWeapon(longSword);
        subtractGold(longSword.getCost());
    }

    public void chooseWeapon() {
        Scanner user_input = new Scanner(System.in);
        String selection;
        Integer intSelection = 0;
        Boolean validSelection = false;

        while (!validSelection) {
            ArrayList<WeaponList> weaponChoices = new ArrayList<>(Arrays.asList(WeaponList.SWORD_LONG,WeaponList.BOW_LONG,
                    WeaponList.WARHAMMER));
            System.out.println("Select the number for the weapon you would like to carry. ");
            int item = 1;
            for (WeaponList type: weaponChoices) {
                System.out.println(item + ": " + type.toString());
                item++;
            }
            selection = user_input.next();
            intSelection = Integer.parseInt(selection);

            // Accept input and assign the stat
            if (intSelection < 1 || intSelection > 3) {
                System.out.println("Select a number from the list of available weapons");
                System.out.println();
            } else {
                validSelection = true;
                switch (intSelection){
                    case 1:
                        LongSword longSword =  new LongSword();
                        if(ableToUseWeapon(longSword) == TRUE) {
                            setEquippedWeapon(Weapon.SWORD_LONG);
                            setEquippedWeapon(longSword);
                            subtractGold(longSword.getCost());
                        }
                        break;
                    case 2:
                        // TODO: Complete this list
                        //weaponChoice = ArmorTypes.MEDIUM;
                    case 3:
                        //weaponChoice = ArmorTypes.HEAVY;
                }
            }
        }
    }

    public void addToGold(Integer gold) {
        if(gold > 0) {
            this.gold += gold;
        } else {
            // TODO: exception handler
        }
    }

    public void subtractGold(final Integer gold) {
        if(this.gold > gold && gold > 0) {
            this.gold -= gold;
        } else {
            // TODO: exception handler
        }
    }

    public Map<Integer, Integer> calculateSpellsPerDay() {
        getJobClass().setSpellsPerDay(getJobClass().calculateSpellsPerDay(getLevel()));
        Map<Integer, Integer> spells = getJobClass().getSpellsPerDay();
        getJobClass().setBonusSpells(getJobClass().calculateBonusSpells(abilityModifiers.get(abilityScores.get(BaseAbilities.WISDOM))));
        Map<Integer, Integer> bonusSpells = getJobClass().getBonusSpells();

        for (int i = 0; i < spells.keySet().size() - 1; i++) {
            spells.put(i, spells.get(i) + bonusSpells.get(i));
        }

        return spells;
    }
}
