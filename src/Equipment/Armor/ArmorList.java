package Equipment.Armor;

public enum ArmorList {
    PADDED("Padded"),
    LEATHER("Leather"),
    STUDDED_LEATHER("Studded Leather"),
    CHAIN_SHIRT("Chain Shirt");

    String armor;

    ArmorList(String str){
        this.armor = str;
    }
}
