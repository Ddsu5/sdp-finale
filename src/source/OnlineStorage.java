package source;

import java.util.List;

// STUB (Member B): simulates a 3rd-party service. Knows nothing about Track/Storage.
public class OnlineStorage {
    public List<String> fetchAll() {
        return List.of("21; Don't Stop Me Now; Queen; rock; 209");
    }
}
