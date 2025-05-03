package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String validNationality = "Ukrainian";
    private static final int validMinAge = 35;
    private static final int validMinPeriodsInUkr = 10;
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        int periodsInUkraine = Arrays.stream(candidate.getPeriodsInUkr().split(SEPARATOR))
                .mapToInt(Integer::parseInt)
                .reduce((a, b) -> a - b).orElse(0);

        return candidate.getAge() >= validMinAge
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(validNationality)
                && Math.abs(periodsInUkraine) >= validMinPeriodsInUkr;
    }
}
