package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_CANDIDATE = 35;
    private static final int MIN_YEARS_LIVE_IN_COUNTRY = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        Integer yearsLive = Arrays.stream(candidate.getPeriodsInUkr().split(SEPARATOR))
                .map(Integer::parseInt)
                .reduce((y1, y2) -> y2 - y1)
                .get();
        return candidate.getAge() >= MIN_AGE_CANDIDATE
                && candidate.getNationality().equals("Ukrainian")
                && candidate.isAllowedToVote()
                && yearsLive > MIN_YEARS_LIVE_IN_COUNTRY;
    }
}
