package test;

import domain.character.NPC;
import domain.character.PlayerCharacter;
import data.ItemRepository;
import domain.inventory.Equipment;
import domain.inventory.Inventory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        player = new PlayerCharacter("Held", "oldcamp", 100, 10, 10, new Inventory(), new Equipment());
        npc = new NPC("Held", "oldcamp", 100, 10, 10, new Inventory(), new Equipment());

        System.out.println("===> Initialisiere Items");
        ItemRepository itemRepository = new ItemRepository();
        itemRepository.loadAllItems();


        System.out.println(player.getName());
        player.addItem(ItemRepository.getArmor("iron_chestplate"));
        player.addItem(ItemRepository.getArmor("iron_leggings"));
        player.addItem(ItemRepository.getArmor("iron_helmet"));
        player.equip(ItemRepository.getArmor("iron_helmet"));
        player.equip(ItemRepository.getArmor("iron_leggings"));
        System.out.println(player.getEquipment());
        System.out.println(player.getInventory());
    }
}
