package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String CANDIDATE_VALIDATOR_EX = "-";

    @Override
    public boolean test(Candidate candidate) {
        int residenceYears = Arrays.stream(candidate.getPeriodsInUkr()
                        .split(CANDIDATE_VALIDATOR_EX))
                .mapToInt(Integer::parseInt)
                .reduce((first, second) -> second - first)
                .orElseThrow(() -> new IllegalArgumentException("Invalid range format"));

        return candidate.getAge() >= 35 && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && residenceYears >= 10;
    }
}
