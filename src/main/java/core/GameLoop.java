package core;

/**
 * Die {@code GameLoop}-Klasse steuert den Hauptablauf des Spiels.
 *
 * <p>Aktuell führt sie die Spielaktionen sequenziell aus und dient
 * als Einstiegspunkt für die Spielausführung.</p>
 *
 * <p>Zukünftige Erweiterungen:</p>
 * <ul>
 *   <li>Einführung von Game States (z. B. Exploration, Combat, Dialogue)</li>
 *   <li>Tick- oder Frame-basiertes Ereignissystem</li>
 *   <li>Unterstützung für Multiplayer über Netzwerk</li>
 *   <li>Pausier- und speicherbarer Spielzustand</li>
 * </ul>
 *
 * <p>Verwendung:</p>
 * <pre>{@code
 * GameLoop gameLoop = new GameLoop();
 * gameLoop.run();
 * }</pre>
 *
 * @author Cengiz
 * @since 2025-07-22
 */

public class GameLoop {
    public void run(){
        boolean running = false;
        Object dt = null; //Zeit Delta
        while(running){
            //dt = tNOW - tLAST_UPDATE
            //tLAST_UPDATE += dt
            update(dt);
            draw();
        }
    }

    private void draw() {

    }

    private void update(Object dt) {

    }
}
