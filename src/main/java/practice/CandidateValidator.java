package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MINIMUM_PERIOD_IN_COUNTRY = 10;

    @Override
    public boolean test(Candidate candidate) {
        boolean hasMinumumPeriodOfResidence = Arrays
                .stream(candidate.getPeriodsInUkr()
                .split("-"))
                .map(Integer::valueOf)
                .reduce(0, (a, b) -> b - a) >= MINIMUM_PERIOD_IN_COUNTRY;
        return candidate.getAge() >= MINIMUM_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && hasMinumumPeriodOfResidence;
    }
}
