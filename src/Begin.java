import characterTraits.Classes.Classes;
import characterTraits.Gender;
import characterTraits.Race.Race;
import characterTraits.Character;
import characterTraits.Skills;

import java.util.ArrayList;


public class Begin {

    public static void main(String[] args) {
        Character Ralf = new Character(Race.HUMAN, Classes.FIGHTER, Classes.NONE, Gender.MALE);
        ArrayList<Integer> mods = Ralf.getAbilityModifiers();
        System.out.println("STR " + Ralf.getStrength() + " Mod " + Ralf.getStrengthModifier());
        System.out.println("DEX " + Ralf.getDexterity() + " Mod " + mods.get(1));
        System.out.println("CON " + Ralf.getConstitution() + " Mod " + mods.get(2));
        System.out.println("INT " + Ralf.getIntelligence() + " Mod " + mods.get(3));
        System.out.println("WIS " + Ralf.getWisdom() + " Mod " + mods.get(4));
        System.out.println("CHA " + Ralf.getCharisma() + " Mod " + mods.get(5));
        System.out.println();
        System.out.println("HP " + Ralf.getMaximumHitPoints());
        System.out.println();
        System.out.println("Fortitude Save " + Ralf.getFortitudeSavingThrow());
        System.out.println("Reflex Save " + Ralf.getReflexSavingThrow());
        System.out.println("Will Save " + Ralf.getWillSavingThrow());
        System.out.println("Base Attack Bonus " + Ralf.getBaseAttackBonus());
        System.out.println();
        System.out.println("Initiative Mod " + Ralf.getInitiative());
        // Skills
        System.out.println("Total Skill Points = " + Ralf.getSkillPoints());
        Ralf.firstTimeRankSkill(Skills.CLIMB, 3);
        Ralf.firstTimeRankSkill(Skills.CONCENTRATION, 4);
        System.out.println("Remaining Skill Points " + Ralf.getSkillPoints());
        System.out.println(Ralf.getSkillandRank(Skills.CONCENTRATION));
        System.out.println(Ralf.getSkillandRank(Skills.CLIMB));
        System.out.println(Ralf.getSkillandRank(Skills.INTIMIDATE));
        // Feats
        System.out.println("Feats = " + Ralf.getNumberOfFeats());
        // ArmorList Class
        System.out.println("Armor Class = " + Ralf.getArmorClass());
        // Equipped Weapon
        System.out.println("Equipped Weapon: " + Ralf.getEquippedWeapon());
    }

}
