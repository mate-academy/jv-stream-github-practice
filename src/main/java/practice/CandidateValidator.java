package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        Integer periodLiveInUkraine = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .map(Integer::parseInt)
                .reduce(0, (x1, x2) -> x2 - x1);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && periodLiveInUkraine >= MIN_PERIOD_IN_UKR;
    }
}
