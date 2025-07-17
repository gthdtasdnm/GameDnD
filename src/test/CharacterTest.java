package test;

import character.NPC;
import character.PlayerCharacter;
import data.ItemLoader;
import data.ItemRepository;
import item.Armor;
import item.Item;
import models.Equipment;
import models.EquipmentSlot;
import models.Inventory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class CharacterTest {
    private PlayerCharacter player;
    private NPC npc;

    @BeforeEach
    public void setup() {

    }

    @Test
    public void testInventoryandEquipment() {
        System.out.println("==> Test startet");

        System.out.println("==> Initialisiere Testcharaktere...");
        player = new PlayerCharacter("Held", "oldcamp", 100, 100, 10, 10, new Inventory(), new Equipment());
        npc = new NPC("Held", "oldcamp", 100, 100, 10, 10, new Inventory(), new Equipment());

        System.out.println("===> Initialisiere Items");
        ItemRepository itemRepository = new ItemRepository();
        itemRepository.loadAllItems();
        Armor armor = new Armor("chest_plate", "Brustpanzer","Brustpanzer der die Brust schützt", 50, 10, EquipmentSlot.CHEST);


        System.out.println(player.getName());
        player.addItem(ItemRepository.getArmor("iron_chestplate"));
        player.addItem(ItemRepository.getArmor("iron_leggings"));
        player.addItem(ItemRepository.getArmor("iron_helmet"));
        player.equip(ItemRepository.getArmor("iron_helmet"));
        System.out.println(player.getEquipment());
        System.out.println(player.getInventory());

    }
}
