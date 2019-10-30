package Equipment.Armor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LeatherArmor implements Armor {

    ArmorCategory armorType;
    ArmorList armor;
    Integer cost;
    Integer armorBonus;
    Integer maxDexBonus;
    Integer armorCheckPenalty;
    Double arcaneSpellFailureChance;
    Double speedAdjustment;
    Integer weight;

    public LeatherArmor() {
        setArmorType(ArmorCategory.LIGHT);
        setArmor(ArmorList.LEATHER);
        setCost(10);
        setArmorBonus(2);
        setMaxDexBonus(6);
        setArmorCheckPenalty(0);
        setArcaneSpellFailureChance(0.1);
        setSpeedAdjustment(100.0);
        setWeight(15);
    }

}
