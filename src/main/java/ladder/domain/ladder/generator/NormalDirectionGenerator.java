package ladder.domain.ladder.generator;

import java.util.Random;

public class NormalDirectionGenerator implements DirectionGenerator {
    private static final double GENERATE_PERCENT = 0.5;
    private final Random random = new Random();

    @Override
    public boolean generate() {
        if (random.nextDouble() < GENERATE_PERCENT) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }
}
