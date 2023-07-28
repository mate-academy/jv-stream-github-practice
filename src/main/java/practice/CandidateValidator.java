package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD_LIVING_IN_UKR = 10;
    private static final String PERIOD_DATA_SEPARATOR = "-";
    private static final int INDEX_OF_FROM_YEAR = 0;
    private static final int INDEX_OF_TO_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && isValidPeriodOfLivingInUkr(candidate.getPeriodsInUkr());
    }

    private boolean isValidPeriodOfLivingInUkr(String period) {
        String[] years = period.split(PERIOD_DATA_SEPARATOR);
        int firstYear = Integer.parseInt(years[INDEX_OF_FROM_YEAR]);
        int lastYear = Integer.parseInt(years[INDEX_OF_TO_YEAR]);
        return lastYear - firstYear >= MIN_PERIOD_LIVING_IN_UKR;
    }
}
