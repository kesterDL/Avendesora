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

public class JobClass {
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
    private int numberOfFeats;
    private ArrayList<ArmorTypes> armorProficiencies;
    private ArrayList<ShieldTypes> shieldProficiencies;
    private ArrayList<WeaponTypes> weaponProficiencies;
    private ArrayList<Skills> classSkills;

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

    public int getSkillPoints1stLevel() {
        return skillPoints1stLevel;
    }

    public void setSkillPoints1stLevel(int skillPoints1stLevel) {
        this.skillPoints1stLevel = skillPoints1stLevel;
    }

    public int getSkillPointsAtEachLevel() {
        return skillPointsAtEachLevel;
    }

    public void setSkillPointsAtEachLevel(int skillPointsAtEachLevel) {
        this.skillPointsAtEachLevel = skillPointsAtEachLevel;
    }

    public int getNumberOfFeats() {
        return numberOfFeats;
    }

    public Integer calculateNumberOfFeats(int level) {
        return level;
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
