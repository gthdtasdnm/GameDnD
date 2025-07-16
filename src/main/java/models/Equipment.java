package models;


import item.Equippable;

import java.util.EnumMap;
import java.util.Map;

public class Equipment {

    private final Map<EquipmentSlot, Equippable> slots = new EnumMap<>(EquipmentSlot.class);

    // Item ausrüsten
    public void equip(Equippable item) {
        EquipmentSlot slot = item.getSlot();
        slots.put(slot, item);
    }

    // Item aus einem Slot entfernen
    public void unequip(EquipmentSlot slot) {
        slots.remove(slot);
    }

    // Ausgerüstetes Item für einen Slot abfragen
    public Equippable getItem(EquipmentSlot slot) {
        return slots.get(slot);
    }

    // Alle Slots + Items zurückgeben
    public Map<EquipmentSlot, Equippable> getAllEquippedItems() {
        return slots;
    }

    // Gesamte Verteidigung berechnen (z. B. für Kampfsystem)
    public int getTotalDefense() {
        return slots.values().stream()
                    .mapToInt(Equippable::getDefense)
                    .sum();
    }

    // Gesamten Angriff berechnen
    public int getTotalAttack() {
        return slots.values().stream()
                    .mapToInt(Equippable::getAttack)
                    .sum();
    }

    // Optional: Alle ausgerüsteten Items ausgeben
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Ausrüstung:\n");
        for (EquipmentSlot slot : EquipmentSlot.values()) {
            Equippable item = slots.get(slot);
            sb.append(slot).append(": ")
              .append(item != null ? item.getName() : "leer").append("\n");
        }
        return sb.toString();
    }
}
