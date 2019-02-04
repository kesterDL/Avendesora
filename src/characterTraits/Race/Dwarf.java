package characterTraits.Race;

import characterTraits.Classes.Classes;
import characterTraits.Languages;
import characterTraits.Sizes;
import characterTraits.Vision;

import java.util.ArrayList;
import java.util.Arrays;

public class Dwarf extends Race {

    public Dwarf() {
        ArrayList<Vision> vision = new ArrayList<>(Arrays.asList(Vision.NORMAL, Vision.DARK_VISION));
        ArrayList<Languages> languages = new ArrayList<>(Arrays.asList(Languages.COMMON, Languages.DWARVEN));
        ArrayList<Languages> bonusLanguages = new ArrayList<>(Arrays.asList(Languages.GIANT, Languages.GNOME,
                Languages.GOBLIN, Languages.ORC, Languages.TERRAN, Languages.UNDERCOMMON));
        ArrayList<Classes> classes = new ArrayList<>(Arrays.asList(Classes.FIGHTER));
        setRacialStrAdjustment(0);
        setRacialDexAdjustment(0);
        setRacialConAdjustment(2);
        setRacialIntAdjustment(0);
        setRacialWisAdjustment(0);
        setRacialChaAdjustment(-2);
        setRaceFavoredClasses(classes);
        setRacialExtraSkillPoints(4);
        setRacialBonusFeats(1);
        setRacialBaseLandSpeed(20);
        setAutomaticRacialLanguage(languages);
        setRacialVision(vision);
        setRaceSize(Sizes.MEDIUM);
    }

}
