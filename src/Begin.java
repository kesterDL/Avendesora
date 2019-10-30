
import Equipment.Armor.ArmorList;
import Equipment.Weapons.WeaponList;
import SpellBook.SpellCompendium;
import SpellBook.SpellsAPI;
import CharacterComponents.Classes.Classes;
import CharacterComponents.Feats.Feats;
import CharacterComponents.Race.RaceChoice;
import CharacterComponents.Character;
import CharacterComponents.Skills;
import org.json.JSONException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;


public class Begin {

    public static void main(String[] args) {
        Character Loeb = new Character(RaceChoice.HUMAN, Classes.FIGHTER);
        Loeb.setCharacterName("Loeb");

        Loeb.firstTimeRankSkill(Skills.CLIMB, 3);
        Loeb.firstTimeRankSkill(Skills.CONCENTRATION, 4);

        ArrayList<Feats> feats = Loeb.getCharacterFeats();
        for (Feats feat : feats) {
            System.out.println("Feat: " + feat);
        }
    }

}
