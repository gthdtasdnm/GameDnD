package test;

import character.NPC;
import character.PlayerCharacter;
import models.Equipment;
import models.Inventory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class CharacterTest {
    private PlayerCharacter player;
    private NPC npc;

    @BeforeEach
    public void setup() {
        System.out.println("==> Initialisiere Testcharaktere...");
        player = new PlayerCharacter("Held", "oldcamp", 100, 100, 10, 10, new Inventory(), new Equipment());
        npc = new NPC("Held", "oldcamp", 100, 100, 10, 10, new Inventory(), new Equipment());
    }

    @Test
    public void testDialogAndQuestInteraction() {
        System.out.println("==> Test startet");

    }
}
