package Equipment.Armor;

public class LeatherArmor extends Armor {
    ArmorTypes armorType = ArmorTypes.LIGHT;
    Integer cost = 10;
    Integer armorBonus = 2;
    Integer maxDexBonus = 6;
    Integer armorCheckPenalty = 0;
    Double arcaneSpellFailureChance = 0.1;
    Double speedAdjustment = 100.0;
    Integer weight = 15;

    @Override
    public ArmorTypes getArmorType() {
        return armorType;
    }

    @Override
    public Integer getCost() {
        return cost;
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
