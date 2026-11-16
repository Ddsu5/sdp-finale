package plan;

public interface AdProvider {
    /** Returns the next ad text, or null if there are no ads. */
    String nextAd();
}
