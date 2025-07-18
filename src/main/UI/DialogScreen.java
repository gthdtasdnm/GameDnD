package main.UI;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DialogScreen extends JPanel {
    private int currentLine = 0;
    private final JTextArea dialogArea;
    private final List<String> dialogLines = List.of(
            "Hallo Reisender, willkommen in dieser Welt.",
            "Ich habe auf dich gewartet.",
            "Die Dunkelheit breitet sich aus…",
            "Du musst den Kristall finden, bevor es zu spät ist!"
    );

    public DialogScreen(GameFrame game) {
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        // Dialogtextfeld
        dialogArea = new JTextArea();
        dialogArea.setEditable(false);
        dialogArea.setLineWrap(true);
        dialogArea.setWrapStyleWord(true);
        dialogArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
        dialogArea.setForeground(Color.WHITE);
        dialogArea.setBackground(Color.BLACK);
        dialogArea.setMargin(new Insets(20, 20, 20, 20));
        dialogArea.setText(dialogLines.get(0)); // erste Zeile

        JScrollPane scrollPane = new JScrollPane(dialogArea);
        add(scrollPane, BorderLayout.CENTER);

        // Weiter-Button unten
        JButton nextButton = new JButton("Weiter");
        nextButton.addActionListener(e -> {
            currentLine++;
            if (currentLine < dialogLines.size()) {
                dialogArea.setText(dialogLines.get(currentLine));
            } else {
                game.showScreen("explore"); // zurück zur Karte
                currentLine = 0; // reset für nächstes Mal
                dialogArea.setText(dialogLines.get(0));
            }
        });

        add(nextButton, BorderLayout.SOUTH);
    }
}

