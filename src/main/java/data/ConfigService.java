package data;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigService {
    private static final Properties config = new Properties();

    static {
        try (InputStream in = ConfigService.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (in == null) {
                throw new RuntimeException("config.properties nicht gefunden!");
            }
            config.load(in);
        } catch (IOException e) {
            throw new RuntimeException("Fehler beim Laden der Konfiguration", e);
        }
    }

    public static String get(String key) {
        return config.getProperty(key);
    }

    public static int getInt(String key) {
        return Integer.parseInt(config.getProperty(key));
    }

    public static boolean getBoolean(String key) {
        return Boolean.parseBoolean(config.getProperty(key));
    }
}
