package plan;

public class PremiumFactory implements SubscriptionFactory {
    @Override public AdProvider createAdProvider() { return new NoAdProvider(); }
    @Override public QualityPolicy createQualityPolicy() { return new Bitrate320(); }
    @Override public String planName() { return "Premium"; }
}
