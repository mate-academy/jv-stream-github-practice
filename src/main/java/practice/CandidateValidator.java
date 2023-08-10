package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE = 35;
    private static final int MINIMUM_PERIOD_IN_UKRAINE = 10;
    private static final int ALLOWED_VOTING_AGE = 18;
    private static final int MINIMUM_START_YEAR = 0;
    private static final int MINIMUM_END_YEAR = 1;
    private static final String PERIOD_SEPARATOR = "-";
    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MINIMUM_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINIAN_NATIONALITY)
                && validatePeriodInUkraine(candidate.getPeriodsInUkr());
    }

    private boolean validatePeriodInUkraine(String periodsInUkr) {
        String[] years = periodsInUkr.split(PERIOD_SEPARATOR);
        if (years.length != 2) {
            return false;
        }

        int startYear = Integer.parseInt(years[MINIMUM_START_YEAR]);
        int endYear = Integer.parseInt(years[MINIMUM_END_YEAR]);
        return endYear - startYear >= MINIMUM_PERIOD_IN_UKRAINE;
    }
}
