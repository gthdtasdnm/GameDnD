package domain.item;

import domain.inventory.EquipmentSlot;

public interface Equippable {
    void equip(Character character);

    EquipmentSlot getSlot();

    int getDefense();

    int getAttack();

    String getName();

}
