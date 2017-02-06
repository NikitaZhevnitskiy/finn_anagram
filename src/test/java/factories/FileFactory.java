package factories;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * finn_anagram
 * Nikita Zhevnitskiy on 11/01/2017
 */
public abstract class FileFactory {

    public static File getFile(FileType type) throws IOException
    {
        String path = "src/test/temp/testFile";
        File file = new File(path);
        file.createNewFile();

        switch (type)
        {
            case EMPTY:
                break;
            case NOT_EXIST:
                file.delete(); break;
            case SAMPLES_3:
                writeToFile(file, "a\nb\nc"); break;
        }
        return file;
    }

    private static void writeToFile(File file, String lines) throws IOException
    {
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(lines);
        fileWriter.close();
    }

    public enum FileType
    {
        EMPTY,
        NOT_EXIST,
        SAMPLES_3
    }

}

