//load properties
package utils;

import org.checkerframework.checker.index.qual.PolyUpperBound;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

public static String read(String key) {return read(Constants.CONFIG_FILE_PATH);}

    public static String read(String key, String path) {

        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream(path))
        {prop.load(fis);
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
    return prop.getProperty(key);
    }

}
