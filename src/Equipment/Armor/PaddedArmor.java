package Equipment.Armor;

public class PaddedArmor extends Armor{

    public PaddedArmor() {

        setArmorType(ArmorTypes.LIGHT);
        setArmor(ArmorList.PADDED);
        setGoldCost(5);
        setArmorBonus(1);
        setMaxDexBonus(8);
        setArmorCheckPenalty(0);
        setArcaneSpellFailureChance(0.05);
        setSpeedAdjustment(100.0);
        setWeight(10);
    }

}
