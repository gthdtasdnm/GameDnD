package domain.inventory;

/**
 * Das Enum {@code EquipmentSlot} definiert alle verfügbaren Ausrüstungsplätze
 * für einen Charakter im Spiel.
 *
 * <p>Jeder Slot steht für eine bestimmte Körperzone oder Ausrüstungsart,
 * z. B. {@code HEAD} für Helme oder {@code WEAPON} für Waffen.</p>
 *
 * <p>Wird in {@link domain.inventory.Equipment} verwendet,
 * um Items korrekt zuzuordnen und auszurüsten.</p>
 *
 * @author Cengiz
 * @since 2025-07-22
 */


public enum EquipmentSlot {
    HEAD,
    CHEST,
    LEGS,
    FEET,
    ARMS,
    WEAPON,
    SHIELD
}
