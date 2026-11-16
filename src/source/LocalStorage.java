package source;
import java.util.ArrayList;
import java.util.List;
import model.Track;
import model.TrackBuilder;

public class LocalStorage implements Storage {
    private List<Track> tracks = new ArrayList<>();
    public LocalStorage() {
        add(1, "Bohemian Rhapsody", "Queen", "rock", 354);
        add(2, "Another One Bites the Dust", "Queen", "rock", 215);
        add(3, "Imagine", "John Lennon", "pop", 183);
        add(4, "Hotel California", "Eagles", "rock", 391);
        add(5, "Billie Jean", "Michael Jackson", "pop", 294);
        add(6, "Thriller", "Michael Jackson", "pop", 357);
        add(7, "Smells Like Teen Spirit", "Nirvana", "rock", 301);
        add(8, "Come As You Are", "Nirvana", "rock", 219);
        add(9, "Yesterday", "The Beatles", "pop", 125);
        add(10, "Hey Jude", "The Beatles", "pop", 431);
        add(11, "Stairway to Heaven", "Led Zeppelin", "rock", 482);
        add(12, "Black Dog", "Led Zeppelin", "rock", 296);
        add(13, "Shape of You", "Ed Sheeran", "pop", 234);
        add(14, "Perfect", "Ed Sheeran", "pop", 263);
        add(15, "Rolling in the Deep", "Adele", "pop", 228);
        add(16, "Hello", "Adele", "pop", 295);
        add(17, "Lose Yourself", "Eminem", "rap", 326);
        add(18, "Sing for the Moment", "Eminem", "rap", 340);
        add(19, "Numb", "Linkin Park", "rock", 187);
        add(20, "In the End", "Linkin Park", "rock", 216);
    }

    private void add(int id, String title, String artist, String genre, int durationSec) {
        Track t = new TrackBuilder()
                .id(id)
                .title(title)
                .artist(artist)
                .genre(genre)
                .durationSec(durationSec)
                .build();
        tracks.add(t);
    }

    @Override
    public String name() {
        return "local";
    }

    @Override
    public List<Track> search(String artist, String title) {
        List<Track> result = new ArrayList<>();
        for (Track t : tracks) {
            boolean artistOk = artist.isEmpty() || t.getArtist().toLowerCase().contains(artist.toLowerCase());
            boolean titleOk = title.isEmpty() || t.getTitle().toLowerCase().contains(title.toLowerCase());
            if (artistOk && titleOk) {
                result.add(t);
            }
        }
        return result;
    }
}
