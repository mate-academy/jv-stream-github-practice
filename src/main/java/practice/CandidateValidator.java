package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int AGE_LIMIT = 35;
    public static final String UKRAINIAN = "Ukrainian";
    public static final String DASH = "-";
    public static final int START_YEAR_INDEX = 0;
    public static final int END_YEAR_INDEX = 1;
    public static final int MIN_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() > AGE_LIMIT
                && candidate.isAllowedToVote()
                && UKRAINIAN.equals(candidate.getNationality())
                && isEligibleForPresidency(candidate.getPeriodsInUkr());
    }

    private boolean isEligibleForPresidency(String periodsInUkr) {
        String[] years = periodsInUkr.split(DASH);
        if (years.length == 2) {
            try {
                int startYear = Integer.parseInt(years[START_YEAR_INDEX]);
                int endYear = Integer.parseInt(years[END_YEAR_INDEX]);
                return (endYear - startYear) >= MIN_YEARS_IN_UKRAINE;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }
}

