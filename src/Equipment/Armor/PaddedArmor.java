package Equipment.Armor;

public class PaddedArmor extends Armor{
    ArmorTypes armorType ;
    Integer gold;
    Integer armorBonus;
    Integer maxDexBonus;
    Integer armorCheckPenalty;
    Double arcaneSpellFailureChance;
    Double speedAdjustment;
    Integer weight;

    public PaddedArmor() {
        armorType = ArmorTypes.LIGHT;
        gold = 5;
        armorBonus = 1;
        maxDexBonus = 8;
        armorCheckPenalty = 0;
        arcaneSpellFailureChance = 0.05;
        speedAdjustment = 100.0;
        weight = 10;
    }
}
