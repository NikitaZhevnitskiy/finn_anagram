import classes.ValidatorImpl;
import interfaces.Validator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * finn_anagram
 * Nikita Zhevnitskiy on 11/01/2017
 */
public class ValidatorImplTest
{
    private Validator validator;
    private String alphabet;

    @Before
    public void setUp(){
        alphabet = "abc";
        validator = new ValidatorImpl(alphabet);
    }
    @After
    public void tearDown()
    {
        alphabet=null;
        validator=null;
    }

    @Test
    public void isValid_EmptyStringTrim_True()
    {
        String line = "";
        boolean valid = validator.isValid(line);
        assertTrue(valid);
    }

    @Test
    public void isValid_CorrectStringOneWord_True()
    {
        String line = "bca";
        boolean valid = validator.isValid(line);
        assertTrue(valid);
    }

    @Test
    public void isValid_IncorrectStringOneWord_False()
    {
        String line = "abcwx";
        boolean valid = validator.isValid(line);
        assertFalse(valid);
    }

    @Test
    public void isValid_IncorrectStringSentence_False()
    {
        String line = "abc abc";
        boolean valid = validator.isValid(line);
        assertFalse(valid);
    }

    @Test
    public void isValid_IgnoreCamelCaseOneWord_True()
    {
        String line = "aBC";
        boolean valid = validator.isValid(line);
        assertTrue(valid);
    }

}
