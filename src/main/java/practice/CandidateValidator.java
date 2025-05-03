package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_REQUIRED_FROM = 35;
    private static final String NATIONALITY_REQUIRED = "Ukrainian";
    private static final int YEARS_OF_LIVING_REQUIRED = 10;
    private static final int INDEX_PERIOD_FROM = 0;
    private static final int INDEX_PERIOD_TO = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] splitPeriod = candidate.getPeriodsInUkr().split("-");
        int livingPeriodFrom = Integer.parseInt(splitPeriod[INDEX_PERIOD_FROM]);
        int livingPeriodTo = Integer.parseInt(splitPeriod[INDEX_PERIOD_TO]);

        return candidate.getAge() >= AGE_REQUIRED_FROM
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY_REQUIRED)
                && (livingPeriodTo - livingPeriodFrom) >= YEARS_OF_LIVING_REQUIRED;
    }
}
