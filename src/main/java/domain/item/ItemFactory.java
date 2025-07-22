package domain.item;

import domain.inventory.EquipmentSlot;

public class ItemFactory {

    public static Armor createArmor(String id, String name, String description, int price, int defense, EquipmentSlot slot) {
        return new Armor(id, name,  description,  price,  defense,  slot );
    }
}

