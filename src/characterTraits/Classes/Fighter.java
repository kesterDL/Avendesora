package characterTraits.Classes;

import Equipment.Armor.ArmorTypes;
import Equipment.Armor.ShieldTypes;
import Equipment.Weapons.WeaponTypes;
import characterTraits.Alignment;
import characterTraits.Dice;
import characterTraits.Skills;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static characterTraits.Skills.*;

public class Fighter {
    Dice hitDice = Dice.d10;
    int baseAttackBonus = 1;
    int secondAttackBonus = 0;
    int thirdAttackBonus = 0;
    int FortitudeSave = 2;
    int ReflexSave = 0;
    int WillSave = 0;
    Alignment preferredAlignment = Alignment.Any;
    int skillPoints1stLevel = 0;
    int skillPointsAtEachLevel = 0;
    int numberOfFeats = 0;
    ArmorTypes armorProficiencies = ArmorTypes.ALL;
    ShieldTypes shieldProficiencies = ShieldTypes.ALL;
    List<WeaponTypes> weaponProficiencies = new ArrayList<>(Arrays.asList(WeaponTypes.SIMPLE,WeaponTypes.MARTIAL));
    List<Skills> classSkills = new ArrayList<>(Arrays.asList(CLIMB,CRAFT,
            HANDLE_ANIMAL, INTIMIDATE, JUMP, RIDE, SWIM));

    public Fighter(int IntModifier) {
        setSkillPoints1stLevel(IntModifier);
        setNumberOfFeats(1);
        setBaseAttackBonus(1);
        setFortitudeSave(1);
        setReflexSave(1);
        setWillSave(1);
    }

    public void setNumberOfFeats(int level) {
        int lvl = level;
        if(level == 1) {
            this.numberOfFeats = 1;
        } else {
            if (lvl % 2 == 0 && lvl > 0){
                numberOfFeats += 1;
            }
        }
    }

    public Dice getHitDice() {
        return hitDice;
    }

    public Alignment getPreferredAlignment() {
        return preferredAlignment;
    }

    public int getSkillPoints1stLevel() {
        return skillPoints1stLevel;
    }

    public void setSkillPoints1stLevel(int IntModifier) {
        this.skillPoints1stLevel = (2 + IntModifier) * 4;
        if(skillPoints1stLevel < 4){
            this.skillPoints1stLevel = 4;
        }
    }

    public int getSkillPointsAtEachLevel() {
        return skillPointsAtEachLevel;
    }

    public void setSkillPointsAtEachLevel(int IntModifier) {
        this.skillPointsAtEachLevel = (2 + IntModifier);
        if(skillPointsAtEachLevel < 1) {
            this.skillPointsAtEachLevel = 1;
        }
    }

    public List<Skills> getClassSkills() {
        return classSkills;
    }
    public int getNumberOfFeats() {
        return numberOfFeats;
    }

    public int getBaseAttackBonus() {
        return baseAttackBonus;
    }

    public void setBaseAttackBonus(int level) {
        this.baseAttackBonus = level;
    }

    public int getFortitudeSave() {
        return FortitudeSave;
    }

    public void setFortitudeSave(int level) {
        if(level % 2 == 0 && level > 0) {
            this.FortitudeSave += 1;
        }
    }

    public int getReflexSave() {
        return ReflexSave;
    }

    public void setReflexSave(int level) {
        if(level % 3 == 0 && level > 0) {
            this.ReflexSave += 1;
        }
    }

    public int getWillSave() {
        return WillSave;
    }

    public void setWillSave(int level) {
        if(level % 3 == 0 && level > 0) {
            this.WillSave += 1;
        }
    }

    public int getSecondAttackBonus() {
        return secondAttackBonus;
    }

    public void setSecondAttackBonus(int level) {
        if(level < 6) {
            this.secondAttackBonus = 0;
        }
    }

    public int getThirdAttackBonus() {
        return thirdAttackBonus;
    }

    public void setThirdAttackBonus(int thirdAttackBonus) {
        this.thirdAttackBonus = thirdAttackBonus;
    }
}
