package player;

import java.util.Random;

public class ShuffleStrategy implements PlayStrategy {

    private final Random random = new Random();

    @Override
    public int next(int current, int size) {

        if (size <= 1) {
            return 0;
        }

        int nextTrack = random.nextInt(size);

        while (nextTrack == current) {
            nextTrack = random.nextInt(size);
        }

        return nextTrack;
    }

    @Override
    public String name() {
        return "SHUFFLE";
    }
}