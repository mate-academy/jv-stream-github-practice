package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String ALLOWED_NATIONALITY = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final int MIN_LEAVING_PERIOD_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] leavingPeriod = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(ALLOWED_NATIONALITY)
                && Integer.parseInt(leavingPeriod[1]) - Integer.parseInt(leavingPeriod[0])
                >= MIN_LEAVING_PERIOD_IN_UKRAINE;
    }
}
