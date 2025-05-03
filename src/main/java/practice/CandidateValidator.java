package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_FOR_PRESIDENCY = 35;
    private static final int MIN_YEARS_LIVED_IN_UKRAINE = 10;
    private static final String NATIONALITY_REQUIRED = "Ukrainian";
    private static final String PERIOD_DELIMITER = "-";
    private static final int START_YEAR_INDEX = 0;
    private static final int END_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE_FOR_PRESIDENCY
                && candidate.isAllowedToVote()
                && NATIONALITY_REQUIRED.equals(candidate.getNationality())
                && hasLivedInUkraineForAtLeastTenYears(candidate.getPeriodsInUkr());
    }

    private boolean hasLivedInUkraineForAtLeastTenYears(String period) {
        String[] years = period.split(PERIOD_DELIMITER);
        int startYear = Integer.parseInt(years[START_YEAR_INDEX]);
        int endYear = Integer.parseInt(years[END_YEAR_INDEX]);
        return (endYear - startYear) >= MIN_YEARS_LIVED_IN_UKRAINE;
    }
}
