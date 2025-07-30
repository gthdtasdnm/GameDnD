package domain.inventory;


import domain.item.Equippable;

import java.util.EnumMap;
import java.util.Map;

/**
 * Die Klasse {@code Equipment} verwaltet alle aktuell ausgerüsteten Items eines Charakters.
 *
 * <p>Items vom Typ {@link domain.item.Equippable} werden in einem {@link EquipmentSlot} platziert
 * und können jederzeit ausgetauscht oder abgefragt werden.</p>
 *
 * <p>Die Klasse stellt außerdem Methoden zur Berechnung von Gesamtangriff und Gesamtverteidigung bereit,
 * basierend auf allen aktuell ausgerüsteten Items.</p>
 *
 * <p>Typisch für Spieler- und NPC-Charaktere zur Darstellung und Berechnung ihrer Kampfstärke.</p>
 *
 * @author Cengiz
 * @since 2025-07-22
 */


public class Equipment {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Equipment.class);

    private final Map<EquipmentSlot, Equippable> slots = new EnumMap<>(EquipmentSlot.class);

    // Item ausrüsten
    public void equip(Equippable item) {
    logger.info("equip()");        EquipmentSlot slot = item.getSlot();
        slots.put(slot, item);
    }

    // Item aus einem Slot entfernen
    public void unequip(EquipmentSlot slot) {
    logger.info("unequip()");        slots.remove(slot);
    }

    // Ausgerüstetes Item für einen Slot abfragen
    public Equippable getItem(EquipmentSlot slot) {
    logger.info("getItem()");        return slots.get(slot);
    }

    // Alle Slots + Items zurückgeben
    public Map<EquipmentSlot, Equippable> getAllEquippedItems() {
        return slots;
    }

    // Gesamte Verteidigung berechnen (z. B. für Kampfsystem)
    public int getTotalDefense() {
    logger.info("getTotalDefense()");        return slots.values().stream()
                    .mapToInt(Equippable::getDefense)
                    .sum();
    }

    // Gesamten Angriff berechnen
    public int getTotalAttack() {
    logger.info("getTotalAttack()");        return slots.values().stream()
                    .mapToInt(Equippable::getAttack)
                    .sum();
    }

    // Optional: Alle ausgerüsteten Items ausgeben
    @Override
    public String toString() {
    logger.info("toString()");        StringBuilder sb = new StringBuilder("Ausrüstung:\n");
        for (EquipmentSlot slot : EquipmentSlot.values()) {
            Equippable item = slots.get(slot);
            sb.append(slot).append(": ")
              .append(item != null ? item.getName() : "leer").append("\n");
        }
        return sb.toString();
    }
}
