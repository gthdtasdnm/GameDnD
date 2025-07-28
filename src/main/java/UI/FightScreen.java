package UI;

import state.GameEventListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Dimension;

/**
 * Die Klasse {@code FightScreen} stellt das grafische Interface für Kampfsituationen im Spiel dar.
 *
 * <p>Sie erweitert {@link Screen} und zeigt Informationen über Spieler- und Gegnerstatus sowie
 * interaktive Aktionsbuttons (z. B. Attack, Heal, Block, Dodge).</p>
 *
 * <p>Beim Aufruf von {@code createScreen()} wird ein statischer Bildschirm aufgebaut, bestehend aus:</p>
 * <ul>
 *   <li>Überschrift (Kampftitel)</li>
 *   <li>Kurzbeschreibung des Gegners</li>
 * <li>Lebensanzeige für Spieler und Gegner</li>
 *   <li>Vier Buttons zur Auswahl von Kampfaktionen</li>
 * </ul>
 *
 * <p>Die Buttons sind aktuell funktional über {@code System.out}-Ausgaben verbunden und
 * sollen später mit echter Spiellogik verknüpft werden.</p>
 *
 * @author Cengiz
 * @since 2025-07-22
 */


public class FightScreen extends Screen {

    public FightScreen(GameEventListener listener) {
        super(listener);
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
        JLabel header = new JLabel("Fight");
        header.setForeground(fontColor);
        header.setFont(headerFont);
        header.setBounds(350, 20, 300, 60);
        header.setBorder(border);
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(header);

        // Description
        JLabel description = new JLabel("A Scavenger is Attacking you");
        description.setForeground(fontColor);
        description.setFont(normalFont);
        description.setBounds(350, 100, 300, 60);
        description.setBorder(border);
        description.setHorizontalAlignment(SwingConstants.CENTER);
        description.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(description);

        // Player
        JLabel player = new JLabel("Du 22/25 HP");
        player.setForeground(fontColor);
        player.setFont(normalFont);
        player.setBounds(200, 200, 200, 60);
        player.setBorder(border);
        player.setHorizontalAlignment(SwingConstants.CENTER);
        player.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(player);

        // Player
        JLabel enemy = new JLabel("Scavenger 50/50 HP");
        enemy.setForeground(fontColor);
        enemy.setFont(normalFont);
        enemy.setBounds(600, 200, 200, 60);
        enemy.setBorder(border);
        enemy.setHorizontalAlignment(SwingConstants.CENTER);
        enemy.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(enemy);

        // Interactive Buttons
        // Attack
        JButton attack = new JButton("Attack");
        attack.setForeground(fontColor);
        attack.setFont(normalFont);
        attack.setBackground(backgroundColor);
        attack.setBounds(250, 320, 200, 60);
        attack.setFocusPainted(false);
        attack.setPreferredSize(new Dimension(200, 28));  // flacher Button
        attack.setMaximumSize(new Dimension(200, 28));    // gleich festsetzen
        attack.addActionListener(e -> System.out.println("attack"));// Beispiel: Button schreibt eigenen Text in den Dialog
        panel.add(attack);

        // Heal
        JButton heal = new JButton("Heal");
        heal.setForeground(fontColor);
        heal.setFont(normalFont);
        heal.setBackground(backgroundColor);
        heal.setBounds(550, 320, 200, 60);
        heal.setFocusPainted(false);
        heal.setPreferredSize(new Dimension(200, 28));  // flacher Button
        heal.setMaximumSize(new Dimension(200, 28));    // gleich festsetzen
        heal.addActionListener(e -> System.out.println("heal"));// Beispiel: Button schreibt eigenen Text in den Dialog
        panel.add(heal);

        // Attack
        JButton block = new JButton("Block");
        block.setForeground(fontColor);
        block.setFont(normalFont);
        block.setBackground(backgroundColor);
        block.setBounds(250, 400, 200, 60);
        block.setFocusPainted(false);
        block.setPreferredSize(new Dimension(200, 28));  // flacher Button
        block.setMaximumSize(new Dimension(200, 28));    // gleich festsetzen
        block.addActionListener(e -> System.out.println("block"));// Beispiel: Button schreibt eigenen Text in den Dialog
        panel.add(block);

        // Heal
        JButton dodge = new JButton("Dodge");
        dodge.setForeground(fontColor);
        dodge.setFont(normalFont);
        dodge.setBackground(backgroundColor);
        dodge.setBounds(550, 400, 200, 60);
        dodge.setFocusPainted(false);
        dodge.setPreferredSize(new Dimension(200, 28));  // flacher Button
        dodge.setMaximumSize(new Dimension(200, 28));    // gleich festsetzen
        dodge.addActionListener(e -> System.out.println("dodge"));// Beispiel: Button schreibt eigenen Text in den Dialog
        panel.add(dodge);



        frame.add(panel);
        frame.setVisible(true);
    }
}
