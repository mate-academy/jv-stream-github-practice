package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        int yearsInUkraine = Arrays.stream(candidate.getPeriodsInUkr().split(SEPARATOR))
                .mapToInt(Integer::parseInt)
                .reduce(0, (accumulator, n) -> n - accumulator);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equalsIgnoreCase(VALID_NATIONALITY)
                && yearsInUkraine >= MIN_YEARS_IN_UKRAINE;
    }
}
