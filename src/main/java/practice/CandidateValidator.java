package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_FROM = 35;
    private static final int TEN_YEARS_OF_LIFE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return (candidate.getAge() >= AGE_FROM) && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .map(Integer::parseInt)
                .reduce((a, b) -> b - a)
                .get() >= TEN_YEARS_OF_LIFE;
    }
}
