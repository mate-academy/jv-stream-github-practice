package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int ELIGIBLE_PRESIDENT_AGE = 35;
    private static final int ELIGIBLE_PRESIDENT_PERIOD_IN_UKRAINE = 10;
    private static final char PERIOD_DIVIDER = '-';

    @Override
    public boolean test(Candidate candidate) {
        String periodsInUkr = candidate.getPeriodsInUkr();
        int periodsFrom = Integer.parseInt(
                periodsInUkr.substring(0, periodsInUkr.indexOf(PERIOD_DIVIDER)));
        int periodsTo = Integer.parseInt(
                periodsInUkr.substring(periodsInUkr.indexOf(PERIOD_DIVIDER) + 1));
        return candidate.getAge() >= ELIGIBLE_PRESIDENT_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && periodsTo - periodsFrom >= ELIGIBLE_PRESIDENT_PERIOD_IN_UKRAINE;
    }
}
