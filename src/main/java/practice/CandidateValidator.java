package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String ALLOWED_NATIONALITY = "Ukrainian";
    private static final String YEAR_SPLIT_REGEX = "-";
    private static final int ALLOWED_AGE = 35;
    private static final int MIN_UKR_LIVING_YEARS = 10;
    private static final int INDEX_FROM_YEAR = 0;
    private static final int INDEX_TO_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= ALLOWED_AGE
                && candidate.getNationality().equals(ALLOWED_NATIONALITY)
                && getPeriodDifference(candidate.getPeriodsInUkr()) >= MIN_UKR_LIVING_YEARS;
    }

    private int getPeriodDifference(String periodsInUkr) {
        String[] years = periodsInUkr.split(YEAR_SPLIT_REGEX);
        return Integer.parseInt(years[INDEX_TO_YEAR])
                - Integer.parseInt(years[INDEX_FROM_YEAR]);
    }
}
