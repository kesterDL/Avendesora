package Equipment.Armor;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LightWoodShield implements Shield {
    ShieldTypes shieldType;
    Integer cost;
    Integer armorBonus;
    Integer armorCheckPenalty;
    Double arcaneSpellFailureChance;
    Integer weight;

    public LightWoodShield() {
        this.shieldType = ShieldTypes.LIGHT_WOODEN;
        this.cost = 3;
        this.armorBonus = 1;
        this.armorCheckPenalty = -1;
        this.arcaneSpellFailureChance = 0.05;
        this.weight = 5;
    }

}
