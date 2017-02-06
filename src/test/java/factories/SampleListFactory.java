package factories;

import classes.Sample;


import java.util.ArrayList;
import java.util.List;

/**
 * finn_anagram
 * Nikita Zhevnitskiy on 11/01/2017
 */
public abstract class SampleListFactory
{

    public static List<Sample> getSampleList(SamplesType type)
    {
        ArrayList<Sample> list = new ArrayList<>();
        switch (type)
        {
            case EMPTY:
                break;
            case SAMPLES_3_ANAGRAMS_3:
                list.add(new Sample("abc"));
                list.add(new Sample("acb"));
                list.add(new Sample("cba"));
                break;
            case SAMPLES_3_ANAGRAMS_2:
                list.add(new Sample("abc"));
                list.add(new Sample("acb"));
                list.add(new Sample("cbad"));
                break;
            case SAMPLES_3_ANAGRAMS_0:
                list.add(new Sample("ab"));
                list.add(new Sample("acb"));
                list.add(new Sample("cbad"));
                break;
        }

        return list;
    }

    public enum SamplesType
    {
        EMPTY,
        SAMPLES_3_ANAGRAMS_3,
        SAMPLES_3_ANAGRAMS_2,
        SAMPLES_3_ANAGRAMS_0
    }
}
