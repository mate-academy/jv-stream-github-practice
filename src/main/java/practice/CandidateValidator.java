package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_YEARS_LIVE_IN_UA = 10;
    private static final int MIN_YEARS_CANDIDATE = 35;
    private static final String NATIONALITY = "ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_YEARS_CANDIDATE
                && candidate.getNationality().toLowerCase().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && getDifferenceBetweenYears(candidate) >= MIN_YEARS_LIVE_IN_UA;
    }

    private int getDifferenceBetweenYears(Candidate candidate) {
        return Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .mapToInt(Integer::parseInt)
                .reduce((s1, s2) -> s2 - s1).orElse(0);
    }
}
