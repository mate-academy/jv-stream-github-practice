package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int CANDIDATE_MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD_IN_UKR = 10;
    private static final String SPLIT_SYMBOL = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= CANDIDATE_MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && yearsInUkr(candidate);
    }

    private boolean yearsInUkr(Candidate candidate) {
        return Arrays.stream(candidate.getPeriodsInUkr().split(SPLIT_SYMBOL))
                .mapToInt(Integer::parseInt)
                .sorted()
                .reduce((n1, n2) -> n2 - n1)
                .getAsInt() >= MIN_PERIOD_IN_UKR;
    }
}
