package source;

import model.Track;
import model.TrackBuilder;
import java.util.ArrayList;
import java.util.List;

// STUB (Member B): parses raw strings into Tracks via TrackBuilder
public class OnlineStorageAdapter implements Storage {
    private final OnlineStorage online;

    public OnlineStorageAdapter(OnlineStorage online) { this.online = online; }

    @Override public String name() { return "online"; }

    @Override
    public List<Track> search(String artist, String title) {
        List<Track> out = new ArrayList<>();
        for (String raw : online.fetchAll()) {
            Track t = parse(raw);
            if (t.getArtist().toLowerCase().contains(artist.toLowerCase())
                    && t.getTitle().toLowerCase().contains(title.toLowerCase())) out.add(t);
        }
        return out;
    }

    private Track parse(String raw) {
        String[] p = raw.split(";");
        return new TrackBuilder()
                .id(Integer.parseInt(p[0].trim()))
                .title(p[1].trim())
                .artist(p[2].trim())
                .genre(p[3].trim())
                .durationSec(Integer.parseInt(p[4].trim()))
                .build();
    }
}
