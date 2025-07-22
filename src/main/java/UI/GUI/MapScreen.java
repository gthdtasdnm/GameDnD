package UI.GUI;

import domain.map.MapData;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class MapScreen extends Screen {
    private final MapData mapData;
    private JTextPane mapPane;

    public MapScreen(MapData mapData) {
        this.mapData = mapData;
    }

    @Override
    public void createScreen() {
        // Frame Einstellungen
        frame.setSize(displayDimensions);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        // Panel Einstellungen
        panel.setBackground(backgroundColor);
        panel.setLayout(null);

        // Header
        JLabel header = new JLabel("Map");
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

        renderMap();
    }

    public void renderMap() {
        char[][] tiles = mapData.getTiles();
        StringBuilder builder = new StringBuilder();

        for (char[] row : tiles) {
            for (char c : row) {
                builder.append(c).append(' ');
            }
            builder.append('\n');
        }

        // Text zentrieren
        StyledDocument doc = mapPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        try {
            mapPane.setText(""); // leeren
            doc.insertString(0, builder.toString(), null);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

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
