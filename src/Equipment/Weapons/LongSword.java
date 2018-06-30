package Equipment.Weapons;

import characterTraits.Dice;

public class LongSword extends Weapon {
    private Integer cost = 15;
    private Dice damageDice = Dice.d8;
    private Integer weight = 4;
    private DamageType damageType = DamageType.SLASHING;
    private WeaponTypes weaponClass = WeaponTypes.MARTIAL;
    private WeaponList weapon = WeaponList.SWORD_LONG;

    @Override
    public WeaponTypes getWeaponClass() {
        return weaponClass;
    }

    @Override
    public Integer getCost() {
        return cost;
    }

    @Override
    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Override
    public Dice getDamageDice() {
        return damageDice;
    }

    @Override
    public void setDamageDice(Dice damageDice) {
        this.damageDice = damageDice;
    }

    @Override
    public Integer getWeight() {
        return weight;
    }

    @Override
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public DamageType getDamageType() {
        return damageType;
    }

    @Override
    public void setDamageType(DamageType damageType) {
        this.damageType = damageType;
    }

    @Override
    public void setWeaponClass(WeaponTypes weaponClass) {
        this.weaponClass = weaponClass;
    }

    @Override
    public WeaponList getWeapon() {
        return weapon;
    }

    @Override
    public void setWeapon(WeaponList weapon) {
        this.weapon = weapon;
    }
}
