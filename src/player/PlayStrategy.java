package player;

public interface PlayStrategy {
    int next(int current, int size);
    String name();
}
