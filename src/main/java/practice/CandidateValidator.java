package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    public static final String UKRAINIAN = "Ukrainian";
    public static final int REQUIRED_MINIMUM_AGE = 35;
    public static final int MINIMUM_RESIDENCY_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= REQUIRED_MINIMUM_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINIAN)
                && isEligibleToVoteBasedOnResidency(candidate);
    }

    private boolean isEligibleToVoteBasedOnResidency(Candidate candidate) {
        String[] arr = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(arr[1]) - Integer.parseInt(arr[0]) >= MINIMUM_RESIDENCY_PERIOD;
    }
}
