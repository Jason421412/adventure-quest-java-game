# ⚔️ Adventure Quest

A 2D top-down dungeon-crawler game built with **Java Swing** as a first-year programming assignment.  
Navigate a monster-filled dungeon, collect loot, and survive long enough to clear every room.

---

## 📸 Screenshots

> *(Add screenshots here — see §How to Run for what to capture)*

---

## 🎮 Gameplay

1. **Create your hero** — enter a name, set HP (50–150) and Attack Power (10–30), pick a class  
2. **Choose a difficulty** — Easy, Medium, or Difficult scales the number and strength of monsters  
3. **Explore 3 dungeon rooms** — navigate between rooms using the `<<` and `>>` buttons  
4. **Fight monsters** — walk into any enemy to trigger turn-based combat  
5. **Collect items** — walk over loot on the floor to add it to your inventory automatically  
6. **Win or lose** — defeat all monsters in every room to win; reach 0 HP and it's game over  
7. **Leaderboard** — your score is saved and ranked against previous runs at the end of every game

---

## 🧙 Hero Classes

All three classes share the same combat stats (set by the player at creation). They differ visually through their directional sprites.

| Class   | Sprites |
|---------|---------|
| Warrior | ✅ 4-directional |
| Archer  | ✅ 4-directional |
| Mage    | ✅ 4-directional |

> Class-specific abilities are a planned future feature.

---

## 🐉 Monsters

Monsters roam each room autonomously, changing direction randomly every second.

| Monster  | Base HP | Base ATK |
|----------|---------|----------|
| Goblin   | 70      | 40       |
| Skeleton | 50      | 20       |
| Zombie   | 60      | 30       |

Stats are modified by the chosen difficulty level.

---

## 🃏 Items

Items spawn at random positions in each room. Walk over them to collect.  
Use items during combat from the **Use Item** option.

| Item   | Effect           |
|--------|------------------|
| Axe    | +30 Attack Power |
| Dagger | +20 Attack Power |
| Potion | +50 HP           |

---

## ⚔️ Combat

When you walk into a monster, a battle dialog appears with three options:

- **Attack** — deal your Attack Power as damage; the monster counter-attacks if it survives
- **Flee** — escape to a safe position; the monster remains in the room
- **Use Item** — pick an item from your inventory to apply its effect, then continue fighting

Combat repeats until one side is defeated or you flee.

---

## 🏆 Scoring

| Action          | Points |
|-----------------|--------|
| Defeat a monster | +50   |
| Collect an item  | +10   |

The top 5 scores are ranked and displayed at the end of each game. Scores are saved to `high_scores.txt` in the working directory.

---

## 🎚️ Difficulty

| Level    | Monsters per Room | Stat Modifier |
|----------|--------------------|---------------|
| Easy     | 1                  | −20 HP, −10 ATK |
| Medium   | 2                  | Base stats      |
| Difficult | 3                 | +15 HP, +15 ATK |

---

## 🕹️ Controls

| Input            | Action             |
|------------------|--------------------|
| ↑ ↓ ← →          | Move hero          |
| `<<` / `>>`      | Navigate rooms     |
| Mouse (buttons)  | All menus and combat dialogs |

---

## 🧰 Tech Stack

| Component    | Technology                                    |
|--------------|-----------------------------------------------|
| Language     | Java 21                                       |
| GUI          | Java Swing (`JFrame`, `JPanel`, `JList`, `JScrollPane`) |
| Rendering    | Java AWT `Graphics2D`, `BufferedImage`        |
| Input        | `java.awt.event.KeyListener`                  |
| Game Loop    | `Thread` + delta-time via `System.nanoTime()` |
| Image Loading | `javax.imageio.ImageIO` via classpath         |
| Persistence  | `BufferedReader` / `BufferedWriter` (flat file) |
| IDE          | IntelliJ IDEA (no Maven/Gradle)               |

---

## 🗂️ Project Structure

```
src/
├── entity/             # Game object hierarchy
│   ├── entity.java     # Base class: position, speed, direction, sprites
│   ├── Hero.java       # Abstract hero: movement, collision, combat
│   ├── Warrior.java    # Concrete hero subclass
│   ├── Archer.java     # Concrete hero subclass
│   ├── Mage.java       # Concrete hero subclass
│   ├── Monster.java    # Abstract monster: random-walk AI, combat
│   ├── Goblin.java     # Concrete monster subclass
│   ├── Skeleton.java   # Concrete monster subclass
│   └── Zombie.java     # Concrete monster subclass
└── main/               # Application and engine layer
    ├── util/
    │   └── Assets.java         # Classpath image loader (JAR-safe)
    ├── main.java               # Entry point
    ├── menu.java               # Main menu, hero creation, difficulty selection
    ├── GamePanel.java          # 60 FPS game loop, rendering, collision detection
    ├── Dungeon.java            # Procedural dungeon generator
    ├── Room.java               # Room container (monsters, item, background)
    ├── Battle.java             # Turn-based combat system
    ├── Item.java               # Item positioning and rendering
    ├── InventoryPanel.java     # Sidebar with custom image cell renderer
    ├── KeyHandler.java         # Arrow key input handler
    └── GameStatus.java         # Score tracking and leaderboard R/W
```

---

## 🚀 How to Run

**Requirement:** JDK 21 or later

1. Clone the repository
2. Open the project in **IntelliJ IDEA**
3. In the Project panel, right-click `Adventure Quest/resources/` → **Mark Directory as → Resources Root**
4. Run `src/main/main.java`

> If room backgrounds or sprites do not appear, the Resources Root step was likely skipped.

---

## ⚠️ Known Limitations

- Hero classes are visually distinct but mechanically identical — class-specific abilities are not yet implemented
- Monster movement is random direction changes every second — no pathfinding toward the player
- No build system (Maven/Gradle) — relies on IntelliJ IDEA's native compiler
- No unit tests
- Score file (`high_scores.txt`) grows indefinitely — no cap on total entries

---

## 👥 Credits

Built as a WIX1002 (Fundamentals of Programming) assignment  
Faculty of Computer Science & Information Technology, Universiti Malaya

---

## 📄 License

This project is licensed under the [MIT License](LICENSE).
