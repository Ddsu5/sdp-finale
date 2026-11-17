package player;

import events.PlayerListener;
import model.Playlist;
import model.Track;
import java.util.ArrayList;
import java.util.List;

// Starter version (Member A refines). Never prints directly.

public class Player {
    private PlayStrategy strategy = new SequentialStrategy();
    private final Playlist playlist;

    private final List<PlayerListener> listeners = new ArrayList<>();
    private int current = -1;


    public Player(Playlist playlist) {
        this.playlist = playlist;
    }


    public void setStrategy(PlayStrategy s){
        this.strategy = s;
    }

    public String modeName() {
        return strategy.name();
    }

    public void addListener(PlayerListener l){
        listeners.add(l);
    }

    public void play() {
        if (playlist.getTracks().isEmpty()){
            return;
        };
        current = 0;
        fireStarted();
    }

    public void next() {
        int size = playlist.getTracks().size();
        if (size == 0) return;
        if (current < 0 || current >= size) {
            play(); return;
        }
        current = strategy.next(current, size);
        fireStarted();
    }

    public void prev(){
        int size = playlist.getTracks().size();
        if (size == 0) return;
        if (current < 0 || current >= size) {
            play(); return;
        }
        current = (current - 1 + size) % size;
        fireStarted();}

    public void stop() {
        current = -1;
        for (PlayerListener l : listeners) l.onStopped();
    }

    private void fireStarted() {
        Track track = playlist.getTracks().get(current);

        for (PlayerListener listener : listeners) {
            listener.onTrackStarted(track);
        }
    }
}
