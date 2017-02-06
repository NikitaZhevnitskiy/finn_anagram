package interfaces;
import classes.Sample;
import java.util.List;
import java.util.Map;

/**
 *
 * This interface offers next operations with list of samples:
 *      Find anagrams
 *      Print anagrams
 *
 *  Created by Nikita Zhevnitskiy on 11/01/2017.
 */
public interface AnagramService
{
    public Map<String, List<Sample>> getAnagramsOnly(List<Sample> list);
    public void printAnagrams(List<Sample> list);
}
