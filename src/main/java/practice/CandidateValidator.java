package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMAL_ALLOWED_AGE = 35;
    private static final String ALLOWED_NATIONALITY = "Ukrainian";
    private static final int MINIMAL_ALLOWED_PERIOD_IN_UKRAINE = 10;

    private boolean verifyPeriodsInUkraine(Candidate candidate) {
        return Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0])
                >= MINIMAL_ALLOWED_PERIOD_IN_UKRAINE;
    }

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MINIMAL_ALLOWED_AGE
                && candidate.getNationality().equals(ALLOWED_NATIONALITY)
                && verifyPeriodsInUkraine(candidate);
    }
}
