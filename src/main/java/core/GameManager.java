package core;

import domain.character.PlayerCharacter;
import domain.character.QuestLog;
import domain.inventory.Inventory;
import state.DialogState;
import state.ExploreState;
import state.FightState;


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
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(GameManager.class);
    private final PlayerCharacter player;
    private final Inventory inventory;
    private final QuestLog questLog;

    public GameManager(PlayerCharacter player, Inventory inventory, QuestLog questLog) {
        this.player = player;
        this.inventory = inventory;
        this.questLog = questLog;
    }

    public void applyPlayerAction(String input) {
    logger.info("applyPlayerAction()");        // prüfe, ob Aktion erlaubt ist, modifiziere Spielerzustand, ...
    }

    public PlayerCharacter getPlayer() {
    logger.info("getPlayer()");        return player;
    }
}


