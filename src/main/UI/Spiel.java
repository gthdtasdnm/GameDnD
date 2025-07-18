package main.UI;

import javax.swing.*;

public class Spiel {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameFrame game = new GameFrame();
            game.setVisible(true);
            game.showScreen("menu"); // Start mit Menü
        });
    }
}


