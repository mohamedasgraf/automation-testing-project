package utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private Properties properties;

    public ConfigReader() {

        properties = new Properties();

        String filePath = "target/test-classes/config.properties";

        java.io.File file = new java.io.File(filePath);

        System.out.println("File exists = " + file.exists());
        System.out.println("File path = " + file.getAbsolutePath());
        System.out.println("File can read = " + file.canRead());

        System.out.println(
                "Resource URL = " +
                        ConfigReader.class.getResource("/config.properties")
        );

        InputStream input = ConfigReader.class
                .getResourceAsStream("/config.properties");

        System.out.println("Config input = " + input);

        if (input == null) {
            throw new RuntimeException(
                    "config.properties was not found in classpath"
            );
        }

        try {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getBaseUrl(){
        return properties.getProperty("base.url");
    }

    public String getBrowser(){
        return properties.getProperty("browser");
    }

    public int getExplicitWait(){
        return Integer.parseInt(properties.getProperty("explicit.wait"));
    }


}

