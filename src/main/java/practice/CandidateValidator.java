package practice;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<String> {

    @Override
    public boolean test(String periodsInUkr) {
        if (periodsInUkr == null || periodsInUkr.length() != 9
                || periodsInUkr.replaceAll("[0-9]", "").length() != 1) {
            return false;
        }
        int start = Integer.parseInt(periodsInUkr.substring(0, 4));
        int over = Integer.parseInt(periodsInUkr.substring(5));
        return start <= over && over - start >= 10;
    }
}
