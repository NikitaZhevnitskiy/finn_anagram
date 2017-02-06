import classes.Sample;
import classes.SampleServiceImpl;
import classes.ValidatorImpl;
import factories.FileFactory;
import interfaces.Validator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import static junit.framework.TestCase.*;
import static org.mockito.Mockito.*;

/**
 * finn_anagram
 * Nikita Zhevnitskiy on 11/01/2017
 */

public class SampleServiceImplTest
{
    private Validator mockedValidator;
    private SampleServiceImpl sampleService;
    private File file;


    @Before
    public void setUp()
    {
        mockedValidator = mock(ValidatorImpl.class);
        sampleService = new SampleServiceImpl(mockedValidator);
    }

    @After
    public void tearDown()
    {
        mockedValidator=null;
        sampleService=null;
        file.delete();
        file=null;
    }

    @Test
    public void getSamples_EmptyFile_EmptyList() throws IOException
    {

        // Arrange
        file = FileFactory.getFile(FileFactory.FileType.EMPTY);

        // Act
        when(mockedValidator.isValid(anyString())).thenReturn(true);
        ArrayList<Sample> samples = (ArrayList<Sample>) sampleService.getSamples(file);

        // Assert
        verify(mockedValidator, never()).isValid(anyString());
        assertEquals(0, samples.size());
    }

    @Test
    public void getSamples_3IncorrectSamplesInFile_EmptyList() throws IOException
    {
        // Arrange
        file = FileFactory.getFile(FileFactory.FileType.SAMPLES_3);

        // Act
        when(mockedValidator.isValid(anyString())).thenReturn(false);
        ArrayList<Sample> samples = (ArrayList<Sample>) sampleService.getSamples(file);

        // Assert
        verify(mockedValidator, atLeast(3)).isValid(anyString());
        assertEquals(0, samples.size());

    }

    @Test
    public void getSample_3CorrectSamplesInFile_ListWith3Samples() throws IOException
    {
        // Arrange
        file = FileFactory.getFile(FileFactory.FileType.SAMPLES_3);

        // Act
        when(mockedValidator.isValid(anyString())).thenReturn(true);
        ArrayList<Sample> samples = (ArrayList<Sample>) sampleService.getSamples(file);

        // Assert
        verify(mockedValidator, atLeast(3)).isValid(anyString());
        assertEquals(3, samples.size());
    }

    @Test
    public void getSample_1Correct2IncorrectSamplesInFile_ListWith1Samples() throws IOException
    {
        // Arrange
        file = FileFactory.getFile(FileFactory.FileType.SAMPLES_3);

        // Act
        when(mockedValidator.isValid("a")).thenReturn(true);
        ArrayList<Sample> samples = (ArrayList<Sample>) sampleService.getSamples(file);

        // Assert
        verify(mockedValidator, atLeast(3)).isValid(anyString());
        assertEquals(1, samples.size());
    }

    @Test
    public void getSample_2Correct1IncorrectSamplesInFile_ListWith2Samples() throws IOException
    {
        // Arrange
        file = FileFactory.getFile(FileFactory.FileType.SAMPLES_3);

        // Act
        when(mockedValidator.isValid("b")).thenReturn(true);
        when(mockedValidator.isValid("a")).thenReturn(true);
        ArrayList<Sample> samples = (ArrayList<Sample>) sampleService.getSamples(file);

        // Assert
        verify(mockedValidator, atLeast(3)).isValid(anyString());
        assertEquals(2, samples.size());
    }

}
