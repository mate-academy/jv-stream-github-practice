package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE = 35;
    private static final int LIVE_UKRAIN = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] data = candidate.getPeriodsInUkr().split("-");
        int years = Integer.parseInt(data[1]) - Integer.parseInt(data[0]);
        if (candidate.getAge() >= AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian") && years >= LIVE_UKRAIN) {
            return true;
        }
        return false;
    }
}
