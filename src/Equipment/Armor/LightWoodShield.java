package Equipment.Armor;

public class LightWoodShield {
    ShieldTypes shieldType = ShieldTypes.LIGHT_WOODEN;
    Integer cost = 3;
    Integer armorBonus = 1;
    Integer armorCheckPenalty = -1;
    Double arcaneSpellFailureChance = 0.05;
    Integer weight = 5;

    public ShieldTypes getShieldType() {
        return shieldType;
    }

    public Integer getCost() {
        return cost;
    }

    public Integer getArmorBonus() {
        return armorBonus;
    }

    public Integer getArmorCheckPenalty() {
        return armorCheckPenalty;
    }

    public Double getArcaneSpellFailureChance() {
        return arcaneSpellFailureChance;
    }

    public Integer getWeight() {
        return weight;
    }
}