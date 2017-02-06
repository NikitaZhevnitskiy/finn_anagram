package interfaces;
import classes.Sample;
import java.io.File;
import java.util.List;

/**
 *
 * This interface offers one operation
 * get samples from file and return samples
 * as List interface
 *
 * Created by Nikita Zhevnitskiy on 10/01/2017.
 */
public interface SampleService
{
    public List<Sample> getSamples(File file);
}