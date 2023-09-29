package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_THRESHOLD = 35;
    private static final int PERIOD_THRESHOLD = 10;
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;

    @Override
    public boolean test(final Candidate candidate) {
        final String[] periods = candidate.getPeriodsInUkr().split("-");
        int startYear = Integer.parseInt(periods[INDEX_0]);
        int endYear = Integer.parseInt(periods[INDEX_1]);
        return candidate.getAge() >= AGE_THRESHOLD && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && endYear - startYear >= PERIOD_THRESHOLD;
    }
}
