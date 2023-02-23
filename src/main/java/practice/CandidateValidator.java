package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_ALLOWED_FOR_VOTE = 35;
    private static final int PERIOD_IN_UKR_ALLOWED_FOR_VOTE = 10;
    private static final String NATIONALITY_ALLOWED_FOR_VOTE = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] candidatePeriodInUkrString = candidate.getPeriodsInUkr().split("-");
        int candidateLiveInUkr = Integer.valueOf(candidatePeriodInUkrString[1])
                               - Integer.valueOf(candidatePeriodInUkrString[0]);
        if (candidate.getAge() >= AGE_ALLOWED_FOR_VOTE
                && candidateLiveInUkr >= PERIOD_IN_UKR_ALLOWED_FOR_VOTE
                && candidate.getNationality().equals(NATIONALITY_ALLOWED_FOR_VOTE)
                && candidate.isAllowedToVote()) {
            return true;
        }
        return false;
    }
}
