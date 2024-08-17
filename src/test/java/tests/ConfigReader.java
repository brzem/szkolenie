package tests;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;
    private final String propertiesFileName = "src/test/resources/config.properties";

    //Konstruktor
    public ConfigReader() {
        try (FileInputStream inputStream = new FileInputStream(propertiesFileName)) {
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("config.properties file not found at" + propertiesFileName);
        }
    }

    //Konfiguracja dla przeglądarki
    public boolean isIncognito() {
        return Boolean.parseBoolean(properties.getProperty("incognito"));
    }

    public boolean isNoFirstRun() {
        return Boolean.parseBoolean(properties.getProperty("noFirstRun"));
    }

    public boolean isNoDefaultBrowserCheck() {
        return Boolean.parseBoolean(properties.getProperty("noDefaultBrowserCheck"));
    }


    public String getApplicationURL() {
        return properties.getProperty("app.url");
    }

    public String getUsername() {
        return properties.getProperty("userName");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }
}
