package practice;

import java.util.function.Predicate;
import java.util.stream.Stream;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final Integer ALLOWED_AGE = 35;
    private static final Integer LIVING_YEAR_PERIOD = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= ALLOWED_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && countPeriod(candidate.getPeriodsInUkr()) > LIVING_YEAR_PERIOD;
    }

    public static int countPeriod(String period) {
        return Stream.of(period.split("-"))
                .map(Integer::parseInt)
                .reduce(0,(a,b) -> Math.abs(a - b));
    }
}
