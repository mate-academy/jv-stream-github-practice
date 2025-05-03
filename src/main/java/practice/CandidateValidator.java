package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final String PERIOD_SPLITTER = "-";

    @Override
    public boolean test(Candidate c) {
        String[] splitPeriod = c.getPeriodsInUkr().split(PERIOD_SPLITTER);
        return c.getAge() >= MIN_AGE
                && c.isAllowedToVote()
                && c.getNationality().equals(REQUIRED_NATIONALITY)
                && Integer.parseInt(splitPeriod[1])
                - Integer.parseInt(splitPeriod[0]) >= MIN_PERIOD;
    }
}
