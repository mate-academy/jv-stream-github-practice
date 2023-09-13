package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final String LIVING_PERIOD_SEPARATOR = "-";
    private static final int REQUIRED_AGE = 35;
    private static final int YEARS_TO_LIVE_IN_UKRAINE = 10;
    private static final int LIVING_PERIOD_START_INDEX = 0;
    private static final int LIVING_PERIOD_END_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodsInUkraine = candidate.getPeriodsInUkr().split(LIVING_PERIOD_SEPARATOR);
        int livingPeriodStart = Integer.parseInt(periodsInUkraine[LIVING_PERIOD_START_INDEX]);
        int livingPeriodEnd = Integer.parseInt(periodsInUkraine[LIVING_PERIOD_END_INDEX]);
        int yearsInUkraine = livingPeriodEnd - livingPeriodStart;
        return candidate.getAge() >= REQUIRED_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && (yearsInUkraine) > YEARS_TO_LIVE_IN_UKRAINE;
    }
}
