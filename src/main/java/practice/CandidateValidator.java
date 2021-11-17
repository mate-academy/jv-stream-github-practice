package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int CANDIDATES_REQUIRED_AGE = 35;
    private static final int PERIOD_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final int FROM_PERIOD = 0;
    private static final int TO_PERIOD = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkraine = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= CANDIDATES_REQUIRED_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && Integer.parseInt(periodInUkraine[TO_PERIOD])
                - Integer.parseInt(periodInUkraine[FROM_PERIOD]) >= PERIOD_IN_UKRAINE;
    }
}
