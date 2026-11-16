package model;

public class TrackBuilder {
    private int id;
    private String title = "";
    private String artist = "";
    private String genre = "";
    private int durationSec;

    public TrackBuilder id(int id) { this.id = id; return this; }
    public TrackBuilder title(String title) { this.title = title; return this; }
    public TrackBuilder artist(String artist) { this.artist = artist; return this; }
    public TrackBuilder genre(String genre) { this.genre = genre; return this; }
    public TrackBuilder durationSec(int durationSec) { this.durationSec = durationSec; return this; }

    public Track build() {
        if (title == null || title.trim().isEmpty())
            throw new IllegalStateException("Track title cannot be empty");
        if (artist == null || artist.trim().isEmpty())
            throw new IllegalStateException("Track artist cannot be empty");
        if (durationSec <= 0)
            throw new IllegalStateException("Track duration must be greater than zero");
        return new Track(id, title.trim(), artist.trim(), genre, durationSec);
    }
}
