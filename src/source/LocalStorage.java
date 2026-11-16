package source;

import model.Track;
import model.TrackBuilder;
import java.util.ArrayList;
import java.util.List;

// STUB (Member B replaces with the full 20 tracks, IDs 1-20)
public class LocalStorage implements Storage {
    private final List<Track> tracks = new ArrayList<>();

    public LocalStorage() {
        tracks.add(new TrackBuilder().id(1).title("Bohemian Rhapsody").artist("Queen").genre("rock").durationSec(354).build());
        tracks.add(new TrackBuilder().id(2).title("Imagine").artist("John Lennon").genre("pop").durationSec(183).build());
        tracks.add(new TrackBuilder().id(3).title("Hotel California").artist("Eagles").genre("rock").durationSec(391).build());
    }

    @Override public String name() { return "local"; }

    @Override
    public List<Track> search(String artist, String title) {
        List<Track> out = new ArrayList<>();
        for (Track t : tracks) {
            if (t.getArtist().toLowerCase().contains(artist.toLowerCase())
                    && t.getTitle().toLowerCase().contains(title.toLowerCase())) out.add(t);
        }
        return out;
    }
}
