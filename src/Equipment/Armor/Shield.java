package Equipment.Armor;

public class Shield {
    ShieldTypes shieldType;
    Integer gold;
    Integer armorBonus;
    Integer armorCheckPenalty;
    Double arcaneSpellFailureChance;
    Integer weight;

    public ShieldTypes getShieldType() {
        return shieldType;
    }

    public void setShieldType(ShieldTypes shieldType) {
        this.shieldType = shieldType;
    }

    public Integer getCost() {
        return gold;
    }

    public void setCost(Integer gold) {
        this.gold = gold;
    }

    public Integer getArmorBonus() {
        return armorBonus;
    }

    public void setArmorBonus(Integer armorBonus) {
        this.armorBonus = armorBonus;
    }

    public Integer getArmorCheckPenalty() {
        return armorCheckPenalty;
    }

    public void setArmorCheckPenalty(Integer armorCheckPenalty) {
        this.armorCheckPenalty = armorCheckPenalty;
    }

    public Double getArcaneSpellFailureChance() {
        return arcaneSpellFailureChance;
    }

    public void setArcaneSpellFailureChance(Double arcaneSpellFailureChance) {
        this.arcaneSpellFailureChance = arcaneSpellFailureChance;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
