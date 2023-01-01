package practice;

import java.util.function.IntPredicate;

public class IsEven implements IntPredicate {

    @Override
    public boolean test(int value) {
        return (value & 1) == 0;
    }
}
