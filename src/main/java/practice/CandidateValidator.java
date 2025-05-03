package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final int FROM_PERIOD_INDEX = 0;
    private static final int TO_PERIOD_INDEX = 1;
    private static final String ALLOWED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] fromToPeriods = candidate.getPeriodsInUkr().split("-");
        int period = (Integer.parseInt(fromToPeriods[TO_PERIOD_INDEX])
                - Integer.parseInt(fromToPeriods[FROM_PERIOD_INDEX]));
        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(ALLOWED_NATIONALITY)
                && period >= MIN_PERIOD_IN_UKRAINE;
    }
}
