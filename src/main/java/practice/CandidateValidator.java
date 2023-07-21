package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_TO_APPLY_FOR_PRESIDENT_POSITION = 35;
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final int MIN_PERIODS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate c) {
        return c.getAge() >= MIN_AGE_TO_APPLY_FOR_PRESIDENT_POSITION
                && c.isAllowedToVote()
                && c.getNationality().equals(VALID_NATIONALITY)
                && Arrays.stream(c.getPeriodsInUkr().split("-"))
                .mapToInt(Integer::parseInt)
                .reduce((y1, y2) -> y2 - y1)
                .orElse(0) >= MIN_PERIODS_IN_UKRAINE;
    }
}
