package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int FirstElement = 0;
    private static final int SecondElement = 1;
    private static final int AGE = 35;
    private static final int LIVE_UKRAIN = 10;

    @Override
    public boolean test(Candidate candidate) {
        int years = Integer.parseInt(candidate.getPeriodsInUkr().split("-")[SecondElement])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[FirstElement ]);
        if (candidate.getAge() >= AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian") && years >= LIVE_UKRAIN) {
            return true;
        }
        return false;
    }
}
