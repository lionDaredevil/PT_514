package farmework.reader;

import java.io.IOException;
import java.util.Properties;

public class Config {
    private static Properties prop;

    private Config() {
    }

    public static String getProperty(String name) throws IOException {
        if (prop == null) {
            prop = PropertiesReader.read("config.properties");
        }
        return prop.getProperty(name);
    }

    public static String getProperty(String name, String defaultValue) throws IOException {
        if (prop == null) {
            prop = PropertiesReader.read("config.properties");
        }
        return prop.getProperty(name, defaultValue);
    }
}
