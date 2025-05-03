package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIODS_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        int period = Arrays.stream(candidate.getPeriodsInUkr()
                .split("-"))
                .map(Integer::valueOf)
                .reduce(0, (a, b) -> b - a);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && period >= MIN_PERIODS_IN_UKR;
    }
}
