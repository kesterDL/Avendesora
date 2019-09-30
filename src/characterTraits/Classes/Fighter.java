package characterTraits.Classes;

import Equipment.Armor.ArmorTypes;
import Equipment.Armor.ShieldTypes;
import Equipment.Weapons.WeaponTypes;
import characterTraits.Alignment;
import characterTraits.Dice;
import static characterTraits.Skills.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Fighter extends JobClass {
    final private Classes jobClass = Classes.FIGHTER;
    final private List armorProficiencies = new ArrayList<>(Arrays.asList(ArmorTypes.LIGHT,ArmorTypes.MEDIUM, ArmorTypes.HEAVY));
    final private List shieldProficiencies = new ArrayList<>(Arrays.asList(ShieldTypes.ALL));
    final private List weaponProficiencies = new ArrayList<>(Arrays.asList(WeaponTypes.SIMPLE, WeaponTypes.MARTIAL));
    final private List classSkills = new ArrayList<>(Arrays.asList(CLIMB,CRAFT, HANDLE_ANIMAL, INTIMIDATE, JUMP, RIDE, SWIM));
    final private Dice hitDice = Dice.d10;
    final private Alignment preferredAlignment = Alignment.Any;

    public Fighter(final Integer IntModifier, final Integer level) {
        super();
        setNumberOfFeats(calculateNumberOfFeats(level));
        setSkillPoints(calculateSkillPoints(IntModifier, level));
        setFortitudeSave(calculateFortitudeSave(level));
        setReflexSave(calculateReflexSave(level));
        setWillSave(calculateWillSave(level));
        setBaseAttackBonus(calculateBaseAttackBonus(level));
        setSecondAttackBonus(calculateSecondAttackBonus(level));
        setThirdAttackBonus(calculateThirdAttackBonus(level));
        setSpellsPerDay(calculateSpellsPerDay(level));
    }

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

    public Integer calculateReflexSave(int level) {
        Integer save = 0;
        if(level % 3 == 0 && level > 0) {
            save += 1;
        }

        return save;
    }

    public Integer calculateWillSave(final int level) {
        Integer save = 0;
        if(level % 3 == 0 && level > 0) {
            save += 1;
        }
        return save;
    }

    public Integer calculateBaseAttackBonus(final int level) {
        return level;
    }

    public Integer calculateSecondAttackBonus(final int level) {
        if (level >= 6) {
            return level - 5;
        } else {
            return 0;
        }
    }

    public Integer calculateThirdAttackBonus(final int level) {
        return calculateSecondAttackBonus(level);
    }

    public Map<Integer, Integer> calculateSpellsPerDay(int level) {
        Map<Integer, Integer> spellsPerDay = new HashMap<>();
        for (int i = level; i >= 0; i--) {
            spellsPerDay.put(i, 0);
        }

        return spellsPerDay;
    }

}
