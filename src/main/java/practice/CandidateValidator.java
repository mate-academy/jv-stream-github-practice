package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_THRESHOLD = 35;
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final String DEMONYM = "Ukrainian";

    @Override
    public boolean test(Candidate c) {
        return c.getAge() >= AGE_THRESHOLD
                && c.isAllowedToVote()
                && c.getNationality().equals(DEMONYM)
                && (Integer.parseInt(c.getPeriodsInUkr().split("-")[1])
                - Integer.parseInt(c.getPeriodsInUkr().split("-")[0])) >= MIN_PERIOD_IN_UKRAINE;
    }
}
