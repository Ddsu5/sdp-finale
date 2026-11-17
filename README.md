# Music Streaming Application

A console-based music streaming app written in Java for the **Software Design Patterns** final project.
There is no real audio: playback is simulated with formatted status lines in the terminal.

## Features

- **Two subscription plans**
  - **Free**: advertisements before each next track, 128 kbps
  - **Premium**: no advertisements, 320 kbps
  - The plan can be changed at any time from the main menu.
- **Search** by artist, title (optional) and source (local, online or both)
- **Playlist**: add tracks from search results, view and remove them
- **Playback** with Next, Previous and Stop
- **Three play modes**: In order (loops), Shuffle (never repeats the current track), Repeat one
- **History** of every track that has started playing

## Design Patterns

| Pattern | Where | Purpose |
|---|---|---|
| **Builder** | `TrackBuilder` | Creates `Track` objects step by step and validates them (title and artist not empty, duration > 0) |
| **Adapter** | `OnlineStorageAdapter` | Converts the raw strings of `OnlineStorage` into `Track` objects behind the `Storage` interface |
| **Facade** | `MusicApp` | Gives `Main` one simple interface over storage, player, listeners and subscription classes |
| **Strategy** | `PlayStrategy`, `SequentialStrategy`, `ShuffleStrategy`, `RepeatOneStrategy` | Switchable play modes used by `Player` |
| **Observer** | `PlayerListener`, `ConsoleDisplay`, `HistoryTracker` | `Player` notifies listeners when a track starts or playback stops |
| **Abstract Factory** | `SubscriptionFactory`, `FreeFactory`, `PremiumFactory` | Creates a matching pair of `AdProvider` and `QualityPolicy` for each plan |

## Project Structure

```
src/
├── Main.java                 console UI (knows only MusicApp and Track)
├── app/
│   └── MusicApp.java         Facade
├── model/
│   ├── Track.java            immutable song (created only via TrackBuilder)
│   ├── TrackBuilder.java     Builder
│   └── Playlist.java
├── source/
│   ├── Storage.java          common interface for music sources
│   ├── LocalStorage.java     built-in tracks (IDs 1-20)
│   ├── OnlineStorage.java    simulated third-party service (raw strings)
│   └── OnlineStorageAdapter.java   Adapter
├── player/
│   ├── Player.java
│   ├── PlayStrategy.java     Strategy interface
│   ├── SequentialStrategy.java
│   ├── ShuffleStrategy.java
│   └── RepeatOneStrategy.java
├── events/
│   ├── PlayerListener.java   Observer interface
│   ├── ConsoleDisplay.java
│   └── HistoryTracker.java
└── plan/
    ├── SubscriptionFactory.java   Abstract Factory
    ├── FreeFactory.java
    ├── PremiumFactory.java
    ├── AdProvider.java
    ├── FreeAdProvider.java
    ├── NoAdProvider.java
    ├── QualityPolicy.java
    ├── Bitrate128.java
    └── Bitrate320.java
```

`Main` only reads input and prints output. `MusicApp` coordinates everything, and every other class has a single responsibility.

## How to Run

Requires **JDK 17 or newer** (any recent JDK should work).

**IntelliJ IDEA**
1. Open the project folder.
2. Right-click `src` and choose *Mark Directory as → Sources Root*.
3. Run `Main`.

**Command line (Linux / macOS)**
```bash
mkdir -p out
javac -d out $(find src -name "*.java")
java -cp out Main
```

**Command line (Windows PowerShell)**
```powershell
mkdir out -Force
javac -encoding UTF-8 -d out (Get-ChildItem -Recurse -Filter *.java src).FullName
java -cp out Main
```

**Command line (Windows cmd)**
```bat
mkdir out
dir /s /b src\*.java > sources.txt
javac -encoding UTF-8 -d out @sources.txt
java -cp out Main
```

If non-English track titles show as `?` in the Windows terminal, run `chcp 65001` first.

## Quick Demo

1. Choose a plan (1 = Free, 2 = Premium).
2. Search: artist `queen`, press Enter to skip the title and Enter again to search both sources.
3. Type a Track ID to add it to your playlist. Repeat for a few tracks.
4. Choose *Play*, then *Next*. On Free an ad is printed before each next track.
5. Change the play mode (Shuffle or Repeat one) and press *Next* again.
6. Open *History* to see every track that has played.
7. Change the plan to Premium: ads disappear and the bitrate changes to 320 kbps.

## Team

| Member              | Responsibility |
|---------------------|---|
| Member A (Iaroslav) | Strategy, Observer: `player/`, `events/` |
| Member B (Ali)      | Builder, Adapter: `source/`, track creation |
| Member C (Daniyal)  | Facade, Abstract Factory: project skeleton, `Main`, `MusicApp`, `plan/` |
