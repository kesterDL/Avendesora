package Equipment.Armor;

public class ShieldBuckler extends Shield{
    ShieldTypes shieldType;
    Integer gold;
    Integer armorBonus;
    Integer armorCheckPenalty;
    Double arcaneSpellFailureChance;
    Integer weight;

    public ShieldBuckler() {
        this.shieldType = ShieldTypes.BUCKLER;
        this.gold = 15;
        this.armorBonus = 1;
        this.armorCheckPenalty = -1;
        this.arcaneSpellFailureChance = 0.05;
        this.weight = 5;
    }

    @Override
    public ShieldTypes getShieldType() {
        return shieldType;
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
    public Integer getArmorCheckPenalty() {
        return armorCheckPenalty;
    }

    @Override
    public Double getArcaneSpellFailureChance() {
        return arcaneSpellFailureChance;
    }

    @Override
    public Integer getWeight() {
        return weight;
    }
}
