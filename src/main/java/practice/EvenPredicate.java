package practice;

import java.util.function.IntPredicate;

public class EvenPredicate implements IntPredicate {
    @Override
    public boolean test(int integer) {
        return integer % 2 == 0;
    }
}
