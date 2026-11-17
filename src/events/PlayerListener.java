package events;

import model.Track;

public interface PlayerListener {
    void onStopped();
    void onTrackStarted(Track track);
}
