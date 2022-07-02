package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int ALLOWED_PRESIDENTIAL_AGE = 35;
    private static final int MINIMAL_REQUIRED_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        Integer candidatesPeriod = Arrays.stream(candidate.getPeriodsInUkr()
                .split("-"))
                .map(Integer::parseInt)
                .reduce(0, (a, b) -> b - a);
        return candidate.getAge() >= ALLOWED_PRESIDENTIAL_AGE
                && candidate.isAllowedToVote() && candidate.getNationality().equals("Ukrainian")
                && candidatesPeriod >= MINIMAL_REQUIRED_PERIOD;
    }
}
