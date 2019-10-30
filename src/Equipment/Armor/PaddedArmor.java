package Equipment.Armor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaddedArmor implements Armor {

    ArmorCategory armorType;
    ArmorList armor;
    Integer cost;
    Integer armorBonus;
    Integer maxDexBonus;
    Integer armorCheckPenalty;
    Double arcaneSpellFailureChance;
    Double speedAdjustment;
    Integer weight;

    public PaddedArmor() {

        setArmorType(ArmorCategory.LIGHT);
        setArmor(ArmorList.PADDED);
        setCost(5);
        setArmorBonus(1);
        setMaxDexBonus(8);
        setArmorCheckPenalty(0);
        setArcaneSpellFailureChance(0.05);
        setSpeedAdjustment(100.0);
        setWeight(10);
    }

}
