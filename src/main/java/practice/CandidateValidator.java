package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_COUNTRY_LIVE_PERIOD = 10;
    private static final String ALLOWED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && liveInCountryLongEnough(candidate)
                && candidate.isAllowedToVote()
                && ALLOWED_NATIONALITY.equals(candidate.getNationality());
    }

    private boolean liveInCountryLongEnough(Candidate candidate) {
        return Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .mapToInt(Integer::parseInt)
                .reduce((start, end) -> end - start)
                .orElse(0) >= MIN_COUNTRY_LIVE_PERIOD;
    }
}
