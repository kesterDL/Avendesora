
import Equipment.Armor.ArmorList;
import Equipment.Weapons.WeaponList;
import characterTraits.Classes.Classes;
import characterTraits.Feats.Feats;
import characterTraits.Gender;
import characterTraits.Race.RaceChoice;
import characterTraits.Character;
import characterTraits.Skills;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.*;


public class Begin extends javax.swing.JFrame  {

    public static void main(String[] args) {
        Character Ralf = new Character(RaceChoice.HUMAN, Classes.FIGHTER, Classes.NONE, Gender.MALE);
        Ralf.setCharacterName("Ralf");
//        ArrayList<Integer> mods = Ralf.getAbilityModifiers();
//        for(int i = 0; i < 5; i++) {
//            System.out.println();
//        }
//        System.out.println("STR " + Ralf.getStrength() + " Mod " + Ralf.getStrengthModifier());
//        System.out.println("DEX " + Ralf.getDexterity() + " Mod " + mods.get(1));
//        System.out.println("CON " + Ralf.getConstitution() + " Mod " + mods.get(2));
//        System.out.println("INT " + Ralf.getIntelligence() + " Mod " + mods.get(3));
//        System.out.println("WIS " + Ralf.getWisdom() + " Mod " + mods.get(4));
//        System.out.println("CHA " + Ralf.getCharisma() + " Mod " + mods.get(5));
//        System.out.println();
//        System.out.println("HP " + Ralf.getMaximumHitPoints());
//        System.out.println();
//        System.out.println("Fortitude Save " + Ralf.getFortitudeSavingThrow());
//        System.out.println("Reflex Save " + Ralf.getReflexSavingThrow());
//        System.out.println("Will Save " + Ralf.getWillSavingThrow());
//        System.out.println("Base Attack Bonus " + Ralf.getBaseAttackBonus());
//        System.out.println();
//        System.out.println("Initiative Mod " + Ralf.getInitiative());
//        // Skills
//        System.out.println("Total Skill Points = " + Ralf.getSkillPoints());
//        Ralf.firstTimeRankSkill(Skills.CLIMB, 3);
//        Ralf.firstTimeRankSkill(Skills.CONCENTRATION, 4);
//        System.out.println("Remaining Skill Points " + Ralf.getSkillPoints());
//        System.out.println(Ralf.getSkillandRank(Skills.CONCENTRATION));
//        System.out.println(Ralf.getSkillandRank(Skills.CLIMB));
//        System.out.println(Ralf.getSkillandRank(Skills.INTIMIDATE));
//        // Feats
//        System.out.println("Unallocated Feats = " + Ralf.getNumberOfFeats());
//        ArrayList<Feats> feats = Ralf.getFeats();
//        for (Feats feat : feats) {
//            System.out.println("Feat: " + feat);
//        }
//        // ArmorList JobClass
//        System.out.println("Armor Class = " + Ralf.getArmorClass());
//        // Equipped Weapon
//        System.out.println("Equipped Weapon: " + Ralf.getEquippedWeapon());

        CreationWindow window = new CreationWindow(Ralf);
        window.setVisible(true);
    }

    public static class CreationWindow extends JFrame {

        JComboBox<Integer> stats;
        JComboBox<String> armors;
        JComboBox<String> weapons;
        Character character;
        private javax.swing.JButton jButton1;
        private javax.swing.JButton jButton2;
        private javax.swing.JComboBox<String> jComboBox1;
        private javax.swing.JComboBox<String> jComboBox2;
        private javax.swing.JComboBox<String> jComboBox3;
        private javax.swing.JComboBox<String> jComboBox4;
        private javax.swing.JComboBox<String> jComboBox5;
        private javax.swing.JComboBox<String> jComboBox6;
        private javax.swing.JComboBox<String> jComboBox7;
        private javax.swing.JComboBox<String> jComboBox8;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel11;
        private javax.swing.JLabel jLabel12;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JLabel jLabel7;
        private javax.swing.JLabel jLabel8;
        private javax.swing.JLabel jLabel9;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JPanel jPanel3;
        private javax.swing.JPanel jPanel4;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane10;
        private javax.swing.JScrollPane jScrollPane3;
        private javax.swing.JScrollPane jScrollPane4;
        private javax.swing.JScrollPane jScrollPane5;
        private javax.swing.JScrollPane jScrollPane6;
        private javax.swing.JScrollPane jScrollPane7;
        private javax.swing.JScrollPane jScrollPane8;
        private javax.swing.JScrollPane jScrollPane9;
        private javax.swing.JSeparator jSeparator1;
        private javax.swing.JTextPane jTextPane1;
        private javax.swing.JTextPane jTextPane10;
        private javax.swing.JTextPane jTextPane3;
        private javax.swing.JTextPane jTextPane4;
        private javax.swing.JTextPane jTextPane5;
        private javax.swing.JTextPane jTextPane6;
        private javax.swing.JTextPane jTextPane7;
        private javax.swing.JTextPane jTextPane8;
        private javax.swing.JTextPane jTextPane9;

        public CreationWindow(Character character) {
            this.character = character;
            Integer[] scores = {character.getStrength(),character.getDexterity(), character.getConstitution(),
                     character.getIntelligence(), character.getWisdom(), character.getCharisma()};
            String[] armor = {ArmorList.PADDED.toString(), ArmorList.LEATHER.toString(), ArmorList.STUDDED_LEATHER.toString(), ArmorList.CHAIN_SHIRT.toString()};
            String[] weapon = {WeaponList.SWORD_LONG.toString(),WeaponList.BOW_LONG.toString(), WeaponList.WARHAMMER.toString()};
            stats = new JComboBox<>(scores);
            armors = new JComboBox<>(armor);
            weapons = new JComboBox<>(weapon);
            createGUI();
        }

        public void createGUI() {

            jPanel2 = new javax.swing.JPanel();
            jLabel2 = new javax.swing.JLabel();
            jLabel3 = new javax.swing.JLabel();
            jLabel4 = new javax.swing.JLabel();
            jLabel5 = new javax.swing.JLabel();
            jLabel6 = new javax.swing.JLabel();
            jLabel7 = new javax.swing.JLabel();
            jComboBox1 = new javax.swing.JComboBox<>();
            jComboBox2 = new javax.swing.JComboBox<>();
            jComboBox3 = new javax.swing.JComboBox<>();
            jComboBox4 = new javax.swing.JComboBox<>();
            jComboBox5 = new javax.swing.JComboBox<>();
            jComboBox6 = new javax.swing.JComboBox<>();
            jButton1 = new javax.swing.JButton();
            jButton2 = new javax.swing.JButton();
            jScrollPane5 = new javax.swing.JScrollPane();
            jTextPane5 = new javax.swing.JTextPane();
            jScrollPane6 = new javax.swing.JScrollPane();
            jTextPane6 = new javax.swing.JTextPane();
            jScrollPane7 = new javax.swing.JScrollPane();
            jTextPane7 = new javax.swing.JTextPane();
            jScrollPane8 = new javax.swing.JScrollPane();
            jTextPane8 = new javax.swing.JTextPane();
            jScrollPane9 = new javax.swing.JScrollPane();
            jTextPane9 = new javax.swing.JTextPane();
            jScrollPane10 = new javax.swing.JScrollPane();
            jTextPane10 = new javax.swing.JTextPane();
            jPanel3 = new javax.swing.JPanel();
            jComboBox7 = new javax.swing.JComboBox<>();
            jLabel1 = new javax.swing.JLabel();
            jLabel8 = new javax.swing.JLabel();
            jComboBox8 = new javax.swing.JComboBox<>();
            jPanel4 = new javax.swing.JPanel();
            jLabel9 = new javax.swing.JLabel();
            jLabel11 = new javax.swing.JLabel();
            jLabel12 = new javax.swing.JLabel();
            jScrollPane1 = new javax.swing.JScrollPane();
            jTextPane1 = new javax.swing.JTextPane();
            jScrollPane3 = new javax.swing.JScrollPane();
            jTextPane3 = new javax.swing.JTextPane();
            jScrollPane4 = new javax.swing.JScrollPane();
            jTextPane4 = new javax.swing.JTextPane();
            jSeparator1 = new javax.swing.JSeparator();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setBackground(new java.awt.Color(0, 0, 0));

            jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Base Stats", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Apple Chancery", 0, 13))); // NOI18N

            jLabel2.setFont(new java.awt.Font("Luminari", 0, 13)); // NOI18N
            jLabel2.setText("Strength");

            jLabel3.setFont(new java.awt.Font("Luminari", 0, 13)); // NOI18N
            jLabel3.setText("Dexterity");

            jLabel4.setFont(new java.awt.Font("Luminari", 0, 13)); // NOI18N
            jLabel4.setText("Constitution");

            jLabel5.setFont(new java.awt.Font("Luminari", 0, 13)); // NOI18N
            jLabel5.setText("Intelligence");

            jLabel6.setFont(new java.awt.Font("Luminari", 0, 13)); // NOI18N
            jLabel6.setText("Wisdom");

            jLabel7.setFont(new java.awt.Font("Luminari", 0, 13)); // NOI18N
            jLabel7.setText("Charisma");

            jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

            jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

            jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

            jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

            jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

            jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

            jButton1.setFont(new java.awt.Font("Luminari", 1, 13)); // NOI18N
            jButton1.setText("ReRoll Stats");

            jButton2.setBackground(new java.awt.Color(0, 153, 153));
            jButton2.setFont(new java.awt.Font("Luminari", 1, 13)); // NOI18N
            jButton2.setForeground(new java.awt.Color(102, 102, 255));
            jButton2.setText("Save");
            jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

            jTextPane5.setEditable(false);
            jScrollPane5.setViewportView(jTextPane5);

            jTextPane6.setEditable(false);
            jScrollPane6.setViewportView(jTextPane6);

            jTextPane7.setEditable(false);
            jScrollPane7.setViewportView(jTextPane7);

            jTextPane8.setEditable(false);
            jScrollPane8.setViewportView(jTextPane8);

            jTextPane9.setEditable(false);
            jScrollPane9.setViewportView(jTextPane9);

            jTextPane10.setEditable(false);
            jScrollPane10.setViewportView(jTextPane10);

            javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
            jPanel2.setLayout(jPanel2Layout);
            jPanel2Layout.setHorizontalGroup(
                    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addGap(29, 29, 29)
                                                    .addComponent(jLabel2)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addContainerGap()
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addComponent(jLabel4)
                                                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                                                            .addComponent(jLabel3))
                                                    .addGap(18, 18, 18)
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGap(18, 18, 18)
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addContainerGap(29, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
            );
            jPanel2Layout.setVerticalGroup(
                    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel2)
                                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGap(5, 5, 5)
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(jLabel4)
                                                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGap(5, 5, 5)
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(jLabel5)
                                                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(jLabel6)
                                                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGap(5, 5, 5)
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(jLabel7)
                                                            .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton1)))
            );

            jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Weapons and Armor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Apple Chancery", 0, 13))); // NOI18N

            jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

            jLabel1.setText("Equipped Armor");

            jLabel8.setText("Equipped Weapon");

            jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

            javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
            jPanel3.setLayout(jPanel3Layout);
            jPanel3Layout.setHorizontalGroup(
                    jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBox8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBox7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addContainerGap())
            );
            jPanel3Layout.setVerticalGroup(
                    jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(16, 16, 16)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel1))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8))
                                    .addContainerGap(31, Short.MAX_VALUE))
            );

            jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

            jLabel9.setText("Max Hit Points");

            jLabel11.setText("Armor Class");

            jLabel12.setText("Flat footed");

            jTextPane1.setEditable(false);
            jScrollPane1.setViewportView(jTextPane1);

            jTextPane3.setEditable(false);
            jScrollPane3.setViewportView(jTextPane3);

            jTextPane4.setEditable(false);
            jScrollPane4.setViewportView(jTextPane4);

            javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
            jPanel4.setLayout(jPanel4Layout);
            jPanel4Layout.setHorizontalGroup(
                    jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGap(14, 14, 14)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                    .addComponent(jLabel9)
                                                    .addGap(27, 27, 27)
                                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                    .addComponent(jLabel11)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jLabel12)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addContainerGap(10, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jSeparator1)
                                    .addContainerGap())
            );
            jPanel4Layout.setVerticalGroup(
                    jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel12)
                                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(92, 92, 92)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(148, Short.MAX_VALUE))
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(12, 12, 12))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addGap(5, 5, 5)
                                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addContainerGap()
                                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(18, 18, 18)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(191, 191, 191))
            );

            pack();

        }

        class addInterestListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent event) {
                character.setCharacterName("DooBap");
            }
        }

    }

}
