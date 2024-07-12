package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int ALLOWED_AGE_TO_VOTE_CANDIDATE = 35;
    private static final String ALLOWED_NATIONALITY = "Ukrainian";
    private static final int ALLOWED_PERIOD_YEARS_TO_LIVE_IN_UKRAINE = 10;
    private static final String PERIOD_DELIMITER = "-";
    private static final int FROM_PERIOD_INDEX = 0;
    private static final int TO_PERIOD_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= ALLOWED_AGE_TO_VOTE_CANDIDATE
                && candidate.getNationality().equals(ALLOWED_NATIONALITY)
                && calculatePeriodInUkr(candidate.getPeriodsInUkr())
                > ALLOWED_PERIOD_YEARS_TO_LIVE_IN_UKRAINE;
    }

    private int calculatePeriodInUkr(String period) {
        String[] periods = period.split(PERIOD_DELIMITER);
        int fromPeriod = Integer.parseInt(periods[FROM_PERIOD_INDEX]);
        int toPeriod = Integer.parseInt(periods[TO_PERIOD_INDEX]);
        return toPeriod - fromPeriod;
    }
}
