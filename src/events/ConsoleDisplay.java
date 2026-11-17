package events;

import model.Track;
import plan.QualityPolicy;

public class ConsoleDisplay implements PlayerListener {
    private QualityPolicy quality;

    public void setQualityPolicy(QualityPolicy quality) {
        this.quality = quality;
    }

    @Override
    public void onTrackStarted(Track track) {
        System.out.println(track.displayName() + " - Playing... [" + quality.kbps() + " kbps]");
    }

    @Override
    public void onStopped(){
        System.out.println("Playback stopped.");
    }
}
