package state;

/**
 * Das Interface {@code GameState} definiert die grundlegende Struktur für Spielzustände
 * im Rahmen des State-Patterns.
 *
 * <p>Jeder konkrete Zustand wie {@code ExploreState}, {@code FightState} oder {@code DialogState}
 * implementiert dieses Interface, um definierte Übergänge im Spielverlauf zu ermöglichen.</p>
 *
 * <ul>
 *   <li>{@code enter()} – wird beim Aktivieren des Zustands aufgerufen</li>
 *   <li>{@code update()} – enthält die fortlaufende Spiellogik</li>
 *   <li>{@code exit()} – wird beim Verlassen des Zustands aufgerufen</li>
 * </ul>
 *
 * <p>Die Verwaltung erfolgt über den {@link GameContext}.</p>
 *
 * @author Cengiz
 * @since 2025-07-22
 */


public interface GameState {
    void enter();
    void update();
    void exit();

    String getDescription();
}
