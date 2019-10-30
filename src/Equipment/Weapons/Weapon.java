package Equipment.Weapons;

import CharacterComponents.Dice;

import java.util.Random;

public class Weapon {
    private Integer cost;
    private Dice damageDice;
    private Integer weight;
    private DamageType damageType;
    private WeaponTypes weaponClass;
    private WeaponList weapon;
    Random dice = new Random();

    public Integer critical(Boolean crit){
        Integer damage = 0;
        if (crit){
            damage = rollDamage()*2;
        }
        return damage;
    }

    public Integer rollDamage(){
        Integer damage = 0;
        switch (damageDice){
            case d2:
                damage = dice.nextInt(2 - 1 + 1) + 1;
                break;
            case d4:
                damage = dice.nextInt(4 - 1 + 1) + 1;
                break;
            case d6:
                damage = dice.nextInt(6 - 1 + 1) + 1;
                break;
            case d8:
                damage = dice.nextInt(8 - 1 + 1) + 1;
                break;
            case d10:
                damage = dice.nextInt(10 - 1 + 1) + 1;
                break;
            case d20:
                damage = dice.nextInt(20 - 1 + 1) + 1;
                break;
            case d100:
                damage = dice.nextInt(100 - 1 + 1) + 1;
                break;
        }
        return damage;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Dice getDamageDice() {
        return damageDice;
    }

    public void setDamageDice(Dice damageDice) {
        this.damageDice = damageDice;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public DamageType getDamageType() {
        return damageType;
    }

    public void setDamageType(DamageType damageType) {
        this.damageType = damageType;
    }

    public WeaponTypes getWeaponClass() {
        return weaponClass;
    }

    public void setWeaponClass(WeaponTypes weaponClass) {
        this.weaponClass = weaponClass;
    }


    public WeaponList getWeapon() {
        return weapon;
    }

    public void setWeapon(WeaponList weapon) {
        this.weapon = weapon;
    }
}
