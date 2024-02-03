package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_RESTRICTION = 35;
    private static final int VALID_PERIOD_OF_STAY = 10;
    private static final String ADMISSIBLE_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= AGE_RESTRICTION
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(ADMISSIBLE_NATIONALITY)
                && Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .map(Integer::parseInt).reduce(0, (a, b) -> b - a) >= VALID_PERIOD_OF_STAY;
    }
    //write your code here
}
