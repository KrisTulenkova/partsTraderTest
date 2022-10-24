package helpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ParametersProvider {

    public static Properties readPropertiesFile() throws IOException {
        FileInputStream fis = null;
        Properties properties = null;
        try {
            fis = new FileInputStream("src/test/java/test.properties");
            properties = new Properties();
            properties.load(fis);
        } catch (FileNotFoundException exp) {
            exp.printStackTrace();
        }finally {
            fis.close();
        }
        return properties;
    }
}


