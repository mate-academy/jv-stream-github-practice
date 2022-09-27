package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_MIN_AGE = 35;
    private static final int REQUIRED_PERIOD_IN_COUNTRY = 10;
    private static final int FROM_YEAR_INDEX = 0;
    private static final int TO_YEAR_INDEX = 1;

    @Override
    public boolean test(final Candidate candidate) {
        String[] fromToYearsInUkraine = candidate.getPeriodsInUkr().split("-");
        int periodInUkraine = Integer.parseInt(fromToYearsInUkraine[TO_YEAR_INDEX])
                - Integer.parseInt(fromToYearsInUkraine[FROM_YEAR_INDEX]);
        return candidate.getAge() >= REQUIRED_MIN_AGE
                && candidate.getNationality().equals("Ukrainian")
                && candidate.isAllowedToVote()
                && periodInUkraine >= REQUIRED_PERIOD_IN_COUNTRY;
    }
}
