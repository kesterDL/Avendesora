package characterTraits;

import Equipment.Armor.*;
import Equipment.Weapons.LongSword;
import Equipment.Weapons.Weapon;
import Equipment.Weapons.WeaponList;
import Equipment.Weapons.WeaponTypes;
import characterTraits.Classes.Classes;
import characterTraits.Classes.Fighter;
import characterTraits.Race.Human;
import characterTraits.Race.Race;

import java.util.*;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Character {
    /**
     * Character's base strength score.
     */
    private int Strength;
    /**
     * Character's base dexterity score.
     */
    private int Dexterity;
    /**
     * Character's base constitution score.
     */
    private int Constitution;
    /**
     * Character's base intelligence score.
     */
    private int Intelligence;
    /**
     * Character's base wisdom score.
     */
    private int Wisdom;
    /**
     * Character's base charisma score.
     */
    private int Charisma;
    /**
     * List of abilities.
     */
    private ArrayList<BaseAbilities> abilities = new ArrayList<>(Arrays.asList(BaseAbilities.STRENGTH, BaseAbilities.DEXTERITY,BaseAbilities.CONSTITUTION,
            BaseAbilities.INTELLIGENCE, BaseAbilities.WISDOM, BaseAbilities.CHARISMA));
    /**
     * List of character's stats.
     */
    private ArrayList<Integer> stats = new ArrayList<>();
    /**
     * Character's base strength score.
     */
    private int StrengthModifier;
    /**
     * Character's base dexterity score.
     */
    private int DexterityModifier;
    /**
     * Character's base constitution score.
     */
    private int ConstitutionModifier;
    /**
     * Character's base intelligence score.
     */
    private int IntelligenceModifier;
    /**
     * Character's base wisdom score.
     */
    private int WisdomModifier;
    /**
     * Character's base charisma score.
     */
    private int CharismaModifier;
    /**
     * Character's Ability Modifiers
     */
    private ArrayList<Integer> modifiers = new ArrayList<>();
    /**
     * Character's Race type.
     */
    private Race race;
    /**
     * Character's Vision Spectrum.
     */
    private ArrayList<Vision> vision = new ArrayList<>();
    /**
     * Charater's Dexterity Saving Throw.
     */
    private int ReflexSavingThrow;
    /**
     * Charater's Constitution Saving Throw.
     */
    private int FortitudeSavingThrow;
    /**
     * Charater's Wisdom Saving Throw.
     */
    private int WillSavingThrow;

    /**
     * Charater's EquippedArmor Class.
     */
    private Integer ArmorClass = 10;
    /**
     * Character's current armor.
     */
    private ArmorList EquippedArmor;
    /**
     * All the armor objects.
     */
    private ArmorObjects armorObjects = new ArmorObjects();
    /**
     * All the shield objects.
     */
    private ShieldObjects shieldObjects = new ShieldObjects();
    /**
     * Character's current shield.
     */
    private ShieldTypes Shield;
    /**
     * Character's current weapon.
     */
    private WeaponList EquippedWeapon;
    /**
     * Object for equipped current weapon.
     */
    private Weapon EquippedWeaponObject;
    /**
     * Character's Initiative.
     */
    private int InitiativeModifier;
    /**
     * Character's base attack bonus.
     */
    private int BaseAttackBonus;
    /**
     * Character's Grapple modifier.
     */
    private int Grapple;
    /**
     * Character's Base Movement Speed.
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
     * Character's Max Hit points.
     */
    private int MaximumHitPoints;
    /**
     * Character's Current Hit points.
     */
    private int CurrentHitPoints;
    /**
     * Character's class type.
     */
    private Classes job;
    /**
     * Character's secondary job class.
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
     * Character's naked weight.
     */
    private int nakedWeight = 0;
    /**
     * Character's Current Experience Points.
     */
    private int ExperiencePoints = 0;
    /**
     * Character's Skill Points.
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
     * Character's Current Level.
     */
    private int Level = 0;

    // Creates all the races and classes to choose from when creating a character
    // Classes
    Fighter fighter;
    // Races
    Human human;
    // Weapons
    LongSword longSword =  new LongSword();
    // Armor
    PaddedArmor paddedArmor = new PaddedArmor();


    public Character(Race race, Classes jobClass, Classes secondJobClass, Gender gender) {

        // Initial Ability Stats
        selectAbilityStats();
        // Level 1
        setLevel(1);
        addToFeats(1);
        // Race and Class
        setRace(race);
        setClass(jobClass);
        // General Character Info
        setMaximumHitPoints(getJobClass());
        setGrapple();
        chooseArmorClass();
        chooseWeapon();
        setGender(gender);
        setExperiencePoints(0);
        setInitiativeModifier(0);

    }

    private Integer rollAnAbilityStat() {
        int stat = 0;
        for(int j = 0; j < 3; j++){
            stat += rollAD6();
        }
        return stat;
    }

    public Integer rollAD6() {
        Random d6 = new Random();
        return d6.nextInt(6 - 1 + 1) + 1;
    }

    private void setStatsListForCreation(){
        // Roll the all the scores and save them in a list
        for(int i = 0; i < 6; i++){
            this.stats.add(rollAnAbilityStat());
        }
    }

    private void printOutStatsForCreation(){
        // Print all the scores to the user
        for(int i = 0; i < stats.size(); i++){
            if ( i == stats.size()-1){
                System.out.print(stats.get(i));
            } else {
                System.out.print(stats.get(i) + ", ");
            }
        }
        System.out.println();
    }

    public void printOutCharacterAbilityStats() {
        for (BaseAbilities ability: abilities){
            switch(ability){
                case STRENGTH:
                    System.out.println(ability.toString() + ": " + getStrength());
                    break;
                case DEXTERITY:
                    System.out.println(ability.toString() + " : " + getDexterity());
                    break;
                case CONSTITUTION:
                    System.out.println(ability.toString() + " : " + getConstitution());
                    break;
                case INTELLIGENCE:
                    System.out.println(ability.toString() + ": " + getIntelligence());
                    break;
                case WISDOM:
                    System.out.println(ability.toString() + ": " + getWisdom());
                    break;
                case CHARISMA:
                    System.out.println(ability.toString() + ": " + getCharisma());
                    break;
            }
        }
    }

    public void selectAbilityStats(){
        this.stats = new ArrayList<>();
        // Roll the all the scores and save them in a list
        setStatsListForCreation();
        // Ask user to choose each stat from the list
        for (BaseAbilities ability: abilities) {
            printOutStatsForCreation();
            setAbility(ability);
        }
        setAllBaseAbilityModifiers();
        printOutCharacterAbilityStats();
    }

    private void setAbility(BaseAbilities ability) {
        Scanner user_input = new Scanner(System.in);
        String selection;
        Integer intSelection = 0;
        Boolean validSelection = false;

        while(!validSelection){
            System.out.print("Select an ability score for " + ability.toString() + ": ");
            selection = user_input.next();
            intSelection = Integer.parseInt(selection);
            // Accept input and assign the stat
            if(!stats.contains(intSelection)){
                System.out.println("Select a score from the list of available stats");
                printOutStatsForCreation();
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
                stats.remove(intSelection);
                System.out.println("Character's " + ability.toString() + " is: " + selection);
            }
        }
    }

    public ArrayList<Integer> getModifiers() {
        return modifiers;
    }

    public int getStrength() {
        return Strength;
    }

    public void setStrength(int strength) {
        this.Strength = strength;
    }

    public int getDexterity() {
        return Dexterity;
    }

    public void setDexterity(int dexterity) {
        this.Dexterity = dexterity;
    }

    public int getConstitution() {
        return Constitution;
    }

    public void setConstitution(int constitution) {
        this.Constitution = constitution;
    }

    public int getIntelligence() {
        return Intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.Intelligence = intelligence;
    }

    public int getWisdom() {
        return Wisdom;
    }

    public void setWisdom(int wisdom) {
        this.Wisdom = wisdom;
    }

    public int getCharisma() {
        return Charisma;
    }

    public void setCharisma(int charisma) {
        this.Charisma = charisma;
    }

    public int getStrengthModifier() {
        return StrengthModifier;
    }

    private void setStrengthModifier(int strengthModifier) {
        StrengthModifier = strengthModifier;
    }

    public int getDexterityModifier() {
        return DexterityModifier;
    }

    private void setDexterityModifier(int dexterityModifier) {
        DexterityModifier = dexterityModifier;
    }

    public int getConstitutionModifier() {
        return ConstitutionModifier;
    }

    private void setConstitutionModifier(int constitutionModifier) {
        ConstitutionModifier = constitutionModifier;
    }

    public int getIntelligenceModifier() {
        return IntelligenceModifier;
    }

    private void setIntelligenceModifier(int intelligenceModifier) {
        IntelligenceModifier = intelligenceModifier;
    }

    public int getWisdomModifier() {
        return WisdomModifier;
    }

    private void setWisdomModifier(int wisdomModifier) {
        WisdomModifier = wisdomModifier;
    }

    public int getCharismaModifier() {
        return CharismaModifier;
    }

    private void setCharismaModifier(int charismaModifier) {
        CharismaModifier = charismaModifier;
    }

    public int getReflexSavingThrow() {
        return ReflexSavingThrow;
    }

    private void setReflexSavingThrow(Classes job, int magicMod) {
        switch(job) {
            case FIGHTER:
                fighter.setReflexSave(getLevel());
                this.ReflexSavingThrow =  fighter.getReflexSave() + getDexterityModifier() + magicMod;
                break;
            // TODO:
        }
    }

    public int getFortitudeSavingThrow() {
        return FortitudeSavingThrow;
    }

    private void setFortitudeSavingThrow(Classes job, int magicMod) {
        switch(job) {
            case FIGHTER:
                fighter.setFortitudeSave(getLevel());
                this.FortitudeSavingThrow =  fighter.getFortitudeSave()+ getConstitutionModifier() + magicMod;
                break;
            // TODO:
        }
    }

    public int getWillSavingThrow() {
        return WillSavingThrow;
    }

    private void setWillSavingThrow( Classes job, int magicMod) {
        switch(job) {
            case FIGHTER:
                fighter.setWillSave(getLevel());
                this.WillSavingThrow =  fighter.getWillSave() + getWisdomModifier() + magicMod;
                break;
            // TODO:
        }
    }

    public void setArmorClass(Integer armorClass) {
        this.ArmorClass = armorClass;
    }

    public int getArmorClass() {
        return ArmorClass;
    }

    public void chooseArmorClass() {
        this.ArmorClass += getDexterityModifier();
        if (getRace() == Race.GNOME || getRace() == Race.HALFLING){
            this.ArmorClass += 1;
        }
        selectArmor();
        selectShield();
    }

    public void selectArmor() {
        ArmorTypes armorClass = selectArmorClass();
        switch(armorClass){
            case LIGHT:
                selectLightArmor();
                break;
            case MEDIUM:
                // TODO:
            case HEAVY:
                // TODO:
        }
    }

    private void selectShield(){
        Scanner user_input = new Scanner(System.in);
        ArrayList<ShieldTypes> shieldList = new ArrayList<>(Arrays.asList(ShieldTypes.NONE,ShieldTypes.BUCKLER,ShieldTypes.LIGHT_WOODEN,
                ShieldTypes.LIGHT_STEEL, ShieldTypes.HEAVY_WOODEN, ShieldTypes.HEAVY_STEEL, ShieldTypes.TOWER));
        String selection;
        Integer intSelection = 0;
        Boolean validSelection = false;

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
                        this.Shield = ShieldTypes.BUCKLER;
                        ShieldBuckler buckler = shieldObjects.getBuckler();
                        this.ArmorClass += buckler.getArmorBonus();
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

    }

    private void selectLightArmor(){
        Scanner user_input = new Scanner(System.in);
        ArrayList<ArmorList> armorListList = new ArrayList<>(Arrays.asList(EquippedArmor.PADDED, EquippedArmor.LEATHER,
                EquippedArmor.STUDDED_LEATHER, EquippedArmor.CHAIN_SHIRT));
        ArmorList armor = EquippedArmor.LEATHER;
        String selection;
        Integer intSelection = 0;
        Boolean validSelection = false;

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
                        this.EquippedArmor = EquippedArmor.PADDED;
                        this.ArmorClass += paddedArmor.getArmorBonus();
                        break;
                    case 2:
                        this.EquippedArmor = EquippedArmor.LEATHER;
                        LeatherArmor leatherArmor = armorObjects.getLeatherArmor();
                        this.ArmorClass += leatherArmor.getArmorBonus();
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
                        this.EquippedArmor = EquippedArmor.LEATHER;
                }
            }
        }


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

    public void setInitiativeModifier(int additionalMod) {
        if (modifiers.get(1) > 0) {
            InitiativeModifier = modifiers.get(1) + additionalMod;
        } else {
            InitiativeModifier = 0;
        }
    }

    public int getSpeed() {
        return Speed;
    }

    public void setSpeed(int speed) {
        this.Speed = speed;
    }

    public int getMaximumHitPoints() {
        return MaximumHitPoints;
    }

    public void setMaximumHitPoints(Classes job) {
        switch(job) {
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

    public void setExperiencePoints(int experiencePoints) {
        this.ExperiencePoints = experiencePoints;
    }

    public void addToExperiencePoints(int points) {
        this.ExperiencePoints += points;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public void setAllBaseAbilityModifiers() {
        for (BaseAbilities ability: abilities){
            setAbilityModifier(ability);
        }
        this.modifiers = new ArrayList<>(Arrays.asList(getStrengthModifier(), getDexterityModifier(), getConstitutionModifier(),
                getIntelligenceModifier(), getWisdomModifier(), getCharismaModifier()));
    }

    public void setAbilityModifier(BaseAbilities ability) {
        int abilityScore = 0;
        switch(ability){
            case STRENGTH:
                abilityScore = getStrength();
                setStrengthModifier(calculateModifier(abilityScore));
                break;
            case DEXTERITY:
                abilityScore = getDexterity();
                setDexterityModifier(calculateModifier(abilityScore));
                break;
            case CONSTITUTION:
                abilityScore = getConstitution();
                setConstitutionModifier(calculateModifier(abilityScore));
                break;
            case INTELLIGENCE:
                abilityScore = getIntelligence();
                setIntelligenceModifier(calculateModifier(abilityScore));
                break;
            case WISDOM:
                abilityScore = getWisdom();
                setWisdomModifier(calculateModifier(abilityScore));
                break;
            case CHARISMA:
                abilityScore = getCharisma();
                setCharismaModifier(calculateModifier(abilityScore));
                break;
        }
    }

    public Integer calculateModifier(Integer abilityScore) {
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

    public ArrayList<Integer> getAbilityModifiers() {
        return modifiers;
    }

    public void setRace(Race charRace) {
        race = charRace;
        setRacialTraits();
    }

    public Race getRace() {
        return race;
    }

    private void setRacialTraits() {
        if (race != null) {
            switch (getRace()) {
                case HUMAN:
                    human = new Human();
                    for (Vision spectra : human.getVision()) {
                        setVision(spectra);
                    }
                    setSpeed(human.getBaseLandSpeed());
                    addToLanguages(Languages.COMMON);
                    addToFeats(human.getBonusFeats());
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
    public void setClass(Classes jobClass) {
        this.job = jobClass;
        adjustForClass(jobClass);
    }

    public void setSecondaryClass(Classes jobClass) {
        this.secondaryJob = jobClass;
    }

    private void adjustForClass(Classes job){
        ArrayList<Integer> mods = getAbilityModifiers();
        if(job != null) {
            switch(job) {
                case FIGHTER:
                    fighter = new Fighter(mods.get(3));
                    fighter.setNumberOfFeats(getLevel());
                    addToFeats(fighter.getNumberOfFeats());
                    setBaseAttackBonus(getLevel());
                    setSkillPoints(fighter.getSkillPoints1stLevel());
                    break;
            }
            setReflexSavingThrow(getJobClass(), 0);
            setWillSavingThrow(getJobClass(), 0);
            setFortitudeSavingThrow(getJobClass(), 0);
        }
    }

    public void setVision(Vision vision) {
        this.vision.add(vision);
    }

    public ArrayList<Vision> getVision() {
        return vision;
    }

    public void setSkillPoints(int points) {
        this.SkillPoints = points;
    }

    public int getSkillPoints() {
        return SkillPoints;
    }

    public void addToFeats(int additionalFeats) {
        this.numberOfFeats += additionalFeats;
    }

    public void addToLanguages(Languages language) {
        this.language.add(language);
    }

    public Classes getJobClass() {
        return job;
    }

    public Classes getSecondaryJob() {
        return secondaryJob;
    }

    private void setBaseAttackBonus(int level) {
        switch(job) {
            case FIGHTER:
                fighter.setBaseAttackBonus(level);
                this.BaseAttackBonus =  fighter.getBaseAttackBonus();
                break;
        }
    }

    public int getBaseAttackBonus() {
        return BaseAttackBonus;
    }

    public int getNumberOfFeats() {
        return numberOfFeats;
    }

    public void setGrapple() {
        int sizeMod = 0;
        switch(getRace()) {
            case HUMAN:
                sizeMod = 0;
                break;
            case GNOME:
                sizeMod = -4;
                break;
        }
        this.Grapple = getBaseAttackBonus() + getAbilityModifiers().get(0) + sizeMod;
    }

    public int getGrapple() {
        return Grapple;
    }

    public void firstTimeRankSkill(Skills skill, double points) {
        double unspentPoints = getSkillPoints();
        if(points > unspentPoints) {
            System.out.println("Not Enough Skill Points");
        } else if(points % 0.5 == 0 && this.SkillPoints >= 0.5) {
            List<Skills> classSkills = new ArrayList<Skills>();

            switch (job) {
                case FIGHTER:
                    classSkills = fighter.getClassSkills();
                    break;
            }
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

    public String getSkillandRank(Skills skill) {
        int location = 0;
        Double rank = 0.0;
        if(skills.contains(skill)){
            location = skills.indexOf(skill);
            rank = skillRanks.get(location);
        }
        String info = "Skill: " + skill.toString() + " Rank: " + rank.toString();
        return info;
    }

    public void setEquippedWeapon(WeaponList equippedWeapon) {
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
                        if(ableToUseWeapon(longSword) == TRUE) {
                            setEquippedWeapon(WeaponList.SWORD_LONG);
                            EquippedWeaponObject = longSword;
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

    private Boolean ableToUseWeapon(Weapon weapon){
        Boolean able = FALSE;
        switch(getJobClass()) {
            case FIGHTER:
                if (isMartialWeapon(weapon) || isSimpleWeapon(weapon)) {
                    able = TRUE;
                }
                break;
            // TODO: Finish this list
            case ROUGE:
                // if () {
                // break;
            case RANGER:
            default:
                able = FALSE;
        }
        return able;
    }

    private Boolean isMartialWeapon(Weapon tool){
        if(tool.getWeaponClass() == WeaponTypes.MARTIAL){
            return TRUE;
        } else {
            return FALSE;
        }
    }

    private Boolean isSimpleWeapon(Weapon tool){
        if(tool.getWeaponClass() == WeaponTypes.SIMPLE){
            return TRUE;
        } else {
            return FALSE;
        }
    }
}
