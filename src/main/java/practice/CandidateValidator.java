package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMAL_ALLOWED_AGE = 35;
    private static final String ALLOWED_NATIONALITY = "Ukrainian";
    private static final int MINIMAL_ALLOWED_PERIOD_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] candidatePeriodInUkraine = candidate.getPeriodsInUkr().split("-");
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MINIMAL_ALLOWED_AGE
                && candidate.getNationality().equals(ALLOWED_NATIONALITY)
                && Integer.parseInt(candidatePeriodInUkraine[1])
                - Integer.parseInt(candidatePeriodInUkraine[0])
                >= MINIMAL_ALLOWED_PERIOD_IN_UKRAINE;

    }
}
