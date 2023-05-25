package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final int MINIMUM_AGE = 35;
    private static final int MIN_RESIDENCE_PERIOD = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        int residencePeriod = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .mapToInt(Integer::parseInt)
                .reduce(0, (a, b) -> a == 0 ? a - b : a + b);
        return candidate.getAge() >= MINIMUM_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && residencePeriod >= MIN_RESIDENCE_PERIOD;
    }
}
