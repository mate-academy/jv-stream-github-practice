package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int PERIOD_START_ID = 0;
    private static final int PERIOD_END_ID = 1;
    private static final int MIN_IN_UKRAINE = 10;
    private static final int MIN_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals("Ukrainian")
                && candidate.isAllowedToVote()
                && Integer.parseInt(period[PERIOD_END_ID])
                - Integer.parseInt(period[PERIOD_START_ID]) >= MIN_IN_UKRAINE;
    }
}
