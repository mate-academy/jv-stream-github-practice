package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        int period = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .mapToInt(Integer::parseInt)
                .reduce((a, b) -> Math.abs(a - b))
                .orElse(0);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote() && candidate.getNationality().equals("Ukrainian")
                && period >= 10;
    }
}
