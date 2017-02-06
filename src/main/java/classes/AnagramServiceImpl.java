package classes;
import interfaces.AnagramService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * This class implements the AnagramService interface.
 * For interface's methods implementation uses HashMap
 * to support constant time performance for the basic
 * operations(get , put) - O(1), it does not guarantee
 * that the order will remain constant over time.
 *
 * This class offers next operations with list of samples:
 *      1.Find anagrams
 *      2.Print anagrams
 *  NB! key = anagram hash of sample
 *  NB! value = list of samples with anagram hash as a key
 *
 *  Created by Nikita Zhevnitskiy on 11/01/2017.
 */
public class AnagramServiceImpl implements AnagramService
{
    public AnagramServiceImpl(){}

    public Map<String, List<Sample>> getAnagramsOnly(List<Sample> list)
    {
        Map<String, List<Sample>> analysedCollection = analyseCollectionOnAnagrams(list);
        Map<String, List<Sample>> anagrams = new HashMap<>();

        for (Map.Entry<String, List<Sample>> entry : analysedCollection.entrySet())
        {
            if (entry.getValue().size()>1)
                anagrams.put(entry.getKey(), entry.getValue());
        }
       return anagrams;

    }

    private Map<String, List<Sample>> analyseCollectionOnAnagrams(List<Sample> list)
    {
        Map<String, List<Sample>> analysedCollection = new HashMap<>();

        for (Sample sample : list)
        {
            if (analysedCollection.containsKey(sample.getAnagramHash()))
            {
                analysedCollection.get(sample.getAnagramHash()).add(sample);
            }
            else
            {
                analysedCollection.put(sample.getAnagramHash(), new ArrayList<Sample>());
                analysedCollection.get(sample.getAnagramHash()).add(sample);
            }
        }
        return analysedCollection;
    }

    public void printAnagrams(List<Sample> list)
    {
        Map<String, List<Sample>> anagrams = getAnagramsOnly(list);
        String info ="### ANAGRAMS\n### TOTAL KEYS: "+anagrams.size()+"\n### KEY : VALUES\n";
        System.out.println(info);

        for (Map.Entry<String, List<Sample>> entry : anagrams.entrySet())
            System.out.println(entry.getKey() + " : " + entry.getValue().toString());

        System.out.println();
    }
}
