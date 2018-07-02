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

    @Override
    public ArmorTypes getArmorType() {
        return armorType;
    }

    @Override
    public Integer getCost() {
        return gold;
    }

    @Override
    public Integer getArmorBonus() {
        return armorBonus;
    }

    @Override
    public Integer getMaxDexBonus() {
        return maxDexBonus;
    }

    @Override
    public Integer getArmorCheckPenalty() {
        return armorCheckPenalty;
    }

    @Override
    public Double getArcaneSpellFailureChance() {
        return arcaneSpellFailureChance;
    }

    @Override
    public Double getSpeedAdjustment() {
        return speedAdjustment;
    }

    @Override
    public Integer getWeight() {
        return weight;
    }
}
