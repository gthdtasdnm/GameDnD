package state;

import UI.MenuScreen;
import core.StateManager;
import domain.dialog.DialogInstance;
import domain.dialog.DialogLine;
import domain.dialog.Information;

import java.util.ArrayList;
import java.util.List;

public class MenuState extends GameState implements GameEventListener {
    MenuScreen screen;

    public MenuState(StateManager stateManager) {
        super(stateManager);
        this.screen = new MenuScreen(this); // konkret für diesen State
    }

    @Override
    public void enter() {
        screen.createScreen();
    }

    @Override
    public void update() {

    }

    @Override
    public void exit() {
        screen.closeScreen();
    }

    @Override
    public String getDescription() {
        return "Menu State";
    }

    @Override
    public void onUiAction(String actionId) {
        switch (actionId) {
            case "start_game" -> {
                List<DialogInstance> dialogs = new ArrayList<>();

                // Dialog 1: Einführung
                DialogLine d1_1 = new DialogLine("1", "Diego", "Hey du! Bist du neu hier?");
                DialogLine d1_2 = new DialogLine("2", "Held", "Das kommt drauf an.");
                DialogLine d1_3 = new DialogLine("3", "Diego", "Ich bin Diego. Und wenn du Hilfe brauchst, solltest du dich mit mir gut stellen.");

                Information info1 = new Information();
                info1.add(d1_1);
                info1.add(d1_2);
                info1.add(d1_3);
                dialogs.add(new DialogInstance("Diego", "Wer bist du?", info1));

                // Dialog 2: Die Barriere
                DialogLine d2_1 = new DialogLine("1", "Held", "Wo bin ich hier?");
                DialogLine d2_2 = new DialogLine("2", "Diego", "In der Kolonie. Oder besser gesagt: im alten Lager, mitten in der Barriere.");
                DialogLine d2_3 = new DialogLine("3", "Diego", "Die Magier haben die Barriere erschaffen, um die Strafkolonie einzusperren. Nur reinkommen ist einfach – raus kommt keiner.");

                Information info2 = new Information();
                info2.add(d2_1);
                info2.add(d2_2);
                info2.add(d2_3);
                dialogs.add(new DialogInstance("Diego", "Wo bin ich?", info2));

                // Dialog 3: Das Überleben
                DialogLine d3_1 = new DialogLine("1", "Held", "Was soll ich jetzt tun?");
                DialogLine d3_2 = new DialogLine("2", "Diego", "Das hängt ganz von dir ab. Schließ dich einem Lager an, lern kämpfen – oder du wirst hier nicht lange überleben.");
                DialogLine d3_3 = new DialogLine("3", "Diego", "Wenn du schlau bist, kommst du mit mir. Ich zeige dir das Alte Lager.");

                Information info3 = new Information();
                info3.add(d3_1);
                info3.add(d3_2);
                info3.add(d3_3);
                dialogs.add(new DialogInstance("Diego", "Was soll ich tun?", info3));

                // Dialog 4: ENDE
                dialogs.add(new DialogInstance());

                stateManager.setGameState(new DialogState(stateManager, dialogs));
            }
            case "exit_game" -> System.exit(0);
            default -> logger.warn("Unbekannte UI-Aktion: " + actionId);
        }
    }


}
