package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_VALID_AGE = 35;
    private static final int MIN_VALID_PERIOD_OF_RESIDENCE = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final String SPLIT_SYMBOL = "-";

    @Override
    public boolean test(Candidate candidate) {
        int periodsInUkr = getPeriodOfLeaving(candidate);
        return candidate.getAge() >= MIN_VALID_AGE
                & candidate.isAllowedToVote()
                & candidate.getNationality().equals(REQUIRED_NATIONALITY)
                & periodsInUkr >= MIN_VALID_PERIOD_OF_RESIDENCE;
    }

    private int getPeriodOfLeaving(Candidate candidate) {
        return Arrays.stream(candidate.getPeriodsInUkr().split(SPLIT_SYMBOL))
                .mapToInt(Integer::parseInt)
                .reduce(0, (a, b) -> b - a);

    }
}
