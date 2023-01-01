package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_FOR_ELECTION = 35;
    private static final int POSITION_ZERO = 0;
    private static final int POSITION_FIRST = 1;
    private static final int PERIOD = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= AGE_FOR_ELECTION
                && candidate.getNationality().equals(NATIONALITY)
                && Integer.parseInt(candidate.getPeriodsInUkr().split("-")[POSITION_FIRST])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[POSITION_ZERO]) >= PERIOD;
    }
}
