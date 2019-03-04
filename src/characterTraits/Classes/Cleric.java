package characterTraits.Classes;

import Equipment.Armor.ArmorTypes;
import Equipment.Armor.ShieldTypes;
import Equipment.Weapons.WeaponTypes;
import characterTraits.Alignment;
import characterTraits.Deities;
import characterTraits.Dice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static characterTraits.Skills.*;

public class Cleric extends JobClass {

    public Cleric(int IntModifier, int level, Deities deity) {
        setJobClass(Classes.CLERIC);
        setHitDice(Dice.d8);
        setSkillPoints(calculateSkillPoints(IntModifier, level));
        setNumberOfFeats(1);
        setBaseAttackBonus(level);
//        setSecondAttackBonus(calculateSecondAttackBonus(level));
//        setThirdAttackBonus(calculateThirdAttackBonus(level));
        setFortitudeSave(calculateFortitudeSave(level));
        setReflexSave(calculateReflexSave(level));
        setWillSave(calculateWillSave(level));
        setPreferredAlignment(Alignment.Any);
        setNumberOfFeats(calculateNumberOfFeats(level));
        ArrayList armorProficiencies = new ArrayList<>(Arrays.asList(ArmorTypes.LIGHT, ArmorTypes.MEDIUM,
                ArmorTypes.HEAVY));
        setArmorProficiencies(armorProficiencies);
        ArrayList shieldProficiencies = new ArrayList<>(Arrays.asList(ShieldTypes.BUCKLER, ShieldTypes.LIGHT_WOODEN,
                ShieldTypes.HEAVY_STEEL, ShieldTypes.HEAVY_WOODEN, ShieldTypes.LIGHT_STEEL));
        setShieldProficiencies(shieldProficiencies);
        ArrayList weaponProficiencies = new ArrayList<>(Arrays.asList(WeaponTypes.SIMPLE));
        setWeaponProficiencies(weaponProficiencies);
        ArrayList classSkills = new ArrayList<>(Arrays.asList(CONCENTRATION, CRAFT, DIPLOMACY, HEAL, KNOWLEDGE_ARCANA,
                KNOWLEDGE_HISTORY, KNOWLEDGE_NATURE, KNOWLEDGE_PLANES, KNOWLEDGE_RELIGION, PROFESSION, SPELLCRAFT));
        setClassSkills(classSkills);
    }

    @Override
    public Integer calculateBaseAttackBonus(final int level) {
        return level - 1;
    }

    public void adjustForDiety(Deities deity) {

    }

}
