package Equipment.Armor;

public enum ShieldTypes {
    TOWER("Tower Shield"),
    HEAVY_WOODEN("Heavy Wooden Shield"),
    HEAVY_STEEL("Heavy Steel Shield"),
    LIGHT_WOODEN("Light Wooden Shield"),
    LIGHT_STEEL("Light Steel Shield"),
    BUCKLER("Buckler"),
    NONE("No Shield"),
    ALL("All Shields");

    String shield;

    ShieldTypes(String shield) {
        this.shield = shield;
    }
}
