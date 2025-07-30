package UI;

import state.GameEventListener;

import javax.swing.*;
import java.awt.*;

/**
 * Die Klasse {@code MapScreen} stellt das grafische Interface für die Kartenansicht
 * während des Erkundungsmodus dar.
 *
 * <p>Sie erweitert {@link Screen} und zeigt die aktuelle Spielwelt in einem {@link JTextPane}
 * auf Basis der {@link domain.map.MapData} als zweidimensionale Zeichenkarte.</p>
 *
 * <p>Funktionen:</p>
 * <ul>
 *   <li>{@code createScreen()} – Initialisiert das Fenster, Layout und Textfeld</li>
 *   <li>{@code renderMap()} – Konvertiert das aktuelle Spielfeld in Text und zeigt es zentriert an</li>
 * </ul>
 *
 * <p>Die Darstellung verwendet eine monospaced-Schriftart, um ein rasterbasiertes Layout zu gewährleisten.
 * Spielerposition, NPCs und leere Felder werden anhand von Zeichen angezeigt.</p>
 *
 * @author Cengiz
 * @since 2025-07-22
 */


public class ExploreScreen extends Screen {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ExploreScreen.class);
    private JTextPane mapPane;

    public ExploreScreen(GameEventListener listener) {
        super(listener);
    }

    @Override
    public void createScreen() {
    logger.info("createScreen()");        // Frame Einstellungen
        frame.setSize(displayDimensions);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        // Panel Einstellungen
        panel.setBackground(backgroundColor);
        panel.setLayout(null);

        // Header
        JLabel header = new JLabel("Explore");
        header.setForeground(fontColor);
        header.setFont(headerFont);
        header.setBounds(350, 20, 300, 60);
        header.setBorder(border);
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(header);

        // MapPane statt TextArea
        mapPane = new JTextPane();
        mapPane.setEditable(false);
        mapPane.setFont(new Font("Monospaced", Font.PLAIN, 20));
        mapPane.setForeground(fontColor);
        mapPane.setBackground(backgroundColor);
        mapPane.setOpaque(false);
        mapPane.setBounds(100, 100, 800, 410); // Anpassen je nach Layout
        mapPane.setFocusable(false);
        panel.add(mapPane);

        frame.add(panel);
        frame.setVisible(true);

        //renderMap();
    }

//    public void renderMap() {
//        char[][] tiles = mapData.getTiles();
//        StringBuilder builder = new StringBuilder();
//
//        for (char[] row : tiles) {
//            for (char c : row) {
//                builder.append(c).append(' ');
//            }
//            builder.append('\n');
//        }
//
//        // Text zentrieren
//        StyledDocument doc = mapPane.getStyledDocument();
//        SimpleAttributeSet center = new SimpleAttributeSet();
//        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
//        doc.setParagraphAttributes(0, doc.getLength(), center, false);
//
//        try {
//            mapPane.setText(""); // leeren
//            doc.insertString(0, builder.toString(), null);
//        } catch (BadLocationException e) {
//            e.printStackTrace();
//        }
//    }

//    private void checkForEvent() {
//        // Beispiel: Wenn Spieler bei (10,5) steht → Kampf starten
//        if (playerX == 10 && playerY == 5) {
//            System.out.println("Kampf beginnt!");
//
//            // Fenster schließen
//            closeScreen();
//
//            // Zustand wechseln → z. B. auf FightState
//            GameContext.getInstance().setState(new FightState());
//        }
//
//        // Beispiel: Wenn bei (3,3) → Dialog
//        if (playerX == 3 && playerY == 3) {
//            closeScreen();
//            GameContext.getInstance().setState(new DialogState());
//        }
//    }



}
