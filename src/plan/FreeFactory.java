package plan;

public class FreeFactory implements SubscriptionFactory {
    @Override
    public AdProvider createAdProvider() {
        return new FreeAdProvider();
    }
    @Override
    public QualityPolicy createQualityPolicy(){
        return new Bitrate128();
    }
    @Override
    public String planName() {
        return "Free";
    }
}
