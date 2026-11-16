package app;

import events.ConsoleDisplay;
import events.HistoryTracker;
import model.Playlist;
import model.Track;
import player.*;
import plan.*;
import source.*;

import java.util.ArrayList;
import java.util.List;

/** Facade: the only class Main talks to. */
public class MusicApp {
    private final List<Storage> storages = new ArrayList<>();
    private final Playlist playlist;
    private final Player player;
    private final ConsoleDisplay display;
    private final HistoryTracker historyTracker;
    private SubscriptionFactory plan;
    private AdProvider adProvider;
    private List<Track> lastResults = new ArrayList<>();

    // ===== CONSTRUCTOR (C) =====
    public MusicApp() {
        playlist = new Playlist();
        player = new Player(playlist);
        display = new ConsoleDisplay();
        historyTracker = new HistoryTracker();
        player.addListener(display);
        player.addListener(historyTracker);
        storages.add(new LocalStorage());
        storages.add(new OnlineStorageAdapter(new OnlineStorage()));
        changePlan(1); // default: Free
    }

    public List<Track> search(String artist, String title, int source) {
        List<Track> results = new ArrayList<>();
        for (Storage s : storages) {
            boolean wanted = source == 0
                    || (source == 1 && s.name().equals("local"))
                    || (source == 2 && s.name().equals("online"));
            if (wanted) results.addAll(s.search(artist, title));
        }
        lastResults = results;
        return results;
    }

    public boolean addToPlaylist(int id) {
        for (Track t : lastResults) {
            if (t.getId() == id) return playlist.add(t);
        }
        return false;
    }

    public List<Track> getPlaylist() { return playlist.getTracks(); }

    public boolean removeFromPlaylist(int id) { return playlist.remove(id); }

    // ===== PLAYBACK (A) =====
    public void play() { player.play(); }
    public void prev() { player.prev(); }
    public void stop() { player.stop(); }

    public void setMode(int mode) {
        switch (mode) {
            case 2: player.setStrategy(new ShuffleStrategy()); break;
            case 3: player.setStrategy(new RepeatOneStrategy()); break;
            default: player.setStrategy(new SequentialStrategy());
        }
    }

    public String getModeName() { return player.modeName(); }

    public List<Track> getHistory() { return historyTracker.getHistory(); }

    // ===== PLAN (C) =====
    public void changePlan(int choice) {
        plan = (choice == 2) ? new PremiumFactory() : new FreeFactory();
        adProvider = plan.createAdProvider();
        display.setQualityPolicy(plan.createQualityPolicy());
    }

    public String getPlanName() { return plan.planName(); }

    // ===== SHARED: next() = C's ad line + A's player.next() =====
    public void next() {
        String ad = adProvider.nextAd();          // (C)
        if (ad != null) System.out.println(ad);   // (C)
        player.next();                            // (A)
    }
}
