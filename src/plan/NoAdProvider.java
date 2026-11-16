package plan;

public class NoAdProvider implements AdProvider {
    @Override
    public String nextAd() { return null; }
}
