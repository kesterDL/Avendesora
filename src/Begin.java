
import characterTraits.Classes.Classes;
import characterTraits.Feats.Feats;
import characterTraits.Gender;
import characterTraits.Race.RaceChoice;
import characterTraits.Character;
import characterTraits.Skills;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


public class Begin {

    public static void main(String[] args) {
        Character Ralf = new Character(RaceChoice.HUMAN, Classes.FIGHTER, Classes.NONE, Gender.MALE);
        ArrayList<Integer> mods = Ralf.getAbilityModifiers();
        for(int i = 0; i < 5; i++) {
            System.out.println();
        }
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
        System.out.println("Unallocated Feats = " + Ralf.getNumberOfFeats());
        ArrayList<Feats> feats = Ralf.getFeats();
        for (Feats feat : feats) {
            System.out.println("Feat: " + feat);
        }
        // ArmorList JobClass
        System.out.println("Armor Class = " + Ralf.getArmorClass());
        // Equipped Weapon
        System.out.println("Equipped Weapon: " + Ralf.getEquippedWeapon());

        CreationWindow window = new CreationWindow(Ralf);
    }

    public static class CreationWindow extends JFrame {
        JFrame frame = new JFrame();
        JLabel resultLabel;
        JButton button;
        ArrayList<Integer> stats;
        Character character;

        public CreationWindow(Character character) {
            this.character = character;
            // TODO: create a list to list out all the stats.
            // TODO: character.getStats() is an empty list due to "private void setAbility(BaseAbilities ability)"
            createGUI();
        }

        public void createGUI() {

            button = new JButton("Click");
            ActionListener listener = new addInterestListener();
            button.addActionListener(listener);

            resultLabel = new JLabel(stats.toString());

            JPanel panel_1 = new JPanel();
            JPanel panel_2 = new JPanel();
            panel_1.add(button);
            panel_1.add(resultLabel);
            frame.add(panel_1);

            frame.setSize(500, 100);
            frame.setTitle("Character Stats");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setVisible(true);
        }

        class addInterestListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent event) {
                resultLabel.setText("ReRolling Stats");
            }
        }

    }

}
