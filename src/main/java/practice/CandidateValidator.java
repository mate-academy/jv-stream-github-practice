package practice;

import java.util.function.Predicate;
import java.util.stream.Stream;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final int MIN_VALID_AGE = 35;
    private static final String SPLITTING_CONSTANT = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote() && validateAge(candidate)
                && validateNationality(candidate) && validateDuration(candidate);
    }

    private boolean validateAge(Candidate candidate) {
        return candidate.getAge() >= MIN_VALID_AGE;
    }

    private boolean validateNationality(Candidate candidate) {
        return candidate.getNationality().equals(VALID_NATIONALITY);
    }

    private boolean validateDuration(Candidate candidate) {
        int duration = Stream.of(candidate.getPeriodsInUkr().split(SPLITTING_CONSTANT))
                .mapToInt(Integer::parseInt)
                .reduce((start, end) -> end - start).orElse(0);
        return duration >= MIN_PERIOD_IN_UKRAINE;
    }
}
