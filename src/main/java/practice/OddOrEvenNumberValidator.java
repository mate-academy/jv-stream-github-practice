package practice;

import java.util.function.IntPredicate;

public class OddOrEvenNumberValidator implements IntPredicate {
    private final String wantedNumbers;

    public OddOrEvenNumberValidator(String wantedNumbers) {
        this.wantedNumbers = wantedNumbers;
    }

    @Override
    public boolean test(int integer) {
        return wantedNumbers.equals("odd") ? Math.abs(integer) % 2 == 1 : integer % 2 == 0;
    }
}
