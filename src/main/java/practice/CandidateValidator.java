package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator<T extends Candidate> implements Predicate<T> {
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD = 10;

    @Override
    public boolean test(T candidate) {
        int startPointOfPeriod = Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0]);
        int endPointOfPeriod = Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1]);

        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && endPointOfPeriod - startPointOfPeriod >= MIN_PERIOD;
    }
}
