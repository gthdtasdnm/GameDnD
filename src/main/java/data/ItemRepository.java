package data;

import item.Armor;
import item.Consumable;
import item.Weapon;

import java.util.HashMap;
import java.util.Map;

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
