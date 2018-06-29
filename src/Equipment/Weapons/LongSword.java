package Equipment.Weapons;

import characterTraits.Dice;

public class LongSword extends Weapon {
    private Integer cost = 15;
    private Dice damageDice = Dice.d8;
    private Integer weight = 4;
    private DamageType damageType = DamageType.SLASHING;
}
