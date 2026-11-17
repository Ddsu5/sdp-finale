import app.MusicApp;
import model.Track;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner in = new Scanner(System.in);
    private static final MusicApp app = new MusicApp();

    public static void main(String[] args) {
        System.out.println("=== Music Streaming ===");
        choosePlan();

        boolean running = true;
        while (running) {
            printStatusBar();
            System.out.println("1. Search music");
            System.out.println("2. My playlist");
            System.out.println("3. Play");
            System.out.println("4. History");
            System.out.println("5. Change plan");
            System.out.println("0. Exit");
            switch (readInt("Choose: ")) {
                case 1: searchScreen(); break;
                case 2: playlistScreen(); break;
                case 3: playbackScreen(); break;
                case 4: historyScreen(); break;
                case 5: choosePlan(); break;
                case 0: running = false; break;
                default: System.out.println("Invalid option.");
            }
        }
        System.out.println("Goodbye!");
    }

//SCREENS
    private static void choosePlan() {
        System.out.println("\nSelect plan:");
        System.out.println("1. Free    (ads, 128 kbps)");
        System.out.println("2. Premium (no ads, 320 kbps)");
        int c = readInt("Choose: ");
        app.changePlan(c == 2 ? 2 : 1);
        System.out.println("Plan: " + app.getPlanName());
    }

    private static void printStatusBar() {
        System.out.println("\n[Plan: " + app.getPlanName()
                + " | Mode: " + app.getModeName()
                + " | Tracks: " + app.getPlaylist().size() + "]");
    }

    private static void searchScreen() {
        System.out.print("Artist: ");
        String artist = in.nextLine().trim();
        System.out.print("Title (Enter to skip): ");
        String title = in.nextLine().trim();
        System.out.print("Source (1. Local, 2. Online, Enter for both): ");
        String s = in.nextLine().trim();
        int source;
        if (s.equals("1")) {
            source = 1;
        } else if (s.equals("2")) {
            source = 2;
        } else {
            source = 0;
        }

        List<Track> results = app.search(artist, title, source);
        if (results.isEmpty()) {
            System.out.println("No tracks found.");
            return;
        }

        printTable(results);
        int id = readInt("Enter Track ID to add (0 to go back): ");
        if (id != 0) {
            System.out.println(app.addToPlaylist(id)
                    ? "Added to playlist."
                    : "Not added (invalid ID or already in playlist).");
        }
    }

    private static void playlistScreen() {
        List<Track> tracks = app.getPlaylist();
        if (tracks.isEmpty()) {
            System.out.println("Your playlist is empty");
            return;
        }
        printTable(tracks);
        int id = readInt("Enter Track ID to remove (0 to go back): ");
        if (id != 0) {
            System.out.println(app.removeFromPlaylist(id) ? "Removed." : "ID not found.");
        }
    }


    private static void playbackScreen() {
        if (app.getPlaylist().isEmpty()) {
            System.out.println("Your playlist is empty");
            return;
        }
        app.play();
        boolean playing = true;
        while (playing) {
            System.out.println("1. Next  2. Previous  3. Change play mode  4. Stop");
            switch (readInt("Choose: ")) {
                case 1: app.next(); break;
                case 2: app.prev(); break;
                case 3: changeMode(); break;
                case 4: app.stop(); playing = false; break;
                default: System.out.println("Invalid option.");
            }
        }
    }

    private static void changeMode() {
        System.out.println("1. In order  2. Shuffle  3. Repeat one");
        app.setMode(readInt("Choose: "));
        System.out.println("Mode: " + app.getModeName());
    }

    private static void historyScreen() {
        List<Track> history = app.getHistory();
        if (history.isEmpty()) {
            System.out.println("No history yet.");
            return;
        }
        for (int i = 0; i < history.size(); i++) {
            System.out.println((i + 1) + ". " + history.get(i).displayName());
        }
    }

    // ---------- helpers ----------
    private static void printTable(List<Track> tracks) {
        System.out.printf("%-4s %-28s %-20s %s%n", "ID", "Title", "Artist", "Duration");
        for (Track t : tracks) {
            System.out.printf("%-4d %-28s %-20s %s%n",
                    t.getId(), t.getTitle(), t.getArtist(), t.formattedDuration());
        }
    }

    private static int readInt(String prompt) {
        System.out.print(prompt);
        try {
            return Integer.parseInt(in.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
