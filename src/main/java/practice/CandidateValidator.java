package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int PERIOD_START_ID = 0;
    public static final int PERIOD_END_ID = 1;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < 35) {
            return false;
        }
        if (!candidate.getNationality().equals("Ukrainian")) {
            return false;
        }
        if (!candidate.isAllowedToVote()) {
            return false;
        }
        String[] period = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(period[PERIOD_END_ID])
                - Integer.parseInt(period[PERIOD_START_ID]) >= 10;
    }
}
