package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final int VALID_AGE = 35;
    private static final String SPLIT_REGEXP = "-";
    private static final int MIN_PERIOD_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= VALID_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(VALID_NATIONALITY)
                && calcPeriodInUkraine(candidate);
    }

    private boolean calcPeriodInUkraine(Candidate candidate) {
        int[] period = Arrays.stream(candidate.getPeriodsInUkr().split(SPLIT_REGEXP))
                .mapToInt(Integer::parseInt)
                .toArray();
        return period[1] - period[0] >= MIN_PERIOD_IN_UKRAINE;
    }
}
