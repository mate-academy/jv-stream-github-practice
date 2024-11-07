package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String UKRAINIAN = "Ukrainian";
    private static final int REQUIRED_MINIMUM_AGE = 35;
    private static final int MINIMUM_RESIDENCY_PERIOD = 10;
    private static final String DELIMITER = "-";
    private static final int INDEX_OF_YEAR_FROM = 1;
    private static final int INDEX_OF_YEAR_TO = 0;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= REQUIRED_MINIMUM_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINIAN)
                && isEligibleToVoteBasedOnResidency(candidate);
    }

    private boolean isEligibleToVoteBasedOnResidency(Candidate candidate) {
        String[] arr = candidate.getPeriodsInUkr().split(DELIMITER);
        return Integer.parseInt(
            arr[INDEX_OF_YEAR_FROM]) - Integer.parseInt(arr[INDEX_OF_YEAR_TO])
            >= MINIMUM_RESIDENCY_PERIOD;
    }
}
