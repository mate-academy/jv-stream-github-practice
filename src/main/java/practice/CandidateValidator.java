package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int PERIOD_TO_NUMBER = 1;
    private static final int PERIOD_FROM_NUMBER = 0;
    private static final int PERIOD_IN_UKRAINE = 10;
    private static final int VALID_NUMBER = 35;
    private static final String SPLITTER = "-";

    @Override
    public boolean test(Candidate c) {
        return c.getAge() >= VALID_NUMBER
                && c.isAllowedToVote()
                && "Ukrainian".equals(c.getNationality())
                && Integer.parseInt(c.getPeriodsInUkr().split(SPLITTER)[PERIOD_TO_NUMBER])
                - Integer.parseInt(c.getPeriodsInUkr().split(SPLITTER)[PERIOD_FROM_NUMBER])
                >= PERIOD_IN_UKRAINE;
    }
}
