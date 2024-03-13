package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String YEAR_SEPARATOR = "-";
    private static final int TO_YEAR_INDEX = 1;
    private static final int FROM_YEAR_INDEX = 0;

    @Override
    public boolean test(Candidate c) {
        return c.getAge() >= MIN_AGE
                && c.isAllowedToVote()
                && c.getNationality().equals(NATIONALITY)
                && getYearsInUkraine(c.getPeriodsInUkr()) >= MIN_PERIOD_IN_UKRAINE;
    }

    private int getYearsInUkraine(String years) {
        String[] split = years.split(YEAR_SEPARATOR);
        return Integer.parseInt(split[TO_YEAR_INDEX]) - Integer.parseInt(split[FROM_YEAR_INDEX]);
    }
}
