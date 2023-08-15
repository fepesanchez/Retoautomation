package Data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class ConfigReader {
    private final Properties properties;

    public ConfigReader() throws IOException {
        this.properties = new Properties();
        FileInputStream input = new FileInputStream("src/test/java/data/data.properties");
        properties.load(input);
        input.close();
    }

    public String getUrl() {
        return properties.getProperty("url");
    }
    public String getEmail() {
        return properties.getProperty("email");
    }

    public String getPassword() {
        return properties.getProperty("password");

    }

    public int getTimeOut() {
        return Integer.parseInt(properties.getProperty("timeOut"));

    }

    public boolean getLogDetail() {
        return Boolean.parseBoolean(properties.getProperty("logDetail"));

    }
}
