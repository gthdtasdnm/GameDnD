

import core.GameManager;
import core.factory.PlayerFactory;
import domain.character.Character;

public class Main {
   public static void main(String[] args) {
       PlayerFactory playerFactory = new PlayerFactory();
       Character player = playerFactory.create("Held", "oldcamp", 100, 10, 10, null, null);
       System.out.println(player);

    }
}

