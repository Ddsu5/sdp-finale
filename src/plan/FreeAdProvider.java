package plan;

public class FreeAdProvider implements AdProvider {
    private final String[] ads = {
        "[AD] Go Premium: no ads, 320 kbps!",
        "[AD] Try our family plan today.",
        "[AD] Your favorite snacks, now 20% off."
    };
    private int index = 0;

    @Override
    public String nextAd() {
        String ad = ads[index];
        index = (index + 1) % ads.length;
        return ad;
    }
}
