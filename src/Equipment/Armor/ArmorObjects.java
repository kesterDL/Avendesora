package Equipment.Armor;

public class ArmorObjects {
    /**
     * Leather Armor.
     */
    LeatherArmor leatherArmor = new LeatherArmor();
    /**
     * Padded Armor.
     */
    PaddedArmor paddedArmor = new PaddedArmor();

    public LeatherArmor getLeatherArmor() {
        return leatherArmor;
    }

    public PaddedArmor getPaddedArmor() {
        return paddedArmor;
    }
}
