package characterTraits;

import java.util.Random;

public enum Dice {
    d2,
    d4,
    d6,
    d8,
    d10,
    d12,
    d20,
    d100;

    // Dice
    private static Random dice = new Random();

    public static Integer rollAD6() {
        return dice.nextInt(6 - 1 + 1) + 1;
    }

    public static Integer rollAD20() {
        return dice.nextInt(20 - 1 + 1) + 1;
    }

    public static Integer rollAD12() {
        return dice.nextInt(12 - 1 + 1) + 1;
    }

    public static Integer rollAD10() {
        return dice.nextInt(10 - 1 + 1) + 1;
    }

    public static Integer rollAD8() {
        return dice.nextInt(8 - 1 + 1) + 1;
    }

    public static Integer rollAD4() {
        return dice.nextInt(4 - 1 + 1) + 1;
    }

}
