package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String CANDIDATE_VALIDATOR_EX = "-";
    private static final int MIN_RESIDENCE_TIME = 10;
    private static final int MIN_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        int residenceYears = Arrays.stream(candidate.getPeriodsInUkr()
                        .split(CANDIDATE_VALIDATOR_EX))
                .mapToInt(Integer::parseInt)
                .reduce((first, second) -> second - first)
                .orElseThrow(() -> new IllegalArgumentException("Invalid range format"));

        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && residenceYears >= MIN_RESIDENCE_TIME;
    }
}
