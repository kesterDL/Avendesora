package Equipment.Armor;

public class LeatherArmor extends Armor {

    public LeatherArmor() {
        setArmorType(ArmorTypes.LIGHT);
        setArmor(ArmorList.LEATHER);
        setGoldCost(10);
        setArmorBonus(2);
        setMaxDexBonus(6);
        setArmorCheckPenalty(0);
        setArcaneSpellFailureChance(0.1);
        setSpeedAdjustment(100.0);
        setWeight(15);
    }

}
