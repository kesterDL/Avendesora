package Equipment.Armor;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public interface Armor {

     ArmorCategory getArmorType();

     Integer getCost();

     Integer getArmorBonus();

     Integer getMaxDexBonus();

     Integer getArmorCheckPenalty();

     Double getArcaneSpellFailureChance();

     Double getSpeedAdjustment();

     Integer getWeight();

     void setArmorType(ArmorCategory armorType);

     void setCost(Integer cost);

     void setArmorBonus(Integer armorBonus);

     void setMaxDexBonus(Integer maxDexBonus);

     void setArmorCheckPenalty(Integer armorCheckPenalty);

     void setArcaneSpellFailureChance(Double arcaneSpellFailureChance);

     void setSpeedAdjustment(Double speedAdjustment);

     void setWeight(Integer weight);

     ArmorList getArmor();

     void setArmor(ArmorList armor);

     static Armor armorFactory(ArmorList armor) {
         switch(armor) {
             case LEATHER:
                 return new LeatherArmor();
             case PADDED:
                 return new PaddedArmor();
             default:
                 throw new NotImplementedException();
         }
     }
}
