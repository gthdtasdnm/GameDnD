package test;

import domain.dialog.Condition;
import domain.dialog.DialogInstance;
import domain.dialog.DialogLine;
import domain.dialog.Information;
import UI.GUI.DialogScreen;
import domain.character.PlayerCharacter;
import data.ItemRepository;
import domain.inventory.Equipment;
import domain.inventory.Inventory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DialogTest {

    @BeforeEach
    public void setup(){

    }

    @Test
    public void DialogLineAndInstanceTest(){
        System.out.println("Test 1 #################################");
        DialogLine dialogLine1 = new DialogLine("test_1","Hello Stranger, What are you doing here?");
        DialogLine dialogLine2 = new DialogLine("test_2","Im just walking around");
        DialogLine dialogLine3 = new DialogLine("test_3","Did you know that vaporeon...");

        Condition condition = new Condition();

        Information information = new Information();

        information.add(dialogLine1);
        information.add(dialogLine2);
        information.add(dialogLine3);

        //public DialogInstance(String description, int priority, boolean isPermanent, boolean isImportant, Condition condition, Runnable action, String nextId)
        DialogInstance Dialoginstance = new DialogInstance("Hello Stranger", 1,true,false, condition, information);

        Dialoginstance.run();

    }

    @Test
    public void DialogConditionTest(){
        System.out.println("");
        System.out.println("Test 2 #################################");
        PlayerCharacter player = new PlayerCharacter("Held", "oldcamp", 100,  10, 10, new Inventory(), new Equipment());

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


        DialogLine dialogLine1 = new DialogLine("test_1", "Ich habe den Eisenbrustplatte");

        Condition condition = new Condition(player);
        condition.addCondition(character -> character.getInventory().hasItem(ItemRepository.getArmor("iron_chestplate")));
        //condition.addCondition(character -> character.getInventory().hasItem(ItemRepository.getArmor("iron_boots")));
        Information information = new Information();
        information.add(dialogLine1);

        //public DialogInstance(String description, int priority, boolean isPermanent, boolean isImportant, Condition condition, Runnable action, String nextId)
        DialogInstance Dialoginstance = new DialogInstance("Hello Stranger", 1, true, false, condition, information);

        Dialoginstance.run();
    }

    @Test
    public void DialogScreenTest() throws InterruptedException {
        DialogScreen screen = new DialogScreen();
        screen.createScreen();
        screen.addDialog("Diego: hallo was machst du hier? du solltest besser aufpassen wo du dich rumtreibts.hallo was machst du hier? du solltest besser aufpassen wo du dich rumtreibts.");
        screen.addDialog("Held: hallo was machst du hier? du solltest besser aufpassen wo du dich rumtreibts.hallo was machst du hier? du solltest besser aufpassen wo du dich rumtreibts.");
        screen.addDialog("Diego: hallo was machst du hier? du solltest besser aufpassen wo du dich rumtreibts.hallo was machst du hier? du solltest besser aufpassen wo du dich rumtreibts.");
        screen.addDialog("Held: hallo was machst du hier? du solltest besser aufpassen wo du dich rumtreibts.hallo was machst du hier? du solltest besser aufpassen wo du dich rumtreibts.");

        screen.addOption("ich will kämpfen");
        screen.addOption("zeig mir deine ware");

    }

//    @Test
//    public void MapScreenTest() throws InterruptedException {
//        MapScreen map = new MapScreen();
//        map.createScreen();
//
//    }
}
