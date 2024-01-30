package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final String DEFAULT_NATION_CANDIDATE = "Ukrainian";
    private static final int MIN_LIVING_PERIOD_IN_COUNTRY = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equalsIgnoreCase(DEFAULT_NATION_CANDIDATE)
                && findLivingPeriodForCandidate(candidate) >= MIN_LIVING_PERIOD_IN_COUNTRY;
    }

    private int findLivingPeriodForCandidate(Candidate candidate) {
        return Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .map(Integer::parseInt)
                .mapToInt(i -> i)
                .reduce((a, b) -> Math.abs(b - a))
                .orElseThrow();
    }
}
