package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_PERMITTED_AGE = 35;
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final int FROM_PERIOD_INDEX = 0;
    private static final int TO_PERIOD_INDEX = 1;
    private static final String ALLOWED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_PERMITTED_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(ALLOWED_NATIONALITY)
                && getPeriodInUkraine(candidate) >= MIN_PERIOD_IN_UKRAINE;
    }

    private int getPeriodInUkraine(Candidate candidate) {
        String[] splittedPeriods = candidate.getPeriodsInUkr().split("-");
        return (Integer.parseInt(splittedPeriods[TO_PERIOD_INDEX])
                - Integer.parseInt(splittedPeriods[FROM_PERIOD_INDEX]));
    }
}
