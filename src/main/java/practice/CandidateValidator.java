package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int PERIOD_TO_NUMBER = 1;
    private static final int PERIOD_FROM_NUMBER = 0;
    private static final int PERIOD_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate c) {
        return c.getAge() >= 35
                && c.isAllowedToVote()
                && "Ukrainian".equals(c.getNationality())
                && Integer.parseInt(c.getPeriodsInUkr().split("-")[PERIOD_TO_NUMBER])
                - Integer.parseInt(c.getPeriodsInUkr().split("-")[PERIOD_FROM_NUMBER])
                >= PERIOD_IN_UKRAINE;
    }
}
