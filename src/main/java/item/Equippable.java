package item;

import models.EquipmentSlot;

public interface Equippable {
    void equip(Character character);

    EquipmentSlot getSlot();

    int getDefense();

    int getAttack();

    String getName();
}
