package source;
import java.util.ArrayList;
import java.util.List;
import model.Track;
import model.TrackBuilder;

public class OnlineStorageAdapter implements Storage {
    private OnlineStorage online = new OnlineStorage();
    @Override
    public String name() {
        return "online";
    }
    @Override
    public List<Track> search(String artist, String title) {
        List<Track> result = new ArrayList<>();
        for (String line : online.fetchAll()) {
            Track t = parse(line);
            boolean artistOk = artist.isEmpty() || t.getArtist().toLowerCase().contains(artist.toLowerCase());
            boolean titleOk = title.isEmpty() || t.getTitle().toLowerCase().contains(title.toLowerCase());
            if (artistOk && titleOk) {
                result.add(t);
            }
        }
        return result;
    }

    private Track parse(String line) {
        String[] parts = line.split(";");
        return new TrackBuilder()
                .id(Integer.parseInt(parts[0]))
                .title(parts[1])
                .artist(parts[2])
                .genre(parts[3])
                .durationSec(Integer.parseInt(parts[4]))
                .build();
    }
}
