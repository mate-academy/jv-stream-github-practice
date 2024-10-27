package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final String ALLOWED_NATIONALITY = "Ukrainian";
    public static final int MIN_AGE = 35;
    public static final int MIN_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(ALLOWED_NATIONALITY)
                && calculateYearsInUkraine(candidate.getPeriodsInUkr()) >= MIN_YEARS_IN_UKRAINE;
    }

    private int calculateYearsInUkraine(String years) {
        return Arrays.stream(years
                .split("-"))
                .mapToInt(Integer::parseInt)
                .reduce((a, b) -> Math.abs(a - b))
                .orElse(0);
    }
}
