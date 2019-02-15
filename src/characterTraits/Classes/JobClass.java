package characterTraits.Classes;

import Equipment.Armor.ArmorTypes;
import Equipment.Armor.ShieldTypes;
import Equipment.Weapons.WeaponTypes;
import characterTraits.Alignment;
import characterTraits.Dice;
import characterTraits.Skills;

import java.util.ArrayList;

public abstract class JobClass {
    private Dice hitDice;
    private Integer baseAttackBonus;
    private Integer secondAttackBonus;
    private Integer thirdAttackBonus;
    private Integer FortitudeSave;
    private Integer ReflexSave;
    private Integer WillSave;
    private Alignment preferredAlignment;
    private Integer skillPoints;
    private Integer numberOfFeats;
    private ArrayList<ArmorTypes> armorProficiencies;
    private ArrayList<ShieldTypes> shieldProficiencies;
    private ArrayList<WeaponTypes> weaponProficiencies;
    private ArrayList<Skills> classSkills;
    private Classes jobClass;

    public Classes getJobClass() {
        return jobClass;
    }

    public void setJobClass(Classes jobClass) {
        this.jobClass = jobClass;
    }

    public Dice getHitDice() {
        return hitDice;
    }

    public void setHitDice(Dice hitDice) {
        this.hitDice = hitDice;
    }

    public int getBaseAttackBonus() {
        return baseAttackBonus;
    }

    public void setBaseAttackBonus(int baseAttackBonus) {
        this.baseAttackBonus = baseAttackBonus;
    }

    public int getSecondAttackBonus() {
        return secondAttackBonus;
    }

    public void setSecondAttackBonus(int secondAttackBonus) {
        this.secondAttackBonus = secondAttackBonus;
    }

    public int getThirdAttackBonus() {
        return thirdAttackBonus;
    }

    public void setThirdAttackBonus(int thirdAttackBonus) {
        this.thirdAttackBonus = thirdAttackBonus;
    }

    public Integer calculateSecondAttackBonus(final int level) {
        Integer bonus = 0;
        if(level < 6) {
            bonus = 0;
        }
        return bonus;
    }

    public Integer calculateThirdAttackBonus(final int level) {
        Integer bonus = 0;
        if(level < 11) {
            bonus = 0;
        }
        return bonus;
    }

    public Integer calculateFortitudeSave(int level) {
        return level;
    }

    public int getFortitudeSave() {
        return FortitudeSave;
    }

    public void setFortitudeSave(int fortitudeSave) {
        FortitudeSave = fortitudeSave;
    }

    public int getReflexSave() {
        return ReflexSave;
    }

    public Integer calculateReflexSave(int DexMod){
            return DexMod;
    }

    public void setReflexSave(int reflexSave) {
        ReflexSave = reflexSave;
    }

    public Integer calculateWillSave(int level) {
        return level;
    }

    public Integer calculateNumberOfFeats(int level) {
        return level;
    }
    public int getWillSave() {
        return WillSave;
    }

    public void setWillSave(int willSave) {
        WillSave = willSave;
    }

    public Alignment getPreferredAlignment() {
        return preferredAlignment;
    }

    public void setPreferredAlignment(Alignment preferredAlignment) {
        this.preferredAlignment = preferredAlignment;
    }

    public int getSkillPoints() {
        if (skillPoints == null) {
            setSkillPoints(0);
        }
        return skillPoints;
    }

    public void setSkillPoints(int skillPoints) {
        this.skillPoints = skillPoints;
    }

    public Integer calculateSkillPoints(final int IntModifier, final int level) {
        Integer points = (2 + IntModifier) * 4;
        if(level == 1 && points < 4){
            points = 4;
        } else if (level > 1) {
            points = getSkillPoints() + 2 + IntModifier;
        }
        return points;
    }

    public int getNumberOfFeats() {
        return numberOfFeats;
    }

    public void setNumberOfFeats(int numberOfFeats) {
        this.numberOfFeats = numberOfFeats;
    }

    public ArrayList<ArmorTypes> getArmorProficiencies() {
        return armorProficiencies;
    }

    public void setArmorProficiencies(ArrayList<ArmorTypes> armorProficiencies) {
        this.armorProficiencies = armorProficiencies;
    }

    public ArrayList<ShieldTypes> getShieldProficiencies() {
        return shieldProficiencies;
    }

    public void setShieldProficiencies(ArrayList<ShieldTypes> shieldProficiencies) {
        this.shieldProficiencies = shieldProficiencies;
    }

    public ArrayList<WeaponTypes> getWeaponProficiencies() {
        return weaponProficiencies;
    }

    public void setWeaponProficiencies(ArrayList<WeaponTypes> weaponProficiencies) {
        this.weaponProficiencies = weaponProficiencies;
    }

    public ArrayList<Skills> getClassSkills() {
        return classSkills;
    }

    public void setClassSkills(ArrayList<Skills> classSkills) {
        this.classSkills = classSkills;
    }
}
