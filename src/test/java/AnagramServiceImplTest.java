import classes.AnagramServiceImpl;
import classes.Sample;
import factories.SampleListFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static junit.framework.TestCase.*;

import static org.mockito.Mockito.*;


/**
 * finn_anagram
 * Nikita Zhevnitskiy on 11/01/2017
 */
public class AnagramServiceImplTest
{
    private AnagramServiceImpl anagramService;

    @Before
    public void setUp()
    {
        anagramService = new AnagramServiceImpl();
    }

    @After
    public void tearDown()
    {
        anagramService=null;
    }


    @Test
    public void getAnagramsOnly_EmptyList_MapEmpty()
    {
        // Arrange

        // Act
        ArrayList<Sample> samples = (ArrayList<Sample>)
                SampleListFactory.getSampleList(SampleListFactory.SamplesType.EMPTY);
        Map<String, List<Sample>> anagrams = anagramService.getAnagramsOnly(samples);

        // Assert
        assertEquals(0, anagrams.size());

    }


    @Test
    public void  getAnagramsOnly_3Samples3Anagrams_Map1Key3Value()
    {
        // Arrange

        // Act
        ArrayList<Sample> samples = (ArrayList<Sample>)
                SampleListFactory.getSampleList(SampleListFactory.SamplesType.SAMPLES_3_ANAGRAMS_3);
        Map<String, List<Sample>> anagrams = anagramService.getAnagramsOnly(samples);

        // Assert
        assertEquals(1, anagrams.size());
        assertEquals(3, anagrams.get(samples.get(0).getAnagramHash()).size());
    }

    @Test
    public void getAnagramsOnly_3Samples2Anagrams_Map1Key2Value()
    {
        // Arrange

        // Act
        ArrayList<Sample> samples = (ArrayList<Sample>)
                SampleListFactory.getSampleList(SampleListFactory.SamplesType.SAMPLES_3_ANAGRAMS_2);
        Map<String, List<Sample>> anagrams = anagramService.getAnagramsOnly(samples);

        // Assert
        assertEquals(1, anagrams.size());
        assertEquals(2, anagrams.get(samples.get(0).getAnagramHash()).size());

    }

    @Test
    public void getAnagramsOnly_3Samples0Anagrams_MapEmpty()
    {
        // Arrange

        // Act
        ArrayList<Sample> samples = (ArrayList<Sample>)
                SampleListFactory.getSampleList(SampleListFactory.SamplesType.SAMPLES_3_ANAGRAMS_0);
        Map<String, List<Sample>> anagrams = anagramService.getAnagramsOnly(samples);

        // Assert
        assertEquals(0, anagrams.size());
    }

}
