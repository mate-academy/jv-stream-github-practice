package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int NOT_SUIT = 0;
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD = 10;
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && Arrays.stream(candidate.getPeriodsInUkr().split(SEPARATOR))
                .map(Integer::parseInt)
                .reduce((from, to) -> to - from)
                .orElse(NOT_SUIT) > MIN_PERIOD;
    }
}
