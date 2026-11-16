package player;

import java.util.Random;

public class ShuffleStrategy implements PlayStrategy {
    private final Random random = new Random();

    @Override
    public int next(int current, int size) {
        if (size <= 1) return 0;
        int n;
        do { n = random.nextInt(size); } while (n == current);
        return n;
    }

    @Override public String name() { return "SHUFFLE"; }
}
