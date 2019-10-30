package Equipment.Armor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShieldBuckler implements Shield{
    ShieldTypes shieldType;
    Integer cost;
    Integer armorBonus;
    Integer armorCheckPenalty;
    Double arcaneSpellFailureChance;
    Integer weight;

    public ShieldBuckler() {
        this.shieldType = ShieldTypes.BUCKLER;
        this.cost = 15;
        this.armorBonus = 1;
        this.armorCheckPenalty = -1;
        this.arcaneSpellFailureChance = 0.05;
        this.weight = 5;
    }

}
