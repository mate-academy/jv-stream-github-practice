package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int CANDIDATE_MINIMUM_AGE = 35;
    private static final String CANDIDATE_REQUIRED_NATIONALITY = "Ukrainian";
    private static final String PERIOD_IN_UKR_SEPARATOR = "-";
    private static final int PERIOD_IN_UKR_START_INDEX = 0;
    private static final int PERIOD_IN_UKR_END_INDEX = 1;
    private static final int MINIMUM_PERIOD_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= CANDIDATE_MINIMUM_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(CANDIDATE_REQUIRED_NATIONALITY)
                && checkPeriodInUkr(candidate);
    }

    private boolean checkPeriodInUkr(Candidate candidate) {
        String[] range = candidate.getPeriodsInUkr().split(PERIOD_IN_UKR_SEPARATOR);
        int start = Integer.parseInt(range[PERIOD_IN_UKR_START_INDEX]);
        int end = Integer.parseInt(range[PERIOD_IN_UKR_END_INDEX]);
        return end - start >= MINIMUM_PERIOD_IN_UKR;
    }
}
