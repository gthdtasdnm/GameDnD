# Projekt: Textbasiertes RPG-Spiel in Java

## 🧾 Projektbeschreibung

Dieses Projekt ist ein **textbasiertes Rollenspiel (RPG)**, das vollständig in Java entwickelt wurde. Ziel ist es, ein spielbares, aber auch didaktisch wertvolles Spielsystem zu schaffen, das sowohl das Erkunden einer Welt als auch Interaktionen mit Charakteren und Kämpfe ermöglicht.

Der Spielverlauf orientiert sich an klassischen Rollenspielen wie Gothic oder Dungeons & Dragons – jedoch in einer rein textbasierten und modularen Umgebung mit einer grafischen Oberfläche durch Java Swing. Der Spieler bewegt sich über eine ASCII-basierte Karte, trifft Charaktere, kämpft gegen Gegner und sammelt Items.

Das Spiel wurde nach modernen Softwarearchitekturprinzipien konzipiert und implementiert – insbesondere den **SOLID-Prinzipien**, die Modularität, Testbarkeit und Erweiterbarkeit sicherstellen.

---

## 🔧 Strukturüberblick

Das Projekt ist in mehrere logisch getrennte Pakete unterteilt:

### 1. `domain.character`

- **Character** *(abstrakt)*: Basisklasse mit grundlegenden Attributen
- **PlayerCharacter**, **NPC**, **Enemy**: Konkrete Implementierungen
- Enthält Werte wie HP, Stärke, Inventar etc.

### 2. `domain.item`

- **Item** *(abstrakt)*: Basis für alle Items
- **Armor**: Rüstungen mit Slot-Zuweisung (HEAD, CHEST, ...)
- **Usable** *(Interface)*: z. B. Heiltränke
- **ItemFactory**: Erzeugt Items aus JSON-Daten

### 3. `domain.inventory`

- **Inventory**: Beinhaltet normale Items
- **Equipment**: Beinhaltet Rüstungsgegenstände

### 4. `domain.map`

- **MapData**: 2D-Darstellung der Spielwelt mit Tiles

### 5. `domain.quest`

- **Quest**: Aufgaben mit Belohnungen, Beschreibung, Zielen

### 6. `domain.dialog`

- **DialogInstance**: Stellt einen einzelnen Dialog dar mit auswählbaren Optionen

### 7. `core`

- **GameManager**: Steuert den Spielablauf
- **PlayerController**: Bewegt die Spielfigur auf der Karte

### 8. `state` *(State Pattern)*

- **GameState** *(Interface)*: Zustandsübergänge (`enter`, `update`, `exit`)
- **ExploreState**: Spieler erkundet Karte
- **FightState**: Kampfmodus
- **DialogState**: Gespräch mit NPCs
- **GameContext** *(Singleton)*: Verwalter des aktuellen Zustands

### 9. `UI.GUI`

- **Screen** *(abstrakt)*: Definiert Grundfunktionen aller Bildschirme
- **StartScreen**, **MapScreen**, **DialogScreen**, **FightScreen**: Verschiedene UI-Zustände
- **ModernScrollBarUI**: Custom Scrollbar

### 10. `UI.Input`

- **ArrowKeyListener**: Tastatureingabe zur Bewegung

---

## 📂 Diagramm- und Datenstruktur

Alle Projektbegleitmaterialien wie Klassendiagramme oder Architekturentwürfe sollten im Verzeichnis:

