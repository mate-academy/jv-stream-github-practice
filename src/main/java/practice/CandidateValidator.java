package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        int yearsInUkraine = Math.abs(Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .mapToInt(Integer::valueOf)
                .reduce((a, b) -> a - b)
                .getAsInt());
        return candidate.getAge() >= REQUIRED_MIN_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && candidate.isAllowedToVote()
                && yearsInUkraine >= MIN_YEARS_IN_UKRAINE;
    }
}
