package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_IN_COUNTRY = 10;
    private static final int START_PERIOD = 1;
    private static final int END_PERIOD = 0;
    private static final String PERIOD_SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return VALID_NATIONALITY.equals(candidate.getNationality())
                && candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_AGE
                && getLifetimeSpentInUkraine(candidate.getPeriodsInUkr()) >= MIN_YEARS_IN_COUNTRY;
    }

    private int getLifetimeSpentInUkraine(String periodsInUkr) {
        String[] years = periodsInUkr.split(PERIOD_SEPARATOR);
        return Integer.parseInt(years[START_PERIOD]) - Integer.parseInt(years[END_PERIOD]);
    }
}
