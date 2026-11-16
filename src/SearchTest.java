import java.util.ArrayList;
import java.util.List;
import model.Track;
import source.LocalStorage;
import source.OnlineStorageAdapter;
import source.Storage;
public class SearchTest {
    public static void main(String[] args) {
        List<Storage> storages = new ArrayList<>();
        storages.add(new LocalStorage());
        storages.add(new OnlineStorageAdapter());

        for (Storage s : storages) {
            System.out.println("Source: " + s.name());
            List<Track> found = s.search("queen", "");
            for (Track t : found) {
                System.out.println(t.getId() + " | " + t.getTitle() + " | " + t.getArtist());
            }
        }
    }
}

