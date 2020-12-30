package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_LOWER_BOUND = 35;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getNationality().equals("Ukrainian") && candidate.isAllowedToVote()
                && candidate.getAge() >= AGE_LOWER_BOUND
                && Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0]) >= 10;
    }
}
