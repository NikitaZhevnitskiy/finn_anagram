import classes.Sample;
import org.junit.Test;
import org.junit.After;
import static junit.framework.TestCase.*;


/**
 * finn_anagram
 * Nikita Zhevnitskiy on 11/01/2017
 */
public class SampleTest
{
    private Sample sample;

    @After
    public void tearDown()
    {
        sample=null;
    }

    @Test
    public void getAnagramHash_CamelCase_True()
    {
        // Arrange
        sample = new Sample("DCba");

        // Act
        String anagramHash = sample.getAnagramHash();

        // Assert
        assertEquals("abcd", anagramHash);
    }

    @Test
    public void getAnagramHash_ValueCanBeAnagramHash_True()
    {
        // Arrange
        sample = new Sample("BRY");

        // Act
        String anagramHash = sample.getAnagramHash();

        // Assert
        assertTrue("bry".equalsIgnoreCase(anagramHash));
    }
}
