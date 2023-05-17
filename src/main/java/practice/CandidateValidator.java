package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int ACCEPTABLE_AGE = 35;
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final String SEPARATOR = "-";
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        int periodInUkr = Arrays.stream(candidate.getPeriodsInUkr().split(SEPARATOR))
                .mapToInt(Integer::parseInt)
                .reduce(0, (a, b) -> b - a);
        return candidate.getAge() >= ACCEPTABLE_AGE
            && candidate.isAllowedToVote()
            && candidate.getNationality().equals(NATIONALITY)
            && periodInUkr > MIN_PERIOD_IN_UKRAINE;
    }
}
