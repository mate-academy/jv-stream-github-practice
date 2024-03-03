package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final double MIN_AGE = 35;
    public static final int MIN_PERIOD_IN_UKR = 10;
    public static final String NATIONALITY = "Ukrainian";
    public static final String YEAR_SEPARATOR = "-";
    private static final int FROM_YEAR = 0;
    private static final int TO_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && getYearsInUkr(candidate.getPeriodsInUkr()) >= MIN_PERIOD_IN_UKR;
    }

    private static int getYearsInUkr(String candidate) {
        String[] years = candidate.split(YEAR_SEPARATOR);
        return Integer.parseInt(years[TO_YEAR]) - Integer.parseInt(years[FROM_YEAR]);
    }
}
