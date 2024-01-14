package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_THRESHOLD = 35;
    private static final int PERIOD_THRESHOLD = 10;
    private static final int FIRST_YEAR_INDEX = 0;
    private static final int LAST_YEAR_INDEX = 1;

    @Override
    public boolean test(final Candidate candidate) {
        final String[] periods = candidate.getPeriodsInUkr().split("-");
        int firstYear = Integer.parseInt(periods[FIRST_YEAR_INDEX]);
        int lastYear = Integer.parseInt(periods[LAST_YEAR_INDEX]);
        return candidate.getAge() >= AGE_THRESHOLD && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && lastYear - firstYear >= PERIOD_THRESHOLD;
    }
}
