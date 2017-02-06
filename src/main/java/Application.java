import classes.*;
import interfaces.*;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 *
 * Class represent application run
 *
 * Created by Nikita Zhevnitskiy on 10/01/2017.
 */
public class Application
{
    public static void main(String[] args)
    {
        // init procedures
        String norwegianAlphabet="abcdefghijklmnopqrstuvwxyzæøå";
        Validator validator = new ValidatorImpl(norwegianAlphabet);
        String filePath = "src/main/resources/eventyr.txt";
        File file = new File(filePath);
        SampleService sampleService = new SampleServiceImpl(validator);
        AnagramService anagramService = new AnagramServiceImpl();

        // init get samples
        List<Sample> list = sampleService.getSamples(file);

        //Map<String, List<Sample>> listAnagrams = anagramService.getAnagramsOnly(list);
        anagramService.printAnagrams(list);

//        Date date= new Date();
        
    }
}
