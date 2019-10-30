package Equipment.Armor;

public enum ArmorCategory {
    HEAVY("Heavy Armor"),
    MEDIUM("Medium Armor"),
    LIGHT("Light Armor"),
    ALL("All Armor");

    String category;

    ArmorCategory(String armorCategory) {
        this.category = armorCategory;
    }

}
