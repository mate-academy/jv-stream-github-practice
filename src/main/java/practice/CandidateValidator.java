package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_THRESHOLD = 35;
    private static final int PERIOD_THRESHOLD = 10;

    @Override
    public boolean test(final Candidate candidate) {
        int startYear = Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0]);
        int endYear = Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1]);
        return candidate.getAge() >= AGE_THRESHOLD && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && endYear - startYear >= PERIOD_THRESHOLD;
    }
}
