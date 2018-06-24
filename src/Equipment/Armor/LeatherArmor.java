package Equipment.Armor;

public class LeatherArmor {
    ArmorTypes armorType = ArmorTypes.LIGHT;
    Integer cost = 10;
    Integer armorBonus = 2;
    Integer maxDexBonus = 6;
    Integer armorCheckPenalty = 0;
    Double arcaneSpellFailureChance = 0.1;
    Double speedAdjustment = 100.0;
    Integer weight = 15;

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
