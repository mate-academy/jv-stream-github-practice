package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_VALID_AGE = 35;
    private static final int MIN_VALID_PERIOD = 10;
    private static final int INDEX_YEARS_FROM = 0;
    private static final int INDEX_YEARS_TO = 1;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_VALID_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && checkPeriod(candidate);
    }

    private boolean checkPeriod(Candidate candidate) {
        String[] yearsInUkraine = candidate.getPeriodsInUkr().split("-");
        int intYearsFrom = Integer.parseInt(yearsInUkraine[INDEX_YEARS_FROM]);
        int intYearsTo = Integer.parseInt(yearsInUkraine[INDEX_YEARS_TO]);
        return (intYearsTo - intYearsFrom) >= MIN_VALID_PERIOD;
    }
}
