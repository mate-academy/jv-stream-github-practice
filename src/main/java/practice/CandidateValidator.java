package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && "Ukrainian".equals(candidate.getNationality()) && isMoreThanTenYears(candidate);
    }

    private boolean isMoreThanTenYears(Candidate candidate) {
        return Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .mapToInt(Integer::parseInt)
                .reduce((start, end) -> (end - start) + 1)
                .orElse(0) >= MIN_YEARS_IN_UKRAINE;
    }
}
