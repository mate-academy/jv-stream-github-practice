package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD_LIVE_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {

        boolean isPeriodOk = Integer.valueOf(candidate.getPeriodsInUkr().substring(5))
                - Integer.valueOf(candidate.getPeriodsInUkr()
                .substring(0,4)) >= MIN_PERIOD_LIVE_IN_UKRAINE;

        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality() == NATIONALITY && isPeriodOk;
    }
}
