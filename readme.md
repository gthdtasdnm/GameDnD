# Textbasiertes RPG in Java

Dieses Projekt ist ein **textbasiertes RPG-Spiel**, das vollständig in Java entwickelt wird. Es dient als Lernplattform für **sauberen Code**, die Anwendung von **Design Patterns** und die konsequente Umsetzung der **SOLID-Prinzipien**.

---

## 🔍 Projektbeschreibung

Das Spiel ist modular aufgebaut und verwendet bereits folgende **Design Patterns**:

- **State Pattern** – zur Verwaltung der verschiedenen Spielzustände (Kampf, Dialog, Erkundung usw.).
- **Factory Pattern** – zur dynamischen Erstellung von Objekten wie Charakteren oder Items.

Ziel ist es, das Projekt als Beispiel für gutes objektorientiertes Design zu nutzen und sukzessive weitere Patterns einzubauen. Besonders im Fokus steht dabei der didaktische Wert: Das Projekt soll helfen, die **SOLID-Prinzipien** praktisch anzuwenden und zu verinnerlichen.

---

## 🔧 Projektstruktur

Die Projektstruktur folgt einer klaren Trennung nach Verantwortlichkeiten:

### 📁 core
Zentrale Spiellogik und Kontrollstruktur:

- `GameManager.java` – Koordiniert den Spielablauf.
- `GameLoop.java` – Führt das Hauptspiel in Schleifen aus.
- `PlayerController.java` – Verarbeitet Spieleraktionen.
- `StateManager.java` – Verwalten und Umschalten zwischen Spielzuständen.
- `InputHandler.java` – Verarbeitung der Benutzereingaben.
- `factory/` – Enthält Factories zur Erzeugung von Spielfiguren und Objekten.

### 📁 data
Zuständig für das Laden und Verwalten persistenter Daten:

- `CharacterLoader`, `ItemLoader` – Laden von JSON- oder anderen Datenquellen.
- `CharacterRepository`, `ItemRepository` – Zugriff auf geladene Daten.

### 📁 domain
Enthält die Fachlogik des Spiels – die Spielwelt selbst:

- `character/` – Spieler, NPCs, Gegner usw.
- `dialog/` – Dialogsystem und Sprechakte.
- `inventory/` – Inventarverwaltung.
- `item/` – Waffen, Tränke, Gegenstände.
- `map/` – Karten- und Positionsdaten.
- `quest/` – Aufgaben, Ziele, Questlogik.

### 📁 state
Implementierung der verschiedenen Spielzustände mithilfe des State Patterns:

- `ExploreState`, `FightState`, `DialogState` – spezialisierte Zustände.
- `GameState` – Abstrakte Basisklasse für Zustände.
- `GameContext` – Kontextklasse, die aktuellen Zustand hält.

### 📁 UI
Benutzerschnittstelle:

- `Input/` – Eingabeverarbeitung.
- `GUI/` – Ausgabekomponenten (z. B. Konsolendarstellung oder spätere GUI-Erweiterungen).

---

## 🧱 SOLID-Prinzipien im Projekt

| Prinzip | Anwendung im Projekt |
|--------|------------------------|
| **S** – Single Responsibility Principle | Jede Klasse hat genau eine klar umrissene Aufgabe. |
| **O** – Open/Closed Principle | Neue Zustände, Items usw. können durch Vererbung/Komposition hinzugefügt werden. |
| **L** – Liskov Substitution Principle | Polymorphie wird korrekt angewendet – z. B. bei Zuständen und Items. |
| **I** – Interface Segregation Principle | Interfaces werden zielgerichtet eingesetzt (z. B. für interaktive Objekte). |
| **D** – Dependency Inversion Principle | Höhere Module hängen nicht direkt von konkreten Implementierungen ab – z. B. via Factory oder Interface. |

---

## 🚀 Zielsetzung

Dieses Projekt verfolgt das Ziel, ein **robustes, erweiterbares und gut strukturiertes** Java-Spiel zu entwickeln. Es soll langfristig um folgende Elemente erweitert werden:

- Grafische Benutzeroberfläche (z. B. Swing oder JavaFX)
- KI-Gegner
- Speichersystem
- Online-Mehrspielermodus (experimentell)
- Weitere Design Patterns wie Observer, Strategy, Command usw.


