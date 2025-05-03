package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE = 35;
    private static final int MINIMUM_PERIOD = 10;
    private static final int FIRST_YEAR_FROM_PERIOD_INDEX = 0;
    private static final int LAST_YEAR_FROM_PERIOD_INDEX = 1;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MINIMUM_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && getPeriod(candidate) >= MINIMUM_PERIOD
                && candidate.isAllowedToVote();
    }

    private int getPeriod(Candidate candidate) {
        return Integer.parseInt(candidate.getPeriodsInUkr()
                .split("-")[LAST_YEAR_FROM_PERIOD_INDEX])
                - Integer.parseInt(candidate.getPeriodsInUkr()
                .split("-")[FIRST_YEAR_FROM_PERIOD_INDEX]);
    }
}
