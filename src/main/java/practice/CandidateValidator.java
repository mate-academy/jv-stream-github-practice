package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_ALLOWED_PRESIDENTIAL_AGE = 35;
    private static final int MIN_REQUIRED_PERIOD = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        Integer totalPeriodInCountry = Arrays.stream(candidate.getPeriodsInUkr()
                .split("-"))
                .map(Integer::parseInt)
                .reduce(0, (a, b) -> b - a);
        return candidate.getAge() >= MIN_ALLOWED_PRESIDENTIAL_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && totalPeriodInCountry >= MIN_REQUIRED_PERIOD;
    }
}
