package characterTraits.Classes;

import Equipment.Armor.ArmorTypes;
import Equipment.Armor.ShieldTypes;
import Equipment.Weapons.WeaponTypes;
import characterTraits.Alignment;
import characterTraits.Dice;
import characterTraits.Sizes;
import characterTraits.Skills;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@Getter
@Setter
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
    private Map<Integer, Integer> spellsPerDay;

    public Integer calculateBaseAttackBonus(final int level) { return level; }

    public Integer calculateSecondAttackBonus(final int level) {
        return null;
    }

    public Integer calculateThirdAttackBonus(final int level) {
        return null;
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

    public Map<Integer, Integer> calculateSpellsPerDay(int level) {
        Map<Integer, Integer> spells = new HashMap<>();
        for(int i = 1; i <= level; i++) {
            if(i == 1) {
                spells.put(i,3);
                spells.put(1, 1);
            } else if(i % 2 == 0) {
                for(int j = 0; j < i; j++) {
                    spells.put(j, spells.get(j) + 1);
                }
            } else if(i % 2 != 0) {
                spells.put(i - 1, 1);
            }
        }
        return spells;
    }

    public Map<Integer, Integer> calculateBonusSpells(final int wisdomMod) {
        Map<Integer,Integer> bonus = new HashMap<>();
        bonus.put(0, 0);
        if(wisdomMod < 1 ) {
            for (int i = 9; i >= 0; i--) {
                bonus.put(i, 0);
            }
        } else if (wisdomMod < 5 && wisdomMod > 0) {
            for(int spellLevel = 1; spellLevel <= wisdomMod; spellLevel++) {
                bonus.put(spellLevel, 1);
            }
        }

        return bonus;
    }

}
