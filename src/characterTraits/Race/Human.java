package characterTraits.Race;

import characterTraits.Classes.Classes;
import characterTraits.Languages;
import characterTraits.Sizes;
import characterTraits.Vision;

import java.util.ArrayList;
import java.util.Arrays;

public class Human extends Race{

    public Human() {
        ArrayList<Integer> adjustments = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0));
        ArrayList<Vision> vision = new ArrayList<>(Arrays.asList(Vision.NORMAL));
        ArrayList<Classes> classes = new ArrayList<>(Arrays.asList(Classes.ANY));
        setStrAdjustment(0);
        setDexAdjustment(0);
        setConAdjustment(0);
        setIntAdjustment(0);
        setWisAdjustment(0);
        setChaAdjustment(0);
        setAbilityAdjustments(adjustments);
        setFavoredClasses(classes);
        setExtraSkillPoints(4);
        setBonusFeats(1);
        setBaseLandSpeed(30);
        setAutomaticLanguage(Languages.COMMON);
        setBonusLanguages(1);
        setVision(vision);
        setSize(Sizes.MEDIUM);
    }

}
