package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE = 35;

    private static final int PERIOD_IN_UKRAINE = 10;
    private static final int ARRAY_INDEX_RESPONSIBLE_FOR_THE_BEGINNING_OF_THE_PERIOD = 0;
    private static final int ARRAY_INDEX_RESPONSIBLE_FOR_THE_END_OF_THE_PERIOD = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getNationality().equals("Ukrainian")
                && (candidate.getAge() >= AGE)
                && candidate.isAllowedToVote()
                && (getIntFromString(candidate, ARRAY_INDEX_RESPONSIBLE_FOR_THE_END_OF_THE_PERIOD)
                - getIntFromString(candidate,
                ARRAY_INDEX_RESPONSIBLE_FOR_THE_BEGINNING_OF_THE_PERIOD))
                >= PERIOD_IN_UKRAINE;
    }

    private int getIntFromString(Candidate candidate, int i) {
        return Integer.parseInt(candidate.getPeriodsInUkr().split("-")[i]);
    }
}
