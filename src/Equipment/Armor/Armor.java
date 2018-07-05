package Equipment.Armor;

public class Armor {
    private ArmorTypes armorType;
    private ArmorList armor;
    private Integer gold;
    private Integer armorBonus;
    private Integer maxDexBonus;
    private Integer armorCheckPenalty;
    private Double arcaneSpellFailureChance;
    private Double speedAdjustment;
    private Integer weight;

    public ArmorTypes getArmorType() {
        return armorType;
    }

    public Integer getCost() {
        return gold;
    }

    public Integer getArmorBonus() {
        return armorBonus;
    }

    public Integer getMaxDexBonus() {
        return maxDexBonus;
    }

    public Integer getArmorCheckPenalty() {
        return armorCheckPenalty;
    }

    public Double getArcaneSpellFailureChance() {
        return arcaneSpellFailureChance;
    }

    public Double getSpeedAdjustment() {
        return speedAdjustment;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setArmorType(ArmorTypes armorType) {
        this.armorType = armorType;
    }

    public void setGoldCost(Integer cost) {
        this.gold = cost;
    }

    public void setArmorBonus(Integer armorBonus) {
        this.armorBonus = armorBonus;
    }

    public void setMaxDexBonus(Integer maxDexBonus) {
        this.maxDexBonus = maxDexBonus;
    }

    public void setArmorCheckPenalty(Integer armorCheckPenalty) {
        this.armorCheckPenalty = armorCheckPenalty;
    }

    public void setArcaneSpellFailureChance(Double arcaneSpellFailureChance) {
        this.arcaneSpellFailureChance = arcaneSpellFailureChance;
    }

    public void setSpeedAdjustment(Double speedAdjustment) {
        this.speedAdjustment = speedAdjustment;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public ArmorList getArmor() {
        return armor;
    }

    public void setArmor(ArmorList armor) {
        this.armor = armor;
    }
}
