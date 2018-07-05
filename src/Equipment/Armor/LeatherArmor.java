package Equipment.Armor;

public class LeatherArmor extends Armor {
    ArmorTypes armorType;
    ArmorList armor;
    Integer cost;
    Integer armorBonus;
    Integer maxDexBonus;
    Integer armorCheckPenalty;
    Double arcaneSpellFailureChance;
    Double speedAdjustment;
    Integer weight;

    public LeatherArmor() {
        this.armorType = ArmorTypes.LIGHT;
        this.armor = ArmorList.LEATHER;
        this.cost = 10;
        this.armorBonus = 2;
        this.maxDexBonus = 6;
        this.armorCheckPenalty = 0;
        this.arcaneSpellFailureChance = 0.1;
        this.speedAdjustment = 100.0;
        this.weight = 15;
    }

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
