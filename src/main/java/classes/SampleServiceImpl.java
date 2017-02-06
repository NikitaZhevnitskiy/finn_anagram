package classes;
import interfaces.SampleService;
import interfaces.Validator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *
 * This class implements the SampleService interface.
 * For interface's methods implementation uses HashSet
 * to support constant time performance O(1) and
 * avoid duplicates. it does not guarantee
 * that the order will remain constant over time.
 *
 * Constructor has dependency injection of Validator
 * object. That strong aggregation is necessary to
 * avoid instantiating  SampleServiceImpl without Validator.
 * Process of creating Sample object based on injected
 * Validator object.
 *
 *  Created by Nikita Zhevnitskiy on 10/01/2017.
 */

public class SampleServiceImpl implements SampleService
{
    private Validator validator;

    public SampleServiceImpl(Validator validator)
    {
        this.validator=validator;
    }

    public List<Sample> getSamples(File file)
    {
        System.out.println("### GET samples from file: " + file.getName());
        HashSet<Sample> list = new HashSet<>();

        try(Scanner scanner = new Scanner(file, "UTF-8"))
        {
            while(scanner.hasNext())
            {
                String line = scanner.nextLine();

                if (validator.isValid(line)) list.add(new Sample(line));
                else {
                    String alert = (char)27 + "[34m### "+line +
                            " -- was not valid : was not added to samples list"+ (char)27 + "[0m";
                    System.out.println(alert);
                }
            }
        }
        catch (FileNotFoundException e) {e.printStackTrace();}

        return new ArrayList<>(list);
    }


    public void setValidator(Validator validator) {this.validator=validator;}
}
