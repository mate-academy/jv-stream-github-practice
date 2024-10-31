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
                && (getIntFromString(candidate, 1)
                - getIntFromString(candidate, 0))
                >= PERIOD_IN_UKRAINE;
    }

    private int getIntFromString(Candidate candidate, int i) {
        int result = 0;
        try {
            result = Integer.parseInt(candidate.getPeriodsInUkr().split("-")[i]);
        } catch (RuntimeException e) {
            new RuntimeException("This string format not support");
        }
        return result;
    }
}
