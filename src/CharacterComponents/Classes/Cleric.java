package CharacterComponents.Classes;

import Equipment.Armor.ArmorCategory;
import Equipment.Armor.ShieldTypes;
import Equipment.Weapons.WeaponTypes;
import CharacterComponents.Alignment;
import CharacterComponents.Deities;
import CharacterComponents.Dice;

import java.util.ArrayList;
import java.util.Arrays;

import static CharacterComponents.Skills.*;

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
        ArrayList armorProficiencies = new ArrayList<>(Arrays.asList(ArmorCategory.LIGHT, ArmorCategory.MEDIUM,
                ArmorCategory.HEAVY));
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
