package main.UI;

import javax.swing.*;
import java.awt.*;

public class MeinSwingFenster {
    public static void main(String[] args) {
        // Fenster (JFrame) erstellen
        JFrame frame = new JFrame("Mein erstes Fenster");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        // Panel als Inhalt
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Label und Button
        JLabel label = new JLabel("Hallo Welt!");
        label.setForeground(Color.WHITE);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton button = new JButton("OK");
        button.addActionListener(e -> addNewButton(panel, "test"));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);     // kein Fokusrahmen beim Klicken
        button.setBorderPainted(true);     // wenn du trotzdem eine Umrandung willst

        // Komponenten hinzufügen
        panel.add(Box.createVerticalStrut(20)); // Abstand oben
        panel.add(label);
        panel.add(Box.createVerticalStrut(10)); // Abstand zwischen Label und Button
        panel.add(button);

        // Panel dem Fenster hinzufügen
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
    public static void addNewButton(JPanel panel, String text) {
        JButton newButton = new JButton(text);
        newButton.setBackground(Color.BLACK);
        newButton.setForeground(Color.WHITE);
        newButton.setFocusPainted(false);

        // Aktion bei Klick (optional)
        newButton.addActionListener(e -> System.out.println("Button '" + text + "' gedrückt!"));

        panel.add(newButton);
        panel.revalidate(); // Layout neu berechnen
        panel.repaint();    // Fenster neu zeichnen
    }

}
