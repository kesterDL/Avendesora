package CharacterComponents.Race;

import CharacterComponents.Sizes;
import java.security.InvalidParameterException;

public enum RaceChoice {
    /**
     * Elven.
     */
    ELVEN,

    /**
     * Half Elven.
     */
    HALF_ELVEN,

    /**
     * Human.
     */
    HUMAN,

    /**
     * Dwaven.
     */
    DWARF,

    /**
     * Half Orc.
     */
    HALF_ORC,

    /**
     * Gnome.
     */
    GNOME,

    /**
     * Halfling.
     */
    HALFLING;

    int sizeModifier(final Sizes size) {
        switch(size) {
            case FINE:
                return 8;
            case DIMINUTIVE:
                return 4;
            case TINY:
                return 2;
            case SMALL:
                return 1;
            case MEDIUM:
                return 0;
            case LARGE:
                return -1;
            case HUGE:
                return -2;
            case GARGANTUAN:
                return -4;
            case COLOSSAL:
                return -8;
            default:
                throw new InvalidParameterException("Not a valid selection");
        }
    }
}
