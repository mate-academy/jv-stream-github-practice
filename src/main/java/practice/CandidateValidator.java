package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE_TO_APPLY_FOR_PRESIDENT = 35;
    private static final int MINIMUM_TIME_LIVE_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkraine = candidate.getPeriodsInUkr().split("-");
        int timeLivingInUkraine = Integer.parseInt(periodInUkraine[1])
                - Integer.parseInt(periodInUkraine[0]);
        return (candidate.getAge() >= MINIMUM_AGE_TO_APPLY_FOR_PRESIDENT
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && timeLivingInUkraine >= MINIMUM_TIME_LIVE_IN_UKRAINE);
    }
}
