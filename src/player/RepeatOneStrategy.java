package player;

public class RepeatOneStrategy implements PlayStrategy {
    @Override
    public int next(int current, int size) {
        return current;
    }
    @Override public String name() {
        return "REPEAT_ONE";
    }
}
