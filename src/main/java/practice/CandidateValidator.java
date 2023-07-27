package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final int MIN_DURATION_IN_UKRAINE = 10;
    private static final String PERIOD_SPLIT_REGEX = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote() && validateAge(candidate)
                && validateNationality(candidate) && validateDuration(candidate);
    }

    private boolean validateAge(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE;
    }

    private boolean validateNationality(Candidate candidate) {
        return candidate.getNationality().equals(VALID_NATIONALITY);
    }

    private boolean validateDuration(Candidate candidate) {
        int duration = Arrays.stream(candidate.getPeriodsInUkr().split(PERIOD_SPLIT_REGEX))
                .map(Integer::parseInt)
                .reduce((a, b) -> b - a)
                .orElse(0);
        return duration >= MIN_DURATION_IN_UKRAINE;
    }
}
