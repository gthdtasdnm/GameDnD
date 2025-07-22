package core;

import domain.character.PlayerCharacter;
import domain.character.QuestLog;
import domain.inventory.Inventory;
import state.DialogState;
import state.ExploreState;
import state.FightState;
import state.GameContext;



/**
 * Der {@code GameManager} ist die zentrale Steuerungseinheit des Spiels.
 *
 * <p>Er initialisiert Spielfiguren, Karte, Controller und verwaltet den aktuellen Spielzustand
 * über die State-Maschine {@link GameContext}.</p>
 *
 * <p>Der {@code GameManager} wechselt dynamisch zwischen verschiedenen Spielzuständen wie:</p>
 * <ul>
 *   <li>{@link ExploreState} – Erkundung der Spielwelt</li>
 *   <li>{@link FightState} – Kampf gegen Gegner</li>
 *   <li>{@link DialogState} – Gespräche mit NPCs</li>
 * </ul>
 *
 * <p>Diese Klasse bildet die Brücke zwischen Spiellogik, Spielwelt und Zustandsverwaltung.</p>
 *
 * <p>Verwendung:</p>
 * <pre>{@code
 * GameManager manager = new GameManager();
 * manager.startGame(); // beginnt mit Erkundung
 * }</pre>
 *
 * @author Cengiz
 * @since 2025-07-22
 */

public class GameManager {
    private final PlayerCharacter player;
    private final Inventory inventory;
    private final QuestLog questLog;

    public GameManager(PlayerCharacter player, Inventory inventory, QuestLog questLog) {
        this.player = player;
        this.inventory = inventory;
        this.questLog = questLog;
    }

    public void applyPlayerAction(String input) {
        // prüfe, ob Aktion erlaubt ist, modifiziere Spielerzustand, ...
    }

    public PlayerCharacter getPlayer() {
        return player;
    }
}


