package characterTraits.Race;

import characterTraits.Classes.Classes;
import characterTraits.Languages;
import characterTraits.Sizes;
import characterTraits.Vision;

import java.util.ArrayList;
import java.util.Arrays;

import static characterTraits.Languages.*;

public class Human extends Race {

    public Human() {
        ArrayList<Vision> vision = new ArrayList<>(Arrays.asList(Vision.NORMAL));
        ArrayList<Classes> classes = new ArrayList<>(Arrays.asList(Classes.ANY));
        ArrayList<Languages> languages = new ArrayList<>(Arrays.asList(Languages.COMMON));
        ArrayList<Languages> bonusLanguages = new ArrayList<>(Arrays.asList(GIANT, COMMON,
                HALFLING, DWARVEN, ELVEN, GNOME, GOBLIN, ORC, GIANT, TERRAN, UNDERCOMMON));
        setRacialStrAdjustment(0);
        setRacialDexAdjustment(0);
        setRacialConAdjustment(0);
        setRacialIntAdjustment(0);
        setRacialWisAdjustment(0);
        setRacialChaAdjustment(0);
        setRaceFavoredClasses(classes);
        setRacialExtraSkillPoints(4);
        setRacialBonusFeats(1);
        setRacialBaseLandSpeed(30);
        setAutomaticRacialLanguage(languages);
        setRacialBonusLanguages(bonusLanguages);
        setRacialVision(vision);
        setRaceSize(Sizes.MEDIUM);
    }
}
