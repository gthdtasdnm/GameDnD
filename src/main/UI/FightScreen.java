package main.UI;

import javax.swing.*;
import java.awt.*;

public class FightScreen extends JPanel {

    public FightScreen(GameFrame game) {
        setLayout(new BorderLayout());
        setBackground(Color.DARK_GRAY);

        // Titel oben
        JLabel label = new JLabel("⚔️ Kampf beginnt!", SwingConstants.CENTER);
        label.setFont(new Font("Monospaced", Font.BOLD, 24));
        label.setForeground(Color.WHITE);
        add(label, BorderLayout.NORTH);

        // Kampfinfos (später ersetzen durch Lebensbalken usw.)
        JTextArea kampfLog = new JTextArea("Kampfprotokoll wird hier angezeigt...");
        kampfLog.setEditable(false);
        kampfLog.setBackground(Color.BLACK);
        kampfLog.setForeground(Color.WHITE);
        kampfLog.setFont(new Font("Monospaced", Font.PLAIN, 14));
        kampfLog.setMargin(new Insets(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(kampfLog);
        scrollPane.setPreferredSize(new Dimension(400, 200));
        add(scrollPane, BorderLayout.CENTER);

        // Button unten zum Zurückkehren
        JButton backButton = new JButton("Zurück zur Karte");
        backButton.addActionListener(e -> game.showScreen("explore"));
        add(backButton, BorderLayout.SOUTH);
    }
}
