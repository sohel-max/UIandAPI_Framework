package org.essntials;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropClass {
    static Properties prop = new Properties();

    public static void loadFile() throws IOException {
        String filePath = System.getProperty("user.dir") + "\\src\\test\\Properties\\HomePage.properties";
        FileInputStream fs = new FileInputStream(filePath);
        prop.load(fs);
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }
}
