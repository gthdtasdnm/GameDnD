package data;

import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

public class ItemLoader {

    private static final Gson gson = new Gson();

    // 💡 Generische Methode
    public static <T> List<T> loadItems(String resourcePath, Type typeToken) {
        InputStream input = ItemLoader.class.getClassLoader().getResourceAsStream(resourcePath);
        if (input == null) {
            System.err.println("Datei nicht gefunden im Klassenpfad: " + resourcePath);
            return null;
        }

        try (InputStreamReader reader = new InputStreamReader(input)) {
            return gson.fromJson(reader, typeToken);
        } catch (Exception e) {
            System.err.println("Fehler beim Laden von " + resourcePath);
            e.printStackTrace();
            return null;
        }
    }

    // Spezialisierungen rufen nur noch die generische Methode auf
    public static List<item.Armor> loadArmorItems() {
        System.out.println("Load Armor...");
        return loadItems("items/armor.json", new com.google.gson.reflect.TypeToken<List<item.Armor>>() {}.getType());
    }

    public static List<item.Weapon> loadWeaponItems() {
        System.out.println("Load Weapons...");
        return loadItems("items/weapons.json", new com.google.gson.reflect.TypeToken<List<item.Weapon>>() {}.getType());
    }

    public static List<item.Consumable> loadConsumableItems() {
        System.out.println("Load Consumables...");
        return loadItems("items/consumables.json", new com.google.gson.reflect.TypeToken<List<item.Consumable>>() {}.getType());
    }
}
