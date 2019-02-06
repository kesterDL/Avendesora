package characterTraits;

import Equipment.Armor.*;
import Equipment.Weapons.LongSword;
import Equipment.Weapons.Weapon;
import Equipment.Weapons.WeaponList;
import characterTraits.Classes.Classes;
import characterTraits.Classes.Fighter;
import characterTraits.Classes.JobClass;
import characterTraits.Feats.Feats;
import characterTraits.Race.Human;
import characterTraits.Race.Race;
import characterTraits.Race.RaceChoice;

import java.util.*;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Character {
    /**
     * Map of abilityScores and their score.
     */
    private Map<BaseAbilities, Integer> abilityScores = createBaseAbilityMap();
    /**
     * Map of scores and their modifiers.
     */
    private Map<Integer, Integer> abilityModifiers = createModifierMap();
    /**
     * Character's Race type.
     */
    private RaceChoice raceChoice;
    /**
     * Vision Spectrum.
     */
    private ArrayList<Vision> vision = new ArrayList<>();
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
    private ArrayList<Languages> language = new ArrayList<>();
    /**
     * Total number of feats.
     */
    private int numberOfFeats;
    /**
     * List of all the character's feats.
     */
    private ArrayList<Feats> feats = new ArrayList<Feats>();
    /**
     * Max Hit points.
     */
    private int MaximumHitPoints;
    /**
     * Current Hit points.
     */
    private int CurrentHitPoints;
    /**
     * Job class.
     */
    private Classes job;
    /**
     * Job class object.
     */
    private JobClass jobObject;
    /**
     * Secondary job class.
     */
    private Classes secondaryJob;
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
    private int SkillPoints = 0;
    /**
     * List of character's skills
     */
    private List<Skills> skills = new ArrayList<>();
    /**
     * Rank of each skill.
     */
    private List<Double> skillRanks = new ArrayList<>();
    /**
     * Current Level.
     */
    private int Level = 0;
    /**
     * Amount of money character owns (in gold).
     */
    private int Gold = 0;

    // Dice
    Random dice = new Random();


    public Character(RaceChoice raceChoice, Classes jobClass, Gender gender) {

        // Level 1
        setLevel(1);
        // Initial Ability Stats
        selectAbilityStats();
        addToFeats(1);
        // RaceChoice and JobClass
        setRaceChoice(raceChoice);
        setClass(jobClass);
        // General Character Info
        setMaximumHitPoints();
        setGold(100);
        setGrapple();
        chooseArmorClass();
        chooseWeapon();
        setGender(gender);
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

    private Integer rollAnAbilityStat() {
        ArrayList<Integer> rolls = new ArrayList<>();
        for(int j = 0; j < 4; j++){
            rolls.add(rollAD6());
        }
        return sumOfRollsMinusMin(rolls);
    }

    private Map<BaseAbilities, Integer> createBaseAbilityMap() {
        Map<BaseAbilities, Integer> scores = new HashMap<>();
        scores.put(BaseAbilities.STRENGTH, null);
        scores.put(BaseAbilities.DEXTERITY, null);
        scores.put(BaseAbilities.CONSTITUTION, null);
        scores.put(BaseAbilities.INTELLIGENCE, null);
        scores.put(BaseAbilities.WISDOM, null);
        scores.put(BaseAbilities.CHARISMA, null);

        return scores;
    }

    private Map<Integer, Integer> createModifierMap() {
        Map<Integer, Integer> modifiers = new HashMap<>();

        for (int i = 0; i < 25; i++) {
            modifiers.put(i, calculateModifier(i));
        }

        return modifiers;
    }

    public Integer rollAD6() {
        return dice.nextInt(6 - 1 + 1) + 1;
    }

    public Integer rollAD20() {
        return dice.nextInt(20 - 1 + 1) + 1;
    }

    public Integer rollAD12() {
        return dice.nextInt(12 - 1 + 1) + 1;
    }

    public Integer rollAD10() {
        return dice.nextInt(10 - 1 + 1) + 1;
    }

    public Integer rollAD8() {
        return dice.nextInt(8 - 1 + 1) + 1;
    }

    public Integer rollAD4() {
        return dice.nextInt(4 - 1 + 1) + 1;
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
            setAbility(ability, abilityRolls);
        }
        printOutCharacterAbilityStats();
    }

    private void setAbility(final BaseAbilities ability, final ArrayList<Integer> abilityRolls) {
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
        getJobObject().setReflexSave(getJobObject().calculateReflexSave(getDexterityModifier()));
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
        getJobObject().setWillSave(getJobObject().calculateWillSave(getLevel()));
        setWillSavingThrow(getJobObject().getWillSave() + getWisdomModifier() + magicMod);

    }

    public void setArmorClass(Integer armorClass) {
        this.ArmorClass = armorClass;
    }

    public int getArmorClass() {
        return ArmorClass;
    }

    public void chooseArmorClass() {
        Integer armorClass = 10 + getDexterityModifier();
        if (getRaceChoice() == RaceChoice.GNOME || getRaceChoice() == RaceChoice.HALFLING){
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

    public void setMaximumHitPoints() {
        switch(getJob()) {
            case FIGHTER:
            case PALADIN:
                this.MaximumHitPoints = 10 + getConstitutionModifier();
                break;
            case WIZARD:
            case SORCERER:
                this.MaximumHitPoints = 4 + getConstitutionModifier();
                break;
            case ROUGE:
            case BARD:
                this.MaximumHitPoints = 6 + getConstitutionModifier();
                break;
            case BARBARIAN:
                this.MaximumHitPoints = 12 + getConstitutionModifier();
                break;
        }
    }

    public int getCurrentHitPoints() {
        return CurrentHitPoints;
    }

    public void setCurrentHitPoints(int currentHitPoints) {
        this.CurrentHitPoints = currentHitPoints;
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

    private void setRaceChoice(RaceChoice charRaceChoice) {
        raceChoice = charRaceChoice;
        setRacialTraits();
    }

    public RaceChoice getRaceChoice() {
        return raceChoice;
    }

    private void setRacialTraits() {
        if (raceChoice != null) {
            switch (getRaceChoice()) {
                case HUMAN:
                    Race human = new Human();
                    // TODO: Create a Racial object
                    for (Vision spectra : human.getRacialVision()) {
                        addToVisionSet(spectra);
                    }
                    setSpeed(human.getRacialBaseLandSpeed());
                    addToLanguages(Languages.COMMON);
                    addToFeats(human.getRacialBonusFeats());
                    break;
                case DWARF:
                    int constitution = getConstitution();
                    int charisma = getCharisma();
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
        }
    }
    public void setClass(final Classes jobClass) {
        this.job = jobClass;
        switch(job) {
            case FIGHTER:
                JobClass fighter = new Fighter(getIntelligenceModifier());
                setJobObject(fighter);
        }
        adjustForClass();
    }

    public void setSecondaryClass(Classes jobClass) {
        this.secondaryJob = jobClass;
    }

    private void adjustForClass() {
        if(getJob() != null) {
            getJobObject().setNumberOfFeats(getJobObject().calculateNumberOfFeats(getIntelligenceModifier()));
            addToFeats(getJobObject().getNumberOfFeats());
            getJobObject().setBaseAttackBonus(1);
            setBaseAttackBonus(getJobObject().getBaseAttackBonus());
            // TODO: There is an error in setting the skill points
            System.out.println("======= Adjust for class Skill points: " + getJobObject().getSkillPoints1stLevel());
            setSkillPoints(getJobObject().getSkillPoints1stLevel());
            calculateReflexSavingThrow(0);
            calculateFortitudeSavingThrow(0);
            calculateWillSavingThrow(0);
        }
    }

    public void addToVisionSet(Vision vision) {
        this.vision.add(vision);
    }

    public ArrayList<Vision> getVision() {
        return vision;
    }

    public void setSkillPoints(final int points) {
        this.SkillPoints = points;
    }

    public int getSkillPoints() {
        return SkillPoints;
    }

    public void addToFeats(final int additionalFeats) {
        this.numberOfFeats += additionalFeats;
    }

    public void subtractFromFeats(final int num) {
        if(getNumberOfFeats() > num) {
            this.numberOfFeats -= num;
        }
    }
    public void addToLanguages(final Languages language) {
        this.language.add(language);
    }

    public Classes getJobClass() {
        return job;
    }

    public Classes getSecondaryJob() {
        return secondaryJob;
    }

    private void setBaseAttackBonus(final int level) {
        getJobObject().setBaseAttackBonus(level);
        this.BaseAttackBonus =  getJobObject().getBaseAttackBonus();

    }

    public int getBaseAttackBonus() {
        return BaseAttackBonus;
    }

    public int getNumberOfFeats() {
        return numberOfFeats;
    }

    public void setGrapple() {
        int sizeMod = 0;
        switch(getRaceChoice()) {
            case HUMAN:
                sizeMod = 0;
                break;
            case GNOME:
                sizeMod = -4;
                break;
        }
        this.Grapple = getBaseAttackBonus() + getStrengthModifier() + sizeMod;
    }

    public int getGrapple() {
        return Grapple;
    }

    public void firstTimeRankSkill(final Skills skill, final double points) {
        double unspentPoints = getSkillPoints();
        if(points > unspentPoints) {
            System.out.println("Not Enough Skill Points");
        } else if(points % 0.5 == 0 && this.SkillPoints >= 0.5) {
            List<Skills> classSkills = getJobObject().getClassSkills();

            if (classSkills.contains(skill) && points <= 4.0) {
                skills.add(skill);
                skillRanks.add(points);
                SkillPoints -= points;
            } else if(!classSkills.contains(skill) && points <= 4.0) {
                double nonClassrank = points / 2.0;
                skills.add(skill);
                skillRanks.add(nonClassrank);
                SkillPoints -= points;
            }else {
                System.out.println("Max rank at level 1 is 4, or 2 for non class skills");
            }
        }

    }

    public List<Skills> getSkills() {
        return this.skills;
    }

    public List<Double> getSkillRanks() {
        return this.skillRanks;
    }

    public String getSkillandRank(final Skills skill) {
        int location = 0;
        Double rank = 0.0;
        if(skills.contains(skill)){
            location = skills.indexOf(skill);
            rank = skillRanks.get(location);
        }
        String info = "Skill: " + skill.toString() + " Rank: " + rank.toString();
        return info;
    }

    public void setEquippedWeapon(final WeaponList equippedWeapon) {
        this.EquippedWeapon = equippedWeapon;
    }

    public WeaponList getEquippedWeapon() {
        return EquippedWeapon;
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
        this.vision = vision;
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

    public void setGrapple(final int grapple) {
        Grapple = grapple;
    }

    public ArrayList<Languages> getLanguage() {
        return language;
    }

    public void setLanguage(final ArrayList<Languages> language) {
        this.language = language;
    }

    public void setNumberOfFeats(final int numberOfFeats) {
        this.numberOfFeats = numberOfFeats;
    }

    public void setMaximumHitPoints(final int maximumHitPoints) {
        MaximumHitPoints = maximumHitPoints;
    }

    public Classes getJob() {
        return job;
    }

    public void setJob(final Classes job) {
        this.job = job;
    }

    public void setSecondaryJob(final Classes secondaryJob) {
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

    public void setSkills(final List<Skills> skills) {
        this.skills = skills;
    }

    public void setSkillRanks(final List<Double> skillRanks) {
        this.skillRanks = skillRanks;
    }

    public ArrayList<Feats> getFeats() {
        return feats;
    }

    public void setFeats(final ArrayList<Feats> feats) {
        this.feats = feats;
    }

    public void addToFeatSet(final Feats feat) {
        if(getNumberOfFeats() > 0) {
            feats.add(feat);
            subtractFromFeats(1);
        } else {
            // TODO: Exception handler
        }
    }

    public Integer rollToHit(){
        Integer natural = rollAD20();
        if(natural == 20){
            System.out.println("CRITICAL HIT!!!");
            return getEquippedWeaponObject().critical(TRUE);
        }
        return rollAD20() + getBaseAttackBonus();
    }

    public Integer rollDamage() {
        return getEquippedWeaponObject().rollDamage() + getStrengthModifier();
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
}
