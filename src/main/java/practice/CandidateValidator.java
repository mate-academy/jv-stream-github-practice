package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE = 35;
    private static final int PERIOD_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getNationality().equals("Ukrainian")
                && (candidate.getAge() >= AGE)
                && candidate.isAllowedToVote()
                && ((Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0]))
                >= PERIOD_IN_UKRAINE);
    }
}
