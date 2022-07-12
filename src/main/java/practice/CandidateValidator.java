package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] splitGetPeriodsInUkr = candidate.getPeriodsInUkr().split("-");
        int periodLiveInUkraine = Integer.parseInt((splitGetPeriodsInUkr[1]))
                - Integer.parseInt(splitGetPeriodsInUkr[0]);
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals("Ukrainian")
                && candidate.isAllowedToVote()
                && periodLiveInUkraine >= MIN_PERIOD_IN_UKR;
    }
}
