package UI.GUI;

import state.GameEventListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

/**
 * Die abstrakte Klasse {@code Screen} bildet die Grundlage für alle GUI-Bildschirme im Spiel.
 *
 * <p>Sie stellt vordefinierte Design-Elemente wie Fenstergröße, Schriftarten, Farben und Rahmen bereit,
 * um ein einheitliches Erscheinungsbild zu gewährleisten.</p>
 *
 * <p>Enthält zentrale GUI-Komponenten wie:</p>
 * <ul>
 *   <li>{@link javax.swing.JFrame} – das Fenster</li>
 *   <li>{@link javax.swing.JPanel} – die Zeichenfläche</li>
 *   <li>Design-Parameter wie Farben, Schriftgrößen und Rahmen</li>
 * </ul>
 *
 * <p>Abgeleitete Klassen (z. B. {@link DialogScreen}, {@link ExploreScreen}, {@link FightScreen})
 * müssen die Methode {@code createScreen()} implementieren.</p>
 *
 * <p>Zusätzlich bietet die Klasse {@code closeScreen()} zum Schließen des Fensters
 * sowie {@code getFrame()} für externen Zugriff.</p>
 *
 * @author Cengiz
 * @since 2025-07-22
 */


public abstract class Screen {
    protected JFrame frame = new JFrame();
    protected JPanel panel = new JPanel();

    protected final GameEventListener listener;

    public Screen(GameEventListener listener){
        this.listener = listener;
    }


    //Design preset
    protected Dimension displayDimensions = new Dimension(1000, 600);
    protected Color fontColor = Color.WHITE;
    protected Color backgroundColor = Color.BLACK;
    protected Font headerFont = new Font("Arial", Font.PLAIN, 40);
    protected Font normalFont = new Font("Arial", Font.PLAIN, 20);
    protected LineBorder border = new LineBorder(Color.WHITE, 2);


    abstract public void createScreen();

    public Component getFrame() {return frame;}

    public void closeScreen() {
        frame.dispose();
    }


}

