package CharacterComponents.Creation;

import CharacterComponents.BaseAbilities;
import CharacterComponents.Dice;
import com.sun.istack.internal.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenerateCharacterStats {
    /**
     * Map of abilityScores and their score.
     */
    private Map<BaseAbilities, Integer> abilityScores;
    /**
     * Map of scores and their modifiers.
     */
    private Map<Integer, Integer> abilityModifiers;

    /**
     * Determines what the modifier would be for any given ability score.
     * @param abilityScore integer
     * @return modifier for a given ability score
     */
    private Integer calculateModifier(Integer abilityScore) {
        int modifier;
        if(abilityScore%2 != 0) {
            modifier = -6;
        } else {
            modifier = -5;
        }
        while(abilityScore > 0){
            abilityScore--;
            if(abilityScore%2 == 0) {
                modifier++;
            }
        }
        return modifier;
    }

    private int sumOfRollsMinusMin(@NotNull ArrayList<Integer> list) {
        int min = list.get(0);
        int minIndex = 0;
        int sum = 0;
        for(int i = 0; i < list.size() - 1; i++) {
            if (list.get(i+1) < min) {
                min = list.get(i+1);
                minIndex = i;
            }
        }
        list.remove(minIndex);
        for(Integer num: list) {
            sum += num;
        }
        return sum;
    }

    /**
     * Rolls 4 dice, then discards the lowest roll and sums the remaining 3 rolls.
     * @return Sum of 3 highest of 4 dice rolls.
     */
    public Integer rollAnAbilityStat() {
        ArrayList<Integer> rolls = new ArrayList<>();
        for(int j = 0; j < 4; j++){
            rolls.add(Dice.rollAD6());
        }
        return sumOfRollsMinusMin(rolls);
    }

    private Map<BaseAbilities, Integer> createEmptyBaseAbilityMap() {
        abilityScores = new HashMap<>();
        abilityScores.put(BaseAbilities.STRENGTH, null);
        abilityScores.put(BaseAbilities.DEXTERITY, null);
        abilityScores.put(BaseAbilities.CONSTITUTION, null);
        abilityScores.put(BaseAbilities.INTELLIGENCE, null);
        abilityScores.put(BaseAbilities.WISDOM, null);
        abilityScores.put(BaseAbilities.CHARISMA, null);

        return abilityScores;
    }

    /**
     * Generates a list of all possible ability scores, to the corresponding modifier.
     * @return Map of ability scores and modifiers.
     */
    private Map<Integer, Integer> createModifierMap() {
        abilityModifiers = new HashMap<>();

        for (int i = 0; i < 25; i++) {
            abilityModifiers.put(i, calculateModifier(i));
        }

        return abilityModifiers;
    }

    private LinkedList<Integer> rollStatsForCreation() {
        LinkedList<Integer> abilityRolls = new LinkedList<>();
        // Roll the all the scores and save them in a list
        for(int i = 0; i < 6; i++){
            abilityRolls.add(rollAnAbilityStat());
        }

        return abilityRolls;
    }

    private void printOutRollsForCreation(LinkedList<Integer> abilityRolls) {
        // Print all the scores to the user
        for(int i = 0; i < abilityRolls.size(); i++) {
            if ( i == abilityRolls.size()-1){
                System.out.print(abilityRolls.get(i));
            } else {
                System.out.print(abilityRolls.get(i) + ", ");
            }
        }
        System.out.println();
    }

    public void printOutCharacterAbilityStats() {
        if (abilityScores.isEmpty()) {
            throw new NullPointerException("ability Scores has not been instantiated.");
        }
        Iterator abilities = abilityScores.entrySet().iterator();
        while (abilities.hasNext()) {
            Map.Entry keyPair = (Map.Entry)abilities.next();
            System.out.println(keyPair.getKey() + ": " + keyPair.getValue());
        }
    }

    public void userSelectAbilityStats() {
        // Roll the all the scores and save them in a list
        LinkedList<Integer> abilityRolls = rollStatsForCreation();
        // Ask user to choose each stat from the list
        for (BaseAbilities ability: abilityScores.keySet()) {
            printOutRollsForCreation(abilityRolls);
            userSelectAbility(ability, abilityRolls);
        }
        printOutCharacterAbilityStats();
    }

    public void generateRandomCharacterStats() {
        LinkedList<Integer> abilityRolls = rollStatsForCreation();
        createEmptyBaseAbilityMap();
        for (BaseAbilities ability: abilityScores.keySet()) {
            abilityScores.put(ability, abilityRolls.pop());
        }
        abilityModifiers = createModifierMap();
    }

    private void userSelectAbility(final BaseAbilities ability, final LinkedList<Integer> abilityRolls) {
        Scanner user_input = new Scanner(System.in);
        String selection;
        Integer intSelection = 0;
        Boolean validSelection = false;

        while(!validSelection) {
            System.out.print("Select an ability score for " + ability.toString() + ": ");
            selection = user_input.next();
            intSelection = Integer.parseInt(selection);
            // Accept input and assign the stat
            if(!abilityRolls.contains(intSelection)) {
                System.out.println("Select a score from the list of available stats");
                printOutRollsForCreation(abilityRolls);
            } else {
                // Remove ability from list
                validSelection = true;
                switch(ability){
                    case STRENGTH:
                        abilityScores.put(BaseAbilities.STRENGTH, intSelection);
                        break;
                    case DEXTERITY:
                        abilityScores.put(BaseAbilities.DEXTERITY,intSelection);
                        break;
                    case CONSTITUTION:
                        abilityScores.put(BaseAbilities.CONSTITUTION, intSelection);
                        break;
                    case INTELLIGENCE:
                        abilityScores.put(BaseAbilities.INTELLIGENCE, intSelection);
                        break;
                    case WISDOM:
                        abilityScores.put(BaseAbilities.WISDOM, intSelection);
                        break;
                    case CHARISMA:
                        abilityScores.put(BaseAbilities.CHARISMA, intSelection);
                        break;
                }
                abilityRolls.remove(intSelection);
                System.out.println("Character's " + ability.toString() + " is: " + selection);
            }
        }
    }

}
