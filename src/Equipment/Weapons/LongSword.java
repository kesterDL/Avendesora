package Equipment.Weapons;

import CharacterComponents.Dice;

public class LongSword extends Weapon {

    public LongSword() {
        setCost(15);
        setDamageDice(Dice.d8);
        setWeight(4);
        setDamageType(DamageType.SLASHING);
        setWeaponClass(WeaponTypes.MARTIAL);
        setWeapon(WeaponList.SWORD_LONG);
    }

    @Override
    public Integer rollDamage() {
        Integer damage = 0;
        damage = dice.nextInt(8 - 1 + 1) + 1;
        return damage;
    }

}
