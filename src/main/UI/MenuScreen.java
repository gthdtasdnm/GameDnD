package main.UI;

import javax.swing.*;
import java.awt.*;

public class MenuScreen extends JPanel {
    public MenuScreen(GameFrame game) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.BLACK);

        JLabel title = new JLabel("🎮 Mein Spielmenü");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Monospaced", Font.BOLD, 22));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JButton exploreButton = new JButton("🧭 Zur Karte (Explore)");
        exploreButton.setAlignmentX(CENTER_ALIGNMENT);
        exploreButton.addActionListener(e -> game.showScreen("explore"));

        JButton fightButton = new JButton("⚔️ Zum Kampf (Fight)");
        fightButton.setAlignmentX(CENTER_ALIGNMENT);
        fightButton.addActionListener(e -> game.showScreen("fight"));

        JButton dialogButton = new JButton("💬 Zum Dialog (Dialog)");
        dialogButton.setAlignmentX(CENTER_ALIGNMENT);
        dialogButton.addActionListener(e -> game.showScreen("dialog"));

        add(Box.createVerticalStrut(40));
        add(title);
        add(Box.createVerticalStrut(40));
        add(exploreButton);
        add(Box.createVerticalStrut(10));
        add(fightButton);
        add(Box.createVerticalStrut(10));
        add(dialogButton);
        add(Box.createVerticalGlue());
    }
}

