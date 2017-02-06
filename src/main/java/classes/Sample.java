package classes;
import java.util.Arrays;

/**
 *
 * This class represents model of sample which can be any
 * String object: word, sentence, symbols. Model has
 * two fields
 * 1. value - is exact value of String object, sensitive
 * to letters case.
 * 2. anagramHash - is sorted(ascending) symbols of String
 * object value, only lower case.
 * NB! Uses util sorting algorithm (Dual-Pivot Quicksort)
 * which offers O(n log(n)) performance.
 *
 *  Created by Nikita Zhevnitskiy on 11/01/2017.
 */
public class Sample
{
    private String value;
    private String anagramHash;

    public Sample(){}

    public Sample(String value)
    {
        setValue(value);
        setAnagramHash(value);
    }

    public String getValue() {return value;}
    public void setValue(String value) {this.value = value;}
    public String getAnagramHash() {return anagramHash;}


    private void setAnagramHash(String value)
    {
        char[] anagramHash = value.toLowerCase().trim().toCharArray();
        Arrays.sort(anagramHash);
        this.anagramHash = String.valueOf(anagramHash);
    }


    public String toString() {return getValue();}
}
