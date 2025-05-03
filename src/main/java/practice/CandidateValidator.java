package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String PERIODS_REGEX = "\\d{4}-\\d{4}";
    private static final String PERIODS_SEPARATOR = "-";
    private static final int START_YEAR_INDEX = 0;
    private static final int END_YEAR_INDEX = 1;
    private static final int YEARS_LENGTH = 2;

    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && REQUIRED_NATIONALITY.equals(candidate.getNationality())
                && candidate.getPeriodsInUkr() != null
                && candidate.getPeriodsInUkr().matches(PERIODS_REGEX)
                && calculateYearsInUkraine(candidate.getPeriodsInUkr()) >= MIN_YEARS_IN_UKRAINE;
    }

    private int calculateYearsInUkraine(String periodsInUkr) {
        String[] years = periodsInUkr.split(PERIODS_SEPARATOR);
        if (years.length == YEARS_LENGTH) {
            return Integer.parseInt(years[END_YEAR_INDEX])
                    - Integer.parseInt(years[START_YEAR_INDEX]);
        }
        return 0;
    }
}
