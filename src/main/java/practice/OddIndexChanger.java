package practice;

import java.util.function.Function;

public class OddIndexChanger implements Function<Integer, Integer> {
    private static final int SUBTRACT_VALUE = 1;
    private boolean isEven;

    @Override
    public Integer apply(Integer value) {
        isEven = !isEven;
        return isEven ? value : value - SUBTRACT_VALUE;
    }
}
