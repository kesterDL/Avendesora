package characterTraits.Classes;

import Equipment.Armor.ArmorTypes;
import Equipment.Armor.ShieldTypes;
import Equipment.Weapons.WeaponTypes;
import characterTraits.Alignment;
import characterTraits.Dice;
import characterTraits.Skills;

import java.util.ArrayList;
import java.util.Arrays;

import static characterTraits.Skills.*;

public class Fighter extends JobClass {
    private Dice hitDice;
    private int baseAttackBonus;
    private int secondAttackBonus;
    private int thirdAttackBonus;
    private int FortitudeSave;
    private int ReflexSave;
    private int WillSave;
    private Alignment preferredAlignment;
    private int skillPoints1stLevel;
    private int skillPointsAtEachLevel;
    private int numberOfFeats = 0;
    private ArrayList<ArmorTypes> armorProficiencies;
    private ArrayList<ShieldTypes> shieldProficiencies;
    private ArrayList<WeaponTypes> weaponProficiencies;
    private ArrayList<Skills> classSkills;

    public Fighter(final int IntModifier) {
        setHitDice(Dice.d10);
        setSkillPoints1stLevel(calculateSkillPoints1stLevel(IntModifier));
        setNumberOfFeats(1);
        setBaseAttackBonus(1);
        setSecondAttackBonus(0);
        setThirdAttackBonus(0);
        setFortitudeSave(calculateFortitudeSave(1));
        setReflexSave(calculateReflexSave(1));
        setWillSave(calculateWillSave(1));
        setPreferredAlignment(Alignment.Any);
        setNumberOfFeats(calculateNumberOfFeats(1));
        armorProficiencies = new ArrayList<>(Arrays.asList(ArmorTypes.LIGHT,ArmorTypes.MEDIUM, ArmorTypes.HEAVY));
        shieldProficiencies = new ArrayList<>(Arrays.asList(ShieldTypes.ALL));
        weaponProficiencies = new ArrayList<>(Arrays.asList(WeaponTypes.SIMPLE,WeaponTypes.MARTIAL));
        classSkills = new ArrayList<>(Arrays.asList(CLIMB,CRAFT, HANDLE_ANIMAL, INTIMIDATE, JUMP, RIDE, SWIM));
    }
    @Override
    public ArrayList<ArmorTypes> getArmorProficiencies() {
        return armorProficiencies;
    }

    @Override
    public ArrayList<ShieldTypes> getShieldProficiencies() {
        return shieldProficiencies;
    }

    @Override
    public ArrayList<WeaponTypes> getWeaponProficiencies() {
        return weaponProficiencies;
    }

    @Override
    public Integer calculateNumberOfFeats(final int level) {
        int lvl = level;
        int numFeats = 0;
        if(level == 1) {
            numFeats = 1;
        } else {
            if (lvl % 2 == 0 && lvl > 0){
                numFeats += 1;
            }
        }
        return numFeats;
    }

    @Override
    public void setNumberOfFeats(final int numberOfFeats) {
        this.numberOfFeats = numberOfFeats;
    }

    @Override
    public Dice getHitDice() {
        return hitDice;
    }

    @Override
    public Alignment getPreferredAlignment() {
        return preferredAlignment;
    }

    @Override
    public int getSkillPoints1stLevel() {
        return skillPoints1stLevel;
    }

    public Integer calculateSkillPoints1stLevel(final int IntModifier) {
        Integer points = (2 + IntModifier) * 4;
        if(points < 4){
            points = 4;
        }
        System.out.println("==== Determining Starting skill points: " + points);
        return points;
    }

    @Override
    public int getSkillPointsAtEachLevel() {
        return skillPointsAtEachLevel;
    }

    public Integer calculateSkillPointsAtEachLevel(int IntModifier) {
        Integer points = 0;
        points = (2 + IntModifier);
        if(skillPointsAtEachLevel < 1) {
            points = 1;
        }

        return points;
    }

    @Override
    public ArrayList<Skills> getClassSkills() {
        return classSkills;
    }

    @Override
    public int getNumberOfFeats() {
        return numberOfFeats;
    }

    @Override
    public int getBaseAttackBonus() {
        return baseAttackBonus;
    }

    @Override
    public void setBaseAttackBonus(final int level) {
        this.baseAttackBonus = level;
    }

    @Override
    public int getFortitudeSave() {
        return FortitudeSave;
    }

    public Integer calculateFortitudeSave(int level) {
        Integer save = 2;
        while(level > 0) {
            if (level % 2 == 0 && level > 0) {
                save += 1;
            }
            level--;
        }
        return save;
    }

    @Override
    public int getReflexSave() {
        return ReflexSave;
    }

    @Override
    public Integer calculateReflexSave(int level) {
        Integer save = 0;
        if(level % 3 == 0 && level > 0) {
            this.ReflexSave += 1;
        }

        return save;
    }

    @Override
    public int getWillSave() {
        return WillSave;
    }

    @Override
    public Integer calculateWillSave(final int level) {
        Integer save = 0;
        if(level % 3 == 0 && level > 0) {
            save += 1;
        }
        return save;
    }

    @Override
    public int getSecondAttackBonus() {
        return secondAttackBonus;
    }

    private Integer calculateSecondAttackBonus(final int level) {
        Integer bonus = 0;
        if(level < 6) {
            this.secondAttackBonus = 0;
        }
        return bonus;
    }

    @Override
    public int getThirdAttackBonus() {
        return thirdAttackBonus;
    }

    @Override
    public void setThirdAttackBonus(final int thirdAttackBonus) {
        this.thirdAttackBonus = thirdAttackBonus;
    }

    @Override
    public void setHitDice(final Dice hitDice) {
        this.hitDice = hitDice;
    }

    @Override
    public void setPreferredAlignment(Alignment preferredAlignment) {
        this.preferredAlignment = preferredAlignment;
    }

    @Override
    public void setArmorProficiencies(final ArrayList<ArmorTypes> armorProficiencies) {
        this.armorProficiencies = armorProficiencies;
    }

    @Override
    public void setShieldProficiencies(final ArrayList<ShieldTypes> shieldProficiencies) {
        this.shieldProficiencies = shieldProficiencies;
    }

    @Override
    public void setWeaponProficiencies(final ArrayList<WeaponTypes> weaponProficiencies) {
        this.weaponProficiencies = weaponProficiencies;
    }

    @Override
    public void setClassSkills(final ArrayList<Skills> classSkills) {
        this.classSkills = classSkills;
    }

    @Override
    public void setSecondAttackBonus(final int secondAttackBonus) {
        this.secondAttackBonus = secondAttackBonus;
    }

    @Override
    public void setFortitudeSave(final int fortitudeSave) {
        FortitudeSave = fortitudeSave;
    }

    @Override
    public void setReflexSave(final int reflexSave) {
        ReflexSave = reflexSave;
    }

    @Override
    public void setWillSave(final int willSave) {
        WillSave = willSave;
    }

    @Override
    public void setSkillPointsAtEachLevel(final int skillPointsAtEachLevel) {
        this.skillPointsAtEachLevel = skillPointsAtEachLevel;
    }
}
