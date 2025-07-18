package UI;

import map.MapData;
import state.DialogState;
import state.FightState;
import state.GameContext;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MapScreen extends Screen {
    private final int mapWidth = 65;
    private final int mapHeight = 15;
    private char[][] map;
    private int playerX = 1;
    private int playerY = 1;
    private final MapData mapData;

    public MapScreen(MapData mapData) {
        this.mapData = mapData;
    }

    private JTextPane mapPane;

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

        // Tastensteuerung
        frame.addKeyListener(new ArrowKeyListener(this));
    }

//    private void initMap() {
//        map = new char[mapHeight][mapWidth];
//        for (int y = 0; y < mapHeight; y++) {
//            for (int x = 0; x < mapWidth; x++) {
//                map[y][x] = (x == 0 || x == mapWidth - 1 || y == 0 || y == mapHeight - 1) ? '#' : '.';
//            }
//        }
//        map[5][10] = 'S';
//        map[3][3] = 'D';
//        map[playerY][playerX] = '@';
//    }

    private void renderMap() {
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


    public void movePlayer(int dx, int dy) {
        int newX = playerX + dx;
        int newY = playerY + dy;
        if (map[newY][newX] != '#') {
            map[playerY][playerX] = '.';
            playerX = newX;
            playerY = newY;
            map[playerY][playerX] = '@';
            renderMap();

            //checkForEvent();  // NEU
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
