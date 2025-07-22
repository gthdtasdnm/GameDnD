package data;

import com.google.gson.Gson;
import domain.item.Armor;
import domain.item.Consumable;
import domain.item.Weapon;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Die {@code ItemLoader}-Klasse lädt Item-Daten (Rüstungen, Waffen, Verbrauchsgegenstände)
 * aus JSON-Dateien mithilfe von {@code Gson}.
 *
 * <p>Sie verwendet eine generische Methode {@code loadItems}, um beliebige Itemtypen
 * aus Ressourcendateien zu deserialisieren.</p>
 *
 * <p>Die spezialisierten Methoden {@code loadArmorItems}, {@code loadWeaponItems} und
 * {@code loadConsumableItems} kapseln den Pfad und den Typ für die jeweiligen Item-Klassen.</p>
 *
 * <p>Beispielnutzung:</p>
 * <pre>{@code
 * List<Armor> armors = ItemLoader.loadArmorItems();
 * List<Weapon> weapons = ItemLoader.loadWeaponItems();
 * }</pre>
 *
 * @author Cengiz
 * @since 2025-07-22
 */


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
    public static List<Armor> loadArmorItems() {
        System.out.println("Load Armor...");
        return loadItems("items/armor.json", new com.google.gson.reflect.TypeToken<List<Armor>>() {}.getType());
    }

    public static List<Weapon> loadWeaponItems() {
        System.out.println("Load Weapons...");
        return loadItems("items/weapons.json", new com.google.gson.reflect.TypeToken<List<Weapon>>() {}.getType());
    }

    public static List<Consumable> loadConsumableItems() {
        System.out.println("Load Consumables...");
        return loadItems("items/consumables.json", new com.google.gson.reflect.TypeToken<List<Consumable>>() {}.getType());
    }
}
