package fly.utils;

import java.io.IOException;
import java.util.Properties;

public class ConfiqUtils {
    private static Properties properties = new Properties();

    static{
        try {
            properties.load(ClassLoader.getSystemResourceAsStream("confiq.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProporties(String key) {
        return properties.getProperty(key);
    }
}
