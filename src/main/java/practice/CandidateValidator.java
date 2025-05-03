package practice;

import java.util.function.Predicate;
import java.util.stream.Stream;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final Integer ALLOWED_AGE = 35;
    private static final Integer REQUIRED_PERIOD_OF_LIVING = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= ALLOWED_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && countPeriod(candidate.getPeriodsInUkr()) > REQUIRED_PERIOD_OF_LIVING;
    }

    private int countPeriod(String period) {
        return Stream.of(period.split("-"))
                .map(Integer::parseInt)
                .reduce(0,(a,b) -> Math.abs(a - b));
    }
}
