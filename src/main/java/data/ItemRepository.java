package data;

import domain.item.Armor;
import domain.item.Consumable;
import domain.item.Weapon;

import java.util.HashMap;
import java.util.Map;

/**
 * Die {@code ItemRepository}-Klasse dient als zentraler Zwischenspeicher
 * für alle im Spiel verfügbaren Items.
 *
 * <p>Sie verwaltet getrennte Maps für:</p>
 * <ul>
 *   <li>{@link domain.item.Armor} – Rüstungen</li>
 *   <li>{@link domain.item.Weapon} – Waffen</li>
 *   <li>{@link domain.item.Consumable} – Verbrauchsgegenstände</li>
 * </ul>
 *
 * <p>Die Items werden zur Laufzeit über den {@link ItemLoader} aus JSON-Dateien geladen
 * und mit ihrer eindeutigen ID gespeichert. Der Zugriff erfolgt lesend über die ID
 * oder vollständig über die jeweilige Map.</p>
 *
 * <p>Beispiel:</p>
 * <pre>{@code
 * ItemRepository.loadAllItems();
 * Weapon sword = ItemRepository.getWeapon("old_sword_01");
 * }</pre>
 *
 * @author Cengiz
 * @since 2025-07-22
 */


public class ItemRepository {

    private static final Map<String, Armor> armorMap = new HashMap<>();
    private static final Map<String, Weapon> weaponMap = new HashMap<>();
    private static final Map<String, Consumable> consumableMap = new HashMap<>();

    public static void loadAllItems() {
        // Von JSON laden über ItemLoader (Factory wird intern verwendet)
        for (Armor armor : ItemLoader.loadArmorItems()) {
            armorMap.put(armor.getId(), armor);
        }

        for (Weapon weapon : ItemLoader.loadWeaponItems()) {
            weaponMap.put(weapon.getId(), weapon);
        }

        for (Consumable consumable : ItemLoader.loadConsumableItems()) {
            consumableMap.put(consumable.getId(), consumable);
        }
    }

    public static Armor getArmor(String id) {return armorMap.get(id);}

    public static boolean hasArmor(String id) {return armorMap.containsKey(id);}

    public static Map<String, Armor> getAllArmor() {return armorMap;}


    public static Weapon getWeapon(String id) {return weaponMap.get(id);}

    public static boolean hasWeapon(String id) {return weaponMap.containsKey(id);}

    public static Map<String, Weapon> getAllWeapons() {return weaponMap;}


    public static Consumable getConsumable(String id) {return consumableMap.get(id);}

    public static boolean hasConsumable(String id) {return consumableMap.containsKey(id);}

    public static Map<String, Consumable> getAllConsumables() {return consumableMap;}


}
