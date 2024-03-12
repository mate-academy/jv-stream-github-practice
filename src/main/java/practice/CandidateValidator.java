package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AMOUNT_MIN_YEARS = 10;
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && Arrays
                .stream(candidate.getPeriodsInUkr().split("-"))
                .map(Integer::parseInt)
                .reduce((x, y) -> y - x)
                .filter(x -> x > AMOUNT_MIN_YEARS)
                .isPresent();
    }
}
