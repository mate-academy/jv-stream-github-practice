package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int VALID_YEARS = 35;
    private static final int MIN_PERIOD = 10;
    private static final String VALID_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        if (!candidate.isAllowedToVote()) {
            return false;
        }
        if (candidate.getAge() < VALID_YEARS) {
            return false;
        }
        if (!candidate.getNationality().equals(VALID_NATIONALITY)) {
            return false;
        }
        return getYearsInUkr(candidate.getPeriodsInUkr()) >= MIN_PERIOD;
    }

    private int getYearsInUkr(String period) {
        return Stream.of(period)
                .flatMap(str -> Arrays.stream(str.split("-")))
                .map(Integer::parseInt).reduce((a, b) -> b - a)
                .orElse(0);
    }
}
