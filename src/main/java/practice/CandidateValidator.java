package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String PERIOD_DELIMITER = "-";
    private static final int INDEX_OF_START_YEAR = 0;
    private static final int INDEX_OF_END_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && getNumberOfYearsInUkraine(candidate.getPeriodsInUkr()) >= MIN_YEARS_IN_UKRAINE;
    }

    private int getNumberOfYearsInUkraine(String period) {
        String[] yearsFromPeriod = period.split(PERIOD_DELIMITER);
        return Integer.parseInt(yearsFromPeriod[INDEX_OF_END_YEAR])
                - Integer.parseInt(yearsFromPeriod[INDEX_OF_START_YEAR]);
    }
}
