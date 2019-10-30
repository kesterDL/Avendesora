package Equipment.Armor;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public interface Shield {

     ShieldTypes getShieldType();

     void setShieldType(ShieldTypes shieldType);

     Integer getCost();

     void setCost(Integer gold);

     Integer getArmorBonus();

     void setArmorBonus(Integer armorBonus);

     Integer getArmorCheckPenalty();

     void setArmorCheckPenalty(Integer armorCheckPenalty);

     Double getArcaneSpellFailureChance();

     void setArcaneSpellFailureChance(Double arcaneSpellFailureChance);

     Integer getWeight();

     void setWeight(Integer weight);

     static Shield shieldFactory(ShieldTypes shield) {
         switch(shield) {
             case BUCKLER:
                 return new ShieldBuckler();
             case LIGHT_WOODEN:
                 return new LightWoodShield();
             default:
                 throw new NotImplementedException();
         }
     }
}
