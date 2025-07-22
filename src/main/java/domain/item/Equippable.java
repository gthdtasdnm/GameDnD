package domain.item;

import domain.inventory.EquipmentSlot;

/**
 * Das Interface {@code Equippable} definiert die Anforderungen für ausrüstbare Items
 * wie {@link Armor} oder {@code Weapon}.
 *
 * <p>Ein {@code Equippable} muss einem {@link domain.inventory.EquipmentSlot} zugeordnet sein
 * und Informationen über Angriffs- und Verteidigungswerte liefern.</p>
 *
 * <p>Die Methode {@code equip()} wird aufgerufen, wenn das Item einem
 * {@link domain.character.Character} angelegt wird.</p>
 *
 * @author Cengiz
 * @since 2025-07-22
 */


public interface Equippable {
    void equip(Character character);

    EquipmentSlot getSlot();

    int getDefense();

    int getAttack();

    String getName();

}
