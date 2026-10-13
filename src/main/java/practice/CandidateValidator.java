package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final String PERIOD_DELIMITER = "-";
    private static final int YEAR_FROM_INDEX = 0;
    private static final int YEAR_TO_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && REQUIRED_NATIONALITY.equals(candidate.getNationality())
                && getYearsInUkraine(candidate.getPeriodsInUkr()) >= MIN_YEARS_IN_UKRAINE;
    }

    private int getYearsInUkraine(String periodsInUkr) {
        String[] years = periodsInUkr.split(PERIOD_DELIMITER);
        int startYear = Integer.parseInt(years[YEAR_FROM_INDEX]);
        int endYear = Integer.parseInt(years[YEAR_TO_INDEX]);
        return endYear - startYear;
    }
}
