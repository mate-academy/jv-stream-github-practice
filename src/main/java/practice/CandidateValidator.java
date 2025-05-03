package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    static final int VALID_AGE = 35;
    static final int VALID_LIVE_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split("-");
        int liveInUkraine = Integer.parseInt(periods[1]) - Integer.parseInt(periods[0]);

        return candidate.getNationality().equals("Ukrainian") && candidate.isAllowedToVote()
                && candidate.getAge() >= VALID_AGE && liveInUkraine >= VALID_LIVE_IN_UKRAINE;
    }
}
