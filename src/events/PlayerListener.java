package events;

import model.Track;

public interface PlayerListener {
    void onTrackStarted(Track track);
    void onStopped();
}
