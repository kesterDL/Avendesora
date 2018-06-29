package Equipment.Armor;

public class ArmorObjects {
    /**
     * Leather ArmorList.
     */
    LeatherArmor leatherArmor = new LeatherArmor();
    /**
     * Padded ArmorList.
     */
    PaddedArmor paddedArmor = new PaddedArmor();

    public LeatherArmor getLeatherArmor() {
        return leatherArmor;
    }

    public PaddedArmor getPaddedArmor() {
        return paddedArmor;
    }
}
