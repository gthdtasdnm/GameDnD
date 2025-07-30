package core.factory;

import domain.inventory.EquipmentSlot;
import domain.item.Armor;

/**
 * Die Klasse {@code ItemFactory} dient zur Erstellung von {@link domain.item.Armor}-Objekten
 * über eine zentrale statische Methode.
 *
 * <p>Sie folgt dem Factory-Pattern und ermöglicht die saubere Instanziierung von
 * Rüstungsgegenständen mit allen nötigen Eigenschaften.</p>
 *
 * <p>Geplant ist eine Erweiterung um zusätzliche Itemtypen wie {@link domain.item.Weapon} oder {@link domain.item.Consumable}.</p>
 *
 * @author Cengiz
 * @since 2025-07-22
 */


public class ItemFactory {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ItemFactory.class);

    public static Armor createArmor(String id, String name, String description, int price, int defense, EquipmentSlot slot) {
    logger.info("createArmor()");        return new Armor(id, name,  description,  price,  defense,  slot );
    }
}

