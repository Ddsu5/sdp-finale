package model;

public class Track {
    private final int id;
    private final String title;
    private final String artist;
    private final String genre;
    private final int durationSec;

    // package-private: only TrackBuilder can create a Track
    Track(int id, String title, String artist, String genre, int durationSec) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.durationSec = durationSec;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public String getGenre() { return genre; }
    public int getDurationSec() { return durationSec; }

    public String displayName() { return artist + " - " + title; }

    public String formattedDuration() {
        return String.format("%d:%02d", durationSec / 60, durationSec % 60);
    }
}
