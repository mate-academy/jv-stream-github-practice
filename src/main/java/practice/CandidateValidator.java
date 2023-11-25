package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD = 10;
    private static final int FIRST_YEAR_INDEX = 0;
    private static final int LAST_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate c) {
        return c.getAge() >= MIN_AGE
                && c.isAllowedToVote()
                && c.getNationality().equals("Ukrainian")
                && getPeriod(c) >= MIN_PERIOD;
    }

    private int getPeriod(Candidate c) {
        String[] period = c.getPeriodsInUkr().split("-");
        return Integer.parseInt(period[LAST_YEAR_INDEX])
                - Integer.parseInt(period[FIRST_YEAR_INDEX]);
    }
}
