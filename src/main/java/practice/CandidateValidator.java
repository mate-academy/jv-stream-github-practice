package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_TO_VOTE = 35;
    private static final String NATIONALITY_TO_VOTE = "Ukrainian";
    private static final int MIN_PERIODS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE_TO_VOTE
                && candidate.getNationality().equals(NATIONALITY_TO_VOTE)
                && periodsInUkraine(candidate.getPeriodsInUkr()) > MIN_PERIODS_IN_UKRAINE
                && candidate.isAllowedToVote();
    }

    private int periodsInUkraine(String periodsInUkr) {
        String[] str = periodsInUkr.split("-");
        return Arrays.stream(str)
                .map(Integer::parseInt)
                .reduce((n1, n2) -> n2 - n1)
                .orElseThrow(() -> new RuntimeException("Can't get min value from list: "));
    }
}
