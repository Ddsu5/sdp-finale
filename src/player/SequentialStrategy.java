package player;

public class SequentialStrategy implements PlayStrategy {
    @Override public int next(int current, int size) { return (current + 1) % size; }
    @Override public String name() { return "SEQUENTIAL"; }
}
