package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String DELIMITER = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && Arrays.stream(candidate.getPeriodsInUkr().split(DELIMITER))
                .mapToInt(Integer::valueOf)
                .reduce((left, right) -> (right - left))
                .orElseThrow(() -> new RuntimeException("Period cannot be calculated!"))
                >= MIN_PERIOD_IN_UKRAINE;
    }
}
