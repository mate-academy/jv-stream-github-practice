package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int MIN_AGE = 35;
    private static final String NATIONALITY_REQUIRED = "Ukrainian";
    private static final String PERIOD_SEPARATOR = "-";
    private static final int REQUIRED_PERIOD_YEARS = 10;

    @Override
    public boolean test(Candidate c) {
        return c.getAge() >= MIN_AGE
                && c.isAllowedToVote()
                && c.getNationality().equals(NATIONALITY_REQUIRED)
                && getYearsInUkraine(c.getPeriodsInUkr()) >= REQUIRED_PERIOD_YEARS;
    }

    private int getYearsInUkraine(String periodsInUkr) {
        String[] period = periodsInUkr.split(PERIOD_SEPARATOR);
        return Integer.parseInt(period[1]) - Integer.parseInt(period[0]);
    }
}
