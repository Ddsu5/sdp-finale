package events;

import model.Track;
import java.util.ArrayList;
import java.util.List;

public class HistoryTracker implements PlayerListener {
    private final List<Track> history = new ArrayList<>();

    @Override public void onTrackStarted(Track track) { history.add(track); }
    @Override public void onStopped() { }

    public List<Track> getHistory() { return history; }
}
