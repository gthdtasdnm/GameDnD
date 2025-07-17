import data.ItemRepository;
import item.Armor;
import data.ItemLoader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ItemRepository.loadAllItems();

        System.out.println(ItemRepository.getArmor("iron_chestplate").getName());
        System.out.println(ItemRepository.getWeapon("rusty_iron_sword").getName());
        System.out.println(ItemRepository.getConsumable("heal_small").getName());
    }
}
