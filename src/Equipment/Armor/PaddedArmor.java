package Equipment.Armor;

public class PaddedArmor {
    ArmorTypes armorType = ArmorTypes.LIGHT;
    Integer cost = 5;
    Integer armorBonus = 1;
    Integer maxDexBonus = 8;
    Integer armorCheckPenalty = 0;
    Double arcaneSpellFailureChance = 0.05;
    Double speedAdjustment = 100.0;
    Integer weight = 10;

    public ArmorTypes getArmorType() {
        return armorType;
    }

    public Integer getCost() {
        return cost;
    }

    public Integer getArmorBonus() {
        return armorBonus;
    }

    public Integer getMaxDexBonus() {
        return maxDexBonus;
    }

    public Integer getArmorCheckPenalty() {
        return armorCheckPenalty;
    }

    public Double getArcaneSpellFailureChance() {
        return arcaneSpellFailureChance;
    }

    public Double getSpeedAdjustment() {
        return speedAdjustment;
    }

    public Integer getWeight() {
        return weight;
    }
}
