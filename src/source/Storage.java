package source;

import model.Track;
import java.util.List;

public interface Storage {
    String name();                                   // "local" or "online"
    List<Track> search(String artist, String title); // empty string = no filter
}
