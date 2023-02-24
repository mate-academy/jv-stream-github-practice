package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_ALLOWED_FOR_VOTE = 35;
    private static final int PERIOD_IN_UKR_ALLOWED_FOR_VOTE = 10;
    private static final String NATIONALITY_ALLOWED_FOR_VOTE = "Ukrainian";
    private static final int CANDIDATE_START_PERIOD_IN_UKR = 0;
    private static final int CANDIDATE_END_PERIOD_IN_UKR = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] candidatePeriodInUkrString = candidate.getPeriodsInUkr().split("-");
        int candidateLiveInUkr = Integer.valueOf(
                                        candidatePeriodInUkrString[CANDIDATE_END_PERIOD_IN_UKR])
                               - Integer.valueOf(
                                        candidatePeriodInUkrString[CANDIDATE_START_PERIOD_IN_UKR]);
        return candidate.getAge() >= AGE_ALLOWED_FOR_VOTE
                && candidateLiveInUkr >= PERIOD_IN_UKR_ALLOWED_FOR_VOTE
                && candidate.getNationality().equals(NATIONALITY_ALLOWED_FOR_VOTE)
                && candidate.isAllowedToVote();
    }
}
