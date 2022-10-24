package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE_REQUIRED = 35;
    private static final String NATIONALITY_REQUIRED = "Ukrainian";
    private static final String PERIODS_SEPARATOR = "-";
    private static final int POSITION_FROM = 0;
    private static final int POSITION_TO = 1;
    private static final int PERIODS_IN_UKRAINE_REQUIRED = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MINIMUM_AGE_REQUIRED
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY_REQUIRED)
                && isPeriodsInUkraineSatisfied(candidate.getPeriodsInUkr());
    }

    private boolean isPeriodsInUkraineSatisfied(String period) {
        String[] split = period.split(PERIODS_SEPARATOR);
        int calculatedPeriod = Integer.parseInt(split[POSITION_TO])
                - Integer.parseInt(split[POSITION_FROM]);
        return calculatedPeriod >= PERIODS_IN_UKRAINE_REQUIRED;
    }
}
