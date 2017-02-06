package classes;
import interfaces.Validator;
import java.util.HashSet;

/**
 *
 * This class implements the Validator interface.
 * Interface's methods implementation based on
 * String object which is parsed to char arr
 * characters(alphabet), which are initialised
 * through dependency injection in constructor.
 * isValid method ignore letters case of String
 * object from parameter. Support linear runtime
 * O(n), where n - length of String value
 *
 * Characters(alphabet) stores in HashSet to
 * support constant time performance for get
 * operation and to avoid duplicates is not
 * sensitive to letters case.
 *
 *  Created by Nikita Zhevnitskiy on 10/01/2017.
 */
public class ValidatorImpl implements Validator
{
    private HashSet<Character> alphabet;

    public ValidatorImpl(String alphabet)
    {
         this.alphabet = new HashSet<>();
         char[] temp = alphabet.trim().toLowerCase().toCharArray();
         for (char i : temp)
             this.alphabet.add(new Character(i));
    }

    /**
     * TODO: for future expanding
     *
     * */
    //public ValidatorImpl(String alphabet, String specialSymbols){}

    public boolean isValid(String sampleLine)
    {
        boolean valid = true;
        char[] temp = sampleLine.trim().toLowerCase().toCharArray();
        for(char i : temp)
        {

            if (!alphabet.contains(i)) valid = false;
        }
        return valid;
    }

}
