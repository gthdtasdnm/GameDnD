package DialogTest;

import java.util.*;

public class MainT {
    public static void main(String[] args) {
        DialogEngineT engine = new DialogEngineT();
        Set<String> knownDialogIds = new HashSet<>();

        // 📘 Dialog 1: Brief an Feuermagier
        DialogInstanceT diegoBrief = new DialogInstanceT(
                "DIA_Diego_Brief",
                "Ich habe einen Brief für den obersten Feuermagier.",
                false, // nicht permanent
                false,
                () -> true,
                () -> {
                    engine.queueLine("Held", "Diego", "Ich habe einen Brief für den obersten Feuermagier.");
                    engine.queueLine("Diego", "Held", "So...?");
                    engine.queueLine("Held", "Diego", "Ein Magier hat ihn mir gegeben, kurz bevor sie mich reingeworfen haben.");
                    engine.queueLine("Diego", "Held", "Du kannst von Glück sagen, dass ich mich bei den Magiern nicht mehr blicken lassen kann.");
                }
        );

        // 📘 Dialog 2: Arbeit suchen
        DialogInstanceT diegoJob = new DialogInstanceT(
                "DIA_Diego_Job",
                "Hast du Arbeit für mich?",
                false,
                false,
                () -> true,
                () -> {
                    engine.queueLine("Held", "Diego", "Hast du Arbeit für mich?");
                    engine.queueLine("Diego", "Held", "Du siehst nicht gerade aus wie jemand, der viel Erfahrung hat.");
                    engine.queueLine("Held", "Diego", "Ich lerne schnell.");
                    engine.queueLine("Diego", "Held", "Na gut. Bring mir 10 Fleischwanzen-Kiefer.");
                }
        );

        // 📜 Dialogoptionen des NPC
        List<DialogInstanceT> dialogOptions = List.of(diegoBrief, diegoJob);

        // 📋 Wiederholt anzeigen, bis keine Option mehr vorhanden
        while (true) {
            System.out.println("\n📜 Verfügbare Dialogoptionen:");
            List<DialogInstanceT> available = new ArrayList<>();
            for (DialogInstanceT di : dialogOptions) {
                if (!di.isPermanent() && knownDialogIds.contains(di.getId())) continue;
                if (di.isAvailable()) available.add(di);
            }

            if (available.isEmpty()) {
                System.out.println("Keine Optionen mehr verfügbar.");
                break;
            }

            for (int i = 0; i < available.size(); i++) {
                System.out.println((i + 1) + ". " + available.get(i).getDescription());
            }

            System.out.print("▶ Wähle Option (0 zum Beenden): ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt() - 1;

            if (choice == -1) {
                break;
            }

            if (choice >= 0 && choice < available.size()) {
                DialogInstanceT chosen = available.get(choice);
                chosen.execute();
                knownDialogIds.add(chosen.getId());
                engine.run();
            } else {
                System.out.println("❌ Ungültige Auswahl.");
            }
        }

        System.out.println("\n✅ Dialog beendet.");
    }
}




