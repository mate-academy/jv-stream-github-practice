package practice;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String ALLOWED_NATIONALITY = "Ukrainian";
    private static final String PERIOD_IN_UKRAINE_SEPARATOR = "-";
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(ALLOWED_NATIONALITY)
                && calculateYearsInUkraine(candidate.getPeriodsInUkr()) >= MIN_YEARS_IN_UKRAINE;
    }

    private int calculateYearsInUkraine(String years) {
        IntBinaryOperator numbersDiffOrException = (a, b) -> {
            if (a < b) {
                return b - a;
            } else {
                throw new IllegalArgumentException(
                        "First number must be smaller than the second number."
                );
            }
        };

        return Arrays.stream(years
                .split(PERIOD_IN_UKRAINE_SEPARATOR))
                .mapToInt(Integer::parseInt)
                .reduce(numbersDiffOrException)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Input must contain two numbers separated by '"
                        + PERIOD_IN_UKRAINE_SEPARATOR
                        + "'")
                );
    }
}
