package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int REQUIRED_PERIOD_IN_UKRAINE = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate c) {
        return c.getAge() >= MIN_AGE
                && c.getNationality().equals(REQUIRED_NATIONALITY)
                && c.isAllowedToVote()
                && Arrays.stream(c.getPeriodsInUkr().split("-"))
                .map(Integer::valueOf)
                .reduce(0, (i, i2) -> i2 - i) >= REQUIRED_PERIOD_IN_UKRAINE;
    }
}
