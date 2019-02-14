package characterTraits.Classes;

import Equipment.Armor.ArmorTypes;
import Equipment.Armor.ShieldTypes;
import Equipment.Weapons.WeaponTypes;
import characterTraits.Alignment;
import characterTraits.Dice;
import static characterTraits.Skills.*;

import java.util.ArrayList;
import java.util.Arrays;



public class Fighter extends JobClass {

    public Fighter(){}

    public Fighter(final int IntModifier, final int level) {
        setHitDice(Dice.d10);
        setSkillPoints(calculateSkillPoints(IntModifier, level));
        setNumberOfFeats(1);
        setBaseAttackBonus(level);
        setSecondAttackBonus(calculateSecondAttackBonus(level));
        setThirdAttackBonus(calculateThirdAttackBonus(level));
        setFortitudeSave(calculateFortitudeSave(level));
        setReflexSave(calculateReflexSave(level));
        setWillSave(calculateWillSave(level));
        setPreferredAlignment(Alignment.Any);
        setNumberOfFeats(calculateNumberOfFeats(level));
        ArrayList armorProficiencies = new ArrayList<>(Arrays.asList(ArmorTypes.LIGHT,ArmorTypes.MEDIUM, ArmorTypes.HEAVY));
        setArmorProficiencies(armorProficiencies);
        ArrayList shieldProficiencies = new ArrayList<>(Arrays.asList(ShieldTypes.ALL));
        setShieldProficiencies(shieldProficiencies);
        ArrayList weaponProficiencies = new ArrayList<>(Arrays.asList(WeaponTypes.SIMPLE,WeaponTypes.MARTIAL));
        setWeaponProficiencies(weaponProficiencies);
        ArrayList classSkills = new ArrayList<>(Arrays.asList(CLIMB,CRAFT, HANDLE_ANIMAL, INTIMIDATE, JUMP, RIDE, SWIM));
        setClassSkills(classSkills);
    }

    @Override
    public Integer calculateNumberOfFeats(final int level) {
        int numFeats = 0;
        if(level == 1) {
            numFeats = 1;
        } else {
            if (level % 2 == 0 && level > 0){
                numFeats += 1;
            }
        }
        return numFeats;
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

    @Override
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
    public Integer calculateReflexSave(int level) {
        Integer save = 0;
        if(level % 3 == 0 && level > 0) {
            save += 1;
        }

        return save;
    }

    @Override
    public Integer calculateWillSave(final int level) {
        Integer save = 0;
        if(level % 3 == 0 && level > 0) {
            save += 1;
        }
        return save;
    }

    private Integer calculateSecondAttackBonus(final int level) {
        Integer bonus = 0;
        if(level < 6) {
            bonus = 0;
        }
        return bonus;
    }

    private Integer calculateThirdAttackBonus(final int level) {
        Integer bonus = 0;
        if(level < 11) {
            bonus = 0;
        }
        return bonus;
    }
}
