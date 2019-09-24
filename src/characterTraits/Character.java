package characterTraits;

import Equipment.Armor.*;
import Equipment.Weapons.LongSword;
import Equipment.Weapons.Weapon;
import Equipment.Weapons.WeaponList;
import characterTraits.Classes.Classes;
import characterTraits.Classes.Cleric;
import characterTraits.Classes.Fighter;
import characterTraits.Classes.JobClass;
import characterTraits.Feats.Feats;
import characterTraits.Race.Dwarf;
import characterTraits.Race.Human;
import characterTraits.Race.Race;
import characterTraits.Race.RaceChoice;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

@Getter
@Setter
@NoArgsConstructor
public class Character {
    /**
     * Map of abilityScores and their score.
     */
    private Map<BaseAbilities, Integer> abilityScores;
    /**
     * Map of scores and their modifiers.
     */
    private Map<Integer, Integer> abilityModifiers;
    /**
     * Object for the selected race.
     */
    private Race raceObject;
    /**
     * Vision Spectrum.
     */
    private ArrayList<Vision> characterVision;
    /**
     * Dexterity Saving Throw.
     */
    private int ReflexSavingThrow;
    /**
     * Constitution Saving Throw.
     */
    private int FortitudeSavingThrow;
    /**
     * Wisdom Saving Throw.
     */
    private int WillSavingThrow;

    /**
     * EquippedArmor rating.
     */
    private Integer ArmorClass;
    /**
     * Current armor.
     */
    private ArmorList EquippedArmor;
    /**
     * Equipped armor object.
     */
    private Armor EquippedArmorObject;
    /**
     * Current shield.
     */
    private ShieldTypes Shield;
    /**
     * Current weapon.
     */
    private WeaponList EquippedWeapon;
    /**
     * Object for equipped current weapon.
     */
    private Weapon EquippedWeaponObject;
    /**
     * Initiative.
     */
    private int InitiativeModifier;
    /**
     * Base attack bonus.
     */
    private int BaseAttackBonus;
    /**
     * Grapple modifier.
     */
    private int Grapple;
    /**
     * Base Movement Speed.
     */
    private int Speed;
    /**
     * Languages a character speaks.
     */
    private ArrayList<Languages> language;
    /**
     * Total number of characterFeats.
     */
    private int numberOfUnallocatedFeats;
    /**
     * List of all the character's characterFeats.
     */
    private ArrayList<Feats> characterFeats;
    /**
     * Max Hit points.
     */
    private int MaximumHitPoints;
    /**
     * Current Hit points.
     */
    private int CurrentHitPoints;
    /**
     * Job class object.
     */
    private JobClass jobObject;
    /**
     * Secondary job class.
     */
    private JobClass secondaryJob;
    /**
     * Character's Name.
     */
    private String CharacterName;
    /**
     * Player's Name.
     */
    private String PlayerName;
    /**
     * Character's gender.
     */
    private Gender gender;
    /**
     * Naked weight.
     */
    private int nakedWeight = 0;
    /**
     * Current Experience Points.
     */
    private int ExperiencePoints = 0;
    /**
     * Unallocated Skill Points.
     */
    private int unallocatedSkillPoints = 0;
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
    private int Level = 0;
    /**
     * Amount of money character owns (in gold).
     */
    private int Gold = 0;

    public Character(RaceChoice raceChoice, Classes jobClass) {
        initializeAbilityScoreMap();
        initializeAbilityModifierMap();
        this.characterVision = new ArrayList<>();
        // Level 1
        setLevel(1);
        // Roll Ability Stats
        defaultCharacterStats();
        // Set RaceChoice and JobClass and adjust stats accordingly
        setRaceObject(raceChoice);
        setClass(jobClass);
        setSpellsPerDay(calculateSpellsPerDay());
        // General Character Info
        rollMaximumHitPoints();
        setGold(100);
        calculateGrapple();
        defaultArmor();
        defaultWeapon();
        setExperiencePoints(0);
        addToFeatSet(Feats.DODGE);
        addToFeatSet(Feats.IMPROVED_INITIATIVE);
    }

    private int sumOfRollsMinusMin(ArrayList<Integer> list) {
        int min = list.get(0);
        int minIndex = 0;
        int sum = 0;
        for(int i = 0; i < list.size() - 1; i++) {
            if (list.get(i+1) < min) {
                min = list.get(i+1);
                minIndex = i;
            }
        }
        list.remove(minIndex);
        for(Integer num: list) {
            sum += num;
        }
        return sum;
    }

    public Integer rollAnAbilityStat() {
        ArrayList<Integer> rolls = new ArrayList<>();
        for(int j = 0; j < 4; j++){
            rolls.add(Dice.rollAD6());
        }
        return sumOfRollsMinusMin(rolls);
    }

    private Map<BaseAbilities, Integer> initializeAbilityScoreMap() {
        abilityScores = new HashMap<>();
        Map<BaseAbilities, Integer> scores = new HashMap<>();
        scores.put(BaseAbilities.STRENGTH, null);
        scores.put(BaseAbilities.DEXTERITY, null);
        scores.put(BaseAbilities.CONSTITUTION, null);
        scores.put(BaseAbilities.INTELLIGENCE, null);
        scores.put(BaseAbilities.WISDOM, null);
        scores.put(BaseAbilities.CHARISMA, null);
        abilityScores.putAll(scores);
        return scores;
    }

    private Map<Integer, Integer> initializeAbilityModifierMap() {
        abilityModifiers = new HashMap<>();
        Map<Integer, Integer> modifiers = new HashMap<>();

        for (int i = 0; i < 25; i++) {
            modifiers.put(i, calculateModifier(i));
        }
        abilityModifiers.putAll(modifiers);
        return modifiers;
    }

    private ArrayList<Integer> rollStatsForCreation() {
        ArrayList<Integer> abilityRolls = new ArrayList<>();
        // Roll the all the scores and save them in a list
        for(int i = 0; i < 6; i++){
            abilityRolls.add(rollAnAbilityStat());
        }

        return abilityRolls;
    }

    private void printOutRollsForCreation(ArrayList<Integer> abilityRolls) {
        // Print all the scores to the user
        for(int i = 0; i < abilityRolls.size(); i++) {
            if ( i == abilityRolls.size()-1){
                System.out.print(abilityRolls.get(i));
            } else {
                System.out.print(abilityRolls.get(i) + ", ");
            }
        }
        System.out.println();
    }

    public void printOutCharacterAbilityStats() {
        Iterator abilities = getAbilityScores().entrySet().iterator();
        while (abilities.hasNext()) {
            Map.Entry keyPair = (Map.Entry)abilities.next();
            System.out.println(keyPair.getKey() + ": " + keyPair.getValue());
        }
    }

    public void selectAbilityStats() {
        // Roll the all the scores and save them in a list
        ArrayList<Integer> abilityRolls = rollStatsForCreation();
        // Ask user to choose each stat from the list
        for (BaseAbilities ability: abilityScores.keySet()) {
            printOutRollsForCreation(abilityRolls);
            userselectAbility(ability, abilityRolls);
        }
        printOutCharacterAbilityStats();
    }

    public void putAbilityStat(final BaseAbilities ability, final Integer abilityStat) {
        abilityScores.put(ability, abilityStat);
    }

    public void defaultCharacterStats() {
        initializeAbilityScoreMap();
        initializeAbilityModifierMap();
        ArrayList<Integer> abilityRolls = rollStatsForCreation();
        for (BaseAbilities ability: abilityScores.keySet()) {
            putAbilityStat(ability, abilityRolls.get(0));
            abilityRolls.remove(0);
        }
    }

    private void userselectAbility(final BaseAbilities ability, final ArrayList<Integer> abilityRolls) {
        Scanner user_input = new Scanner(System.in);
        String selection;
        Integer intSelection = 0;
        Boolean validSelection = false;

        while(!validSelection) {
            System.out.print("Select an ability score for " + ability.toString() + ": ");
            selection = user_input.next();
            intSelection = Integer.parseInt(selection);
            // Accept input and assign the stat
            if(!abilityRolls.contains(intSelection)) {
                System.out.println("Select a score from the list of available stats");
                printOutRollsForCreation(abilityRolls);
            } else {
                // Remove ability from list
                validSelection = true;
                switch(ability){
                    case STRENGTH:
                        setStrength(intSelection);
                        break;
                    case DEXTERITY:
                        setDexterity(intSelection);
                        break;
                    case CONSTITUTION:
                        setConstitution(intSelection);
                        break;
                    case INTELLIGENCE:
                        setIntelligence(intSelection);
                        break;
                    case WISDOM:
                        setWisdom(intSelection);
                        break;
                    case CHARISMA:
                        setCharisma(intSelection);
                        break;
                }
                abilityRolls.remove(intSelection);
                System.out.println("Character's " + ability.toString() + " is: " + selection);
            }
        }
    }

    public Integer getStrength() {
        return abilityScores.get(BaseAbilities.STRENGTH);
    }

    public void setStrength(final int strength) {
        abilityScores.put(BaseAbilities.STRENGTH, strength);
    }

    public Integer getDexterity() {
        return abilityScores.get(BaseAbilities.DEXTERITY);
    }

    public void setDexterity(final int dexterity) {
        abilityScores.put(BaseAbilities.DEXTERITY, dexterity);
    }

    public Integer getConstitution() {
        return abilityScores.get(BaseAbilities.CONSTITUTION);
    }

    public void setConstitution(final int constitution) {
        abilityScores.put(BaseAbilities.CONSTITUTION, constitution);
    }

    public Integer getIntelligence() {
        return abilityScores.get(BaseAbilities.INTELLIGENCE);
    }

    public void setIntelligence(final int intelligence) {
        abilityScores.put(BaseAbilities.INTELLIGENCE, intelligence);
    }

    public Integer getWisdom() {
        return abilityScores.get(BaseAbilities.WISDOM);
    }

    public void setWisdom(final int wisdom) {
        abilityScores.put(BaseAbilities.WISDOM, wisdom);
    }

    public Integer getCharisma() {
        return abilityScores.get(BaseAbilities.CHARISMA);
    }

    public void setCharisma(final int charisma) {
        abilityScores.put(BaseAbilities.CHARISMA, charisma);
    }

    public Integer getStrengthModifier() {
        return abilityModifiers.get(abilityScores.get(BaseAbilities.STRENGTH));
    }

    public Integer getDexterityModifier() {
        return abilityModifiers.get(abilityScores.get(BaseAbilities.DEXTERITY));
    }

    public Integer getConstitutionModifier() {
        return abilityModifiers.get(abilityScores.get(BaseAbilities.CONSTITUTION));
    }

    public int getIntelligenceModifier() {
        return abilityModifiers.get(abilityScores.get(BaseAbilities.INTELLIGENCE));
    }

    public int getWisdomModifier() {
        return abilityModifiers.get(abilityScores.get(BaseAbilities.WISDOM));
    }

    public int getCharismaModifier() {
        return abilityModifiers.get(abilityScores.get(BaseAbilities.CHARISMA));
    }

    public int getReflexSavingThrow() {
        return ReflexSavingThrow;
    }

    private void calculateReflexSavingThrow(final int magicMod) {
        getJobObject().calculateReflexSave(getDexterityModifier());
        setReflexSavingThrow(getJobObject().getReflexSave() + getDexterityModifier() + magicMod);
    }

    public int getFortitudeSavingThrow() {
        return FortitudeSavingThrow;
    }

    private void calculateFortitudeSavingThrow(final int magicMod) {
        getJobObject().calculateFortitudeSave(getLevel());
        setFortitudeSavingThrow(getJobObject().getFortitudeSave() + getConstitutionModifier() + magicMod);
    }

    public int getWillSavingThrow() {
        return WillSavingThrow;
    }

    private void calculateWillSavingThrow(final int magicMod) {
        getJobObject().calculateWillSave(getLevel());
        setWillSavingThrow(getJobObject().getWillSave() + getWisdomModifier() + magicMod);

    }

    public void setArmorClass(Integer armorClass) {
        this.ArmorClass = armorClass;
    }

    public int getArmorClass() {
        return ArmorClass;
    }

    public void defaultArmor() {
        Integer armorClass = 10 + getDexterityModifier();
        RaceChoice race = getRaceObject().getSelectedRace();
        if (race == RaceChoice.GNOME || race == RaceChoice.HALFLING){
            armorClass += 1;
        }
        Shield buckler = new ShieldBuckler();
        Armor leatherArmor = new LeatherArmor();
        setShield(ShieldTypes.BUCKLER);
        setEquippedArmorObject(leatherArmor);
        subtractGold(buckler.getCost());
        armorClass += buckler.getArmorBonus() + leatherArmor.getArmorBonus();
        setArmorClass(armorClass);
    }

    public void chooseArmorClass() {
        Integer armorClass = 10 + getDexterityModifier();
        RaceChoice race = getRaceObject().getSelectedRace();
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
                        this.Shield= ShieldTypes.NONE;
                        break;
                    case 2:
                        Shield buckler = new ShieldBuckler();
                        this.Shield = ShieldTypes.BUCKLER;
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
                            setEquippedArmorObject(paddedArmor);
                        } else {
                            validSelection = FALSE;
                        }
                        break;
                    case 2:
                        Armor leatherArmor = new LeatherArmor();
                        if (ableToUseArmor(leatherArmor) ==  TRUE) {
                            System.out.println("Armor Selected: Leather");
                            setEquippedArmorObject(leatherArmor);
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

                setEquippedArmor(getEquippedArmorObject().getArmor());
                armorBonus += getEquippedArmorObject().getArmorBonus();
                subtractGold(getEquippedArmorObject().getCost());
            }
        }
        return armorBonus;

    }

    private ArmorTypes selectArmorClass() {
        Scanner user_input = new Scanner(System.in);
        ArmorTypes armorClass = null;
        String selection;
        Integer intSelection = 0;
        Boolean validSelection = false;

        while (!validSelection) {
            ArrayList<ArmorTypes> armorTypes = new ArrayList<>(Arrays.asList(ArmorTypes.LIGHT, ArmorTypes.MEDIUM, ArmorTypes.HEAVY));
            System.out.println("Select the number for the type armor you would like to wear. ");
            int item = 1;
            for (ArmorTypes type: armorTypes) {
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
                        armorClass = ArmorTypes.LIGHT;
                    case 2:
                        armorClass = ArmorTypes.MEDIUM;
                    case 3:
                        armorClass = ArmorTypes.HEAVY;
                    default:
                        armorClass = ArmorTypes.LIGHT;
                }
            }
        }

        return armorClass;
    }

    public int getInitiative() {
        return InitiativeModifier;
    }

    public void setInitiativeModifier(final int additionalMod) {
        if (getDexterityModifier() > 0) {
            InitiativeModifier = getDexterityModifier() + additionalMod;
        } else {
            InitiativeModifier = 0;
        }
    }

    public int getSpeed() {
        return Speed;
    }

    public void setSpeed(final int speed) {
        this.Speed = speed;
    }

    public int getMaximumHitPoints() {
        return MaximumHitPoints;
    }

    public void rollMaximumHitPoints() {

        switch(getJobObject().getHitDice()) {
            case d4:
                if(getLevel() == 1) {
                    setMaximumHitPoints(4 + getConstitutionModifier());
                } else {
                    addToMaxHitPoints(Dice.rollAD4() + getConstitutionModifier());
                }
                break;
            case d6:
                if(getLevel() == 1) {
                    setMaximumHitPoints(6 + getConstitutionModifier());
                } else {
                    addToMaxHitPoints(Dice.rollAD6() + getConstitutionModifier());
                }
                break;
            case d8:
                if(getLevel() == 1) {
                    setMaximumHitPoints(8 + getConstitutionModifier());
                } else {
                    addToMaxHitPoints(Dice.rollAD8() + getConstitutionModifier());
                }
                break;
            case d10:
                if (getLevel() == 1) {
                    setMaximumHitPoints(10 + getConstitutionModifier());
                } else {
                    addToMaxHitPoints(Dice.rollAD10() + getConstitutionModifier());
                }
                break;
            case d12:
                if (getLevel() == 1) {
                    setMaximumHitPoints(12 + getConstitutionModifier());
                } else {
                    addToMaxHitPoints(Dice.rollAD12() + getConstitutionModifier());
                }
                break;
        }
    }

    public int getCurrentHitPoints() {
        return CurrentHitPoints;
    }

    public void addToMaxHitPoints(int hitpoints) {
        setMaximumHitPoints(getMaximumHitPoints() + hitpoints);
    }
    public void setCurrentHitPoints(int hitPoints) {
        this.CurrentHitPoints = hitPoints;
    }

    public String getCharacterName() {
        return CharacterName;
    }

    public void setCharacterName(String characterName) {
        this.CharacterName = characterName;
    }

    public String getPlayerName() {
        return PlayerName;
    }

    public void setPlayerName(String playerName) {
        this.PlayerName = playerName;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getCurrentExperiencePoints() {
        return ExperiencePoints;
    }

    private void setExperiencePoints(final int experiencePoints) {
        this.ExperiencePoints = experiencePoints;
    }

    public void addToExperiencePoints(final int points) {
        this.ExperiencePoints += points;
    }

    public int getLevel() {
        return Level;
    }

    private void setLevel(final int level) {
        Level = level;
    }

    private Integer calculateModifier(Integer abilityScore) {
        int modifier;
        if(abilityScore%2 != 0) {
            modifier = -6;
        } else {
            modifier = -5;
        }
        while(abilityScore > 0){
            abilityScore--;
            if(abilityScore%2 == 0) {
                modifier++;
            }
        }
        return modifier;
    }

    public void addToUnallocatedSkillPoints(int points) {
        this.unallocatedSkillPoints += points;
    }

    public Race getRaceObject() {
        return this.raceObject;
    }

    public void setRaceObject(final RaceChoice raceChoice) {
        switch (raceChoice) {
            case HUMAN:
                this.raceObject = new Human();
                break;
            case DWARF:
                this.raceObject = new Dwarf();
                break;
            case ELVEN:
                break;
            case GNOME:
                break;
            case HALF_ORC:
                break;
            case HALFLING:
                break;
            case HALF_ELVEN:
                break;
        }
        raceAdjustments(this.raceObject);
    }

    private void adjustStatsForRace(final Race race) {
        setStrength(getStrength() + race.getRacialStrAdjustment());
        setDexterity(getDexterity() + race.getRacialDexAdjustment());
        setConstitution(getConstitution() + race.getRacialConAdjustment());
        setIntelligence(getIntelligence() + race.getRacialIntAdjustment());
        setWisdom(getWisdom() + race.getRacialWisAdjustment());
        setCharisma(getCharisma() + race.getRacialChaAdjustment());
    }

    private void raceAdjustments(final Race race) {
        adjustStatsForRace(race);
        for (Vision spectra : getRaceObject().getRacialVision()) {
            addToVisionSet(spectra);
        }
        setSpeed(getRaceObject().getRacialBaseLandSpeed());
        setLanguage(getRaceObject().getAutomaticRacialLanguage());
        addToUnallocatedFeats(getRaceObject().getRacialBonusFeats());
        addToUnallocatedSkillPoints(getRaceObject().getRacialExtraSkillPoints());
    }

    public void setClass(final Classes jobClass) {
        switch(jobClass) {
            case FIGHTER:
                JobClass fighter = new Fighter(getIntelligenceModifier(), getLevel());
                setJobObject(fighter);
                adjustForClass(BaseAbilities.STRENGTH);
                break;
            case CLERIC:
                JobClass cleric = new Cleric(getIntelligenceModifier(), getLevel(), Deities.PELOR);
                setJobObject(cleric);
                adjustForClass(BaseAbilities.STRENGTH);
        }
    }

    public void setSecondaryClass(final Classes jobClass) {
        switch(jobClass) {
            case FIGHTER:
                JobClass fighter = new Fighter(getIntelligenceModifier(), getLevel());
                setJobObject(fighter);
        }
    }

    private void adjustForClass(final BaseAbilities ability) {
        if(getJob() != null) {
            getJobObject().setNumberOfFeats(getJobObject().calculateNumberOfFeats(getIntelligenceModifier()));
            addToUnallocatedFeats(getJobObject().getNumberOfFeats());
            setBaseAttackBonus(calculateBaseAttackBonus(getLevel(),
                    ability, getRaceObject().getSizeModifier()));
            addToUnallocatedSkillPoints(getJobObject().getSkillPoints());
            calculateReflexSavingThrow(0);
            calculateFortitudeSavingThrow(0);
            calculateWillSavingThrow(0);
        }
    }

    public Integer calculateBaseAttackBonus(final int level, final BaseAbilities ability, final int sizeModifier) {
        int skillModifier = 0;
        if(ability.equals(BaseAbilities.STRENGTH)) {
            skillModifier = getStrengthModifier();
        } else if (ability.equals(BaseAbilities.DEXTERITY)) {
            skillModifier = getDexterityModifier();
        }
        return getJobObject().calculateBaseAttackBonus(level) + skillModifier + sizeModifier;
    }

    public void addToVisionSet(Vision vision) {
        this.characterVision.add(vision);
    }

    public ArrayList<Vision> getCharacterVision() {
        return characterVision;
    }

    public void setUnallocatedSkillPoints(final int points) {
        this.unallocatedSkillPoints = points;
    }

    public int getUnallocatedSkillPoints() {
        return unallocatedSkillPoints;
    }

    public void addToUnallocatedFeats(final int additionalFeats) {
        this.numberOfUnallocatedFeats += additionalFeats;
    }

    public void subtractFromUnallocatedFeats(final int num) {
        if(getNumberOfUnallocatedFeats() > num) {
            this.numberOfUnallocatedFeats -= num;
        }
    }

    public void addToLanguages(final Languages language) {
        this.language.add(language);
    }

    private void setBaseAttackBonus(final int level) {
        getJobObject().setBaseAttackBonus(level);
        this.BaseAttackBonus =  getJobObject().getBaseAttackBonus();
    }

    public int getBaseAttackBonus() {
        return BaseAttackBonus;
    }

    public int getNumberOfUnallocatedFeats() {
        return numberOfUnallocatedFeats;
    }

    public void calculateGrapple() {
        this.Grapple = getBaseAttackBonus() + getStrengthModifier() + getRaceObject().getSizeModifier();
    }

    public int getGrapple() {
        return Grapple;
    }

    public void firstTimeRankSkill(final Skills skill, final double points) {

        if(points > getUnallocatedSkillPoints()) {
            System.out.println("Not Enough Skill Points");
        } else if(points % 0.5 == 0 && getUnallocatedSkillPoints() >= 0.5) {
            List<Skills> classSkills = getJobObject().getClassSkills();

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

    public Map<Skills, Double> getSkills() {
        return this.skills;
    }

    public Double getSkillRank(final Skills skill) {
        if(skills.containsKey(skill)){
            return skills.get(skill);
        } else {
            return 0.0;
        }
    }

    public void setEquippedWeapon(final WeaponList equippedWeapon) {
        this.EquippedWeapon = equippedWeapon;
    }

    public WeaponList getEquippedWeapon() {
        return EquippedWeapon;
    }

    public void defaultWeapon() {
        LongSword longSword =  new LongSword();
        setEquippedWeapon(WeaponList.SWORD_LONG);
        setEquippedWeaponObject(longSword);
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
                            setEquippedWeapon(WeaponList.SWORD_LONG);
                            setEquippedWeaponObject(longSword);
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

    private Boolean ableToUseWeapon(final Weapon weapon) {
        Boolean able = FALSE;
        if (getJobObject().getWeaponProficiencies().contains(weapon.getWeaponClass())) {
            able = TRUE;
        }
        return able;
    }

    private Boolean ableToUseArmor(final Armor armor) {
        Boolean able = FALSE;
        if (getJobObject().getArmorProficiencies().contains(armor.getArmorType())) {
            able = TRUE;
        }
        return able;
    }

    public void setGold(final int gold) {
        this.Gold = gold;
    }

    public Integer getGold() {
        return Gold;
    }

    public void addToGold(Integer gold) {
        if(gold > 0) {
            this.Gold += gold;
        } else {
            // TODO: exception handler
        }
    }

    public void subtractGold(final Integer gold) {
        if(this.Gold > gold && gold > 0) {
            this.Gold -= gold;
        } else {
            // TODO: exception handler
        }
    }

    public Map<BaseAbilities, Integer> getAbilityScores() {
        return abilityScores;
    }

    public void setAbilityScores(final Map<BaseAbilities, Integer> abilityScores) {
        this.abilityScores = abilityScores;
    }

    public void addToVisionSet(final ArrayList<Vision> vision) {
        this.characterVision = vision;
    }

    public void setReflexSavingThrow(final int reflexSavingThrow) {
        ReflexSavingThrow = reflexSavingThrow;
    }

    public void setFortitudeSavingThrow(final int fortitudeSavingThrow) {
        FortitudeSavingThrow = fortitudeSavingThrow;
    }

    public void setWillSavingThrow(final int willSavingThrow) {
        WillSavingThrow = willSavingThrow;
    }

    public ArmorList getEquippedArmor() {
        return EquippedArmor;
    }

    public void setEquippedArmor(final ArmorList equippedArmor) {
        EquippedArmor = equippedArmor;
    }

    public ShieldTypes getShield() {
        return Shield;
    }

    public void setShield(ShieldTypes shield) {
        Shield = shield;
    }

    public Weapon getEquippedWeaponObject() {
        return EquippedWeaponObject;
    }

    public void setEquippedWeaponObject(final Weapon equippedWeaponObject) {
        EquippedWeaponObject = equippedWeaponObject;
    }

    public int getInitiativeModifier() {
        return InitiativeModifier;
    }

    public void calculateGrapple(final int grapple) {
        Grapple = grapple;
    }

    public ArrayList<Languages> getLanguage() {
        return language;
    }

    public void setLanguage(final ArrayList<Languages> language) {
        this.language = language;
    }

    public void setNumberOfUnallocatedFeats(final int numberOfUnallocatedFeats) {
        this.numberOfUnallocatedFeats = numberOfUnallocatedFeats;
    }

    public void setMaximumHitPoints(final int maximumHitPoints) {
        MaximumHitPoints = maximumHitPoints;
    }

    public Classes getJob() {
        return jobObject.getJobClass();
    }

    public void setJob(final JobClass job) {
        this.jobObject = job;
    }

    public void setSecondaryJob(final JobClass secondaryJob) {
        this.secondaryJob = secondaryJob;
    }

    public Gender getGender() {
        return gender;
    }

    public int getNakedWeight() {
        return nakedWeight;
    }

    public void setNakedWeight(final int nakedWeight) {
        this.nakedWeight = nakedWeight;
    }

    public int getExperiencePoints() {
        return ExperiencePoints;
    }

    public void setSkills(final HashMap<Skills,Double> skills) {
        this.skills = skills;
    }

    public ArrayList<Feats> getCharacterFeats() {
        return characterFeats;
    }

    public void setCharacterFeats(final ArrayList<Feats> characterFeats) {
        this.characterFeats = characterFeats;
    }

    public void addToFeatSet(final Feats feat) {
        if(getNumberOfUnallocatedFeats() > 0) {
            characterFeats.add(feat);
            subtractFromUnallocatedFeats(1);
        } else {
            // TODO: Exception handler
        }
    }

    public Armor getEquippedArmorObject() {
        return EquippedArmorObject;
    }

    public void setEquippedArmorObject(final Armor equippedArmorObject) {
        EquippedArmorObject = equippedArmorObject;
    }

    public JobClass getJobObject() {
        return jobObject;
    }

    public void setJobObject(final JobClass jobObject) {
        this.jobObject = jobObject;
    }

    public void setSpellsPerDay(Map<Integer, Integer> spellsPerDay) {
        this.spellsPerDay = spellsPerDay;
    }

    public Map<Integer, Integer> getSpellsPerDay() {
        return spellsPerDay;
    }

    public Map<Integer, Integer> calculateSpellsPerDay() {
        getJobObject().setSpellsPerDay(getJobObject().calculateSpellsPerDay(getLevel()));
        Map<Integer, Integer> spells = getJobObject().getSpellsPerDay();
        getJobObject().setBonusSpells(getJobObject().calculateBonusSpells(getWisdomModifier()));
        Map<Integer, Integer> bonusSpells = getJobObject().getBonusSpells();

        for (int i = 0; i < spells.keySet().size() - 1; i++) {
            spells.put(i, spells.get(i) + bonusSpells.get(i));
        }

        return spells;
    }
}
