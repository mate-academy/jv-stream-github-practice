package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int RESIDENCE_PERIOD_YEARS = 10;
    private static final int EXPECTED_PERIOD_PARTS = 2;
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final String YEAR_SEPARATOR = "-";
    private static final int START_YEAR_INDEX = 0;
    private static final int END_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_CANDIDATE_AGE
            && candidate.isAllowedToVote()
            && candidate.getNationality().equalsIgnoreCase(NATIONALITY)
            && hasValidResidencyPeriod(candidate.getPeriodsInUkr());
    }

    public boolean hasValidResidencyPeriod(String periodsUkr) {
        String[] periods = periodsUkr.split(YEAR_SEPARATOR);
        if (periods.length == EXPECTED_PERIOD_PARTS) {
            int startYear = Integer.parseInt(periods[START_YEAR_INDEX]);
            int endYear = Integer.parseInt(periods[END_YEAR_INDEX]);
            return (endYear - startYear) >= RESIDENCE_PERIOD_YEARS;
        }
        return false;
    }
}
