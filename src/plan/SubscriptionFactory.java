package plan;

public interface SubscriptionFactory {
    AdProvider createAdProvider();
    QualityPolicy createQualityPolicy();
    String planName();
}
