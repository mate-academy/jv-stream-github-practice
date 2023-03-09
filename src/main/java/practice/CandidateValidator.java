package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String DATE_SEPARATOR = "-";
    private static final String EXPECTED_NATIONALITY = "Ukrainian";
    private static final int MINIMUM_PERIOD = 10;
    private static final int MINIMUM_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        return isEligible(candidate) && hasMinimumPeriod(candidate);
    }

    private boolean isEligible(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getNationality().equals(EXPECTED_NATIONALITY)
                && candidate.getAge() >= MINIMUM_AGE;
    }

    private boolean hasMinimumPeriod(Candidate candidate) {
        int period = Arrays.stream(candidate.getPeriodsInUkr().split(DATE_SEPARATOR))
                .mapToInt(Integer::parseInt)
                .reduce((start, end) -> end - start)
                .orElse(0);
        return period >= MINIMUM_PERIOD;
    }
}
