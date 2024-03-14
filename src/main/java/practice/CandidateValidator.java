package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int CANDIDATE_LIVE_PERIOD_FROM_INDEX = 0;
    public static final int CANDIDATE_LIVE_PERIOD_TO_INDEX = 1;
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final int VALID_AGE = 35;
    private static final String SPLIT_REGEXP = "-";
    private static final int MIN_PERIOD_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= VALID_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(VALID_NATIONALITY)
                && isCandidatePeriodValid(candidate);
    }

    private boolean isCandidatePeriodValid(Candidate candidate) {
        int[] period = Arrays.stream(candidate.getPeriodsInUkr().split(SPLIT_REGEXP))
                .mapToInt(Integer::parseInt)
                .toArray();
        return period[CANDIDATE_LIVE_PERIOD_TO_INDEX]
                - period[CANDIDATE_LIVE_PERIOD_FROM_INDEX]
                >= MIN_PERIOD_IN_UKRAINE;
    }
}
