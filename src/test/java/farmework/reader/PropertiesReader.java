package farmework.reader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    /**
     * Return a property object for specified file
     *
     * @param propFileName
     * @return
     * @throws IOException
     */
    public static Properties read(String propFileName) throws IOException {
        InputStream inputStream = null;
        try {
            Properties prop = new Properties();
            inputStream = PropertiesReader.class.getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            return prop;
        } catch (Exception e) {
            return null;
        }
    }
}
