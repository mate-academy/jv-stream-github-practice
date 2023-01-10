package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_VALID_AGE = 35;
    private static final int MIN_VALID_PERIOD = 10;
    private static final int YEAR_FROM_INDEX = 0;
    private static final int YEAR_TO_INDEX = 1;
    private static final String VALID_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_VALID_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(VALID_NATIONALITY)
                && checkPeriod(candidate);
    }

    private boolean checkPeriod(Candidate candidate) {
        String[] yearsInUkraine = candidate.getPeriodsInUkr().split("-");
        int intYearsFrom = Integer.parseInt(yearsInUkraine[YEAR_FROM_INDEX]);
        int intYearsTo = Integer.parseInt(yearsInUkraine[YEAR_TO_INDEX]);
        return (intYearsTo - intYearsFrom) >= MIN_VALID_PERIOD;
    }
}
