package UI.GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Die Klasse {@code StartScreen} stellt das grafische Hauptmenü des Spiels dar.
 *
 * <p>Sie erweitert {@link Screen} und zeigt beim Aufruf von {@code createScreen()}
 * eine einfache Startoberfläche mit einem Titel und einem Button zum Spielstart.</p>
 *
 * <p>Bestandteile des Bildschirms:</p>
 * <ul>
 *   <li>Ein zentrierter Header mit der Beschriftung „Hauptmenü“</li>
 *   <li>Ein Button mit der Aufschrift „Start new Game“</li>
 * </ul>
 *
 * <p>Die Layout-Konfiguration erfolgt manuell über absolute Positionierung.</p>
 *
 * <p>Spätere Erweiterungen könnten Einstellungen, Ladefunktionen oder Credits ergänzen.</p>
 *
 * @author Cengiz
 * @since 2025-07-22
 */


public class MenuScreen extends Screen{
    public void createScreen(){
        // Frame Einstellungen
        frame.setSize(displayDimensions);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        //Alles hinzufügen #####################################

        JLabel Header = new JLabel("Hauptmenü");
        Header.setForeground(fontColor);
        Header.setFont(headerFont);
        Header.setBounds(350, 50, 300, 60);
        Header.setBorder(border);
        // ZENTRIERUNG des Textes im Label
        Header.setHorizontalAlignment(SwingConstants.CENTER);
        Header.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(Header);

        JButton startGameButton = new JButton("Start new Game");
        startGameButton.setForeground(fontColor);
        startGameButton.setFont(normalFont);
        startGameButton.setBounds(400,130,200,50);
        startGameButton.setBackground(backgroundColor);
        startGameButton.setBorder(border);
        startGameButton.setFocusPainted(false);//sonst ist eine box im button
        startGameButton.setHorizontalAlignment(SwingConstants.CENTER);
        startGameButton.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(startGameButton);

        // Panel Einstellungen
        panel.setBackground(backgroundColor);  // Hintergrundfarbe
        panel.setLayout(null);

        frame.add(panel);

        frame.setVisible(true);
    }
}
