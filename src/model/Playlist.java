package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Playlist {
    private final List<Track> tracks = new ArrayList<>();

    /** Returns false if a track with the same ID is already in the playlist. */
    public boolean add(Track track) {
        for (Track t : tracks) {
            if (t.getId() == track.getId()) return false;
        }
        tracks.add(track);
        return true;
    }

    public boolean remove(int id) {
        return tracks.removeIf(t -> t.getId() == id);
    }

    public List<Track> getTracks() {
        return Collections.unmodifiableList(tracks);
    }
}
