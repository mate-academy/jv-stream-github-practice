package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_REQUIRED_FROM = 35;
    private static final String NATIONALITY_REQUIRED = "Ukrainian";
    private static final int YEARS_OF_LIVING_REQUIRED = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] splitPeriod = candidate.getPeriodsInUkr().split("-");
        int livingPeriodFrom = Integer.parseInt(splitPeriod[0]);
        int livingPeriodTo = Integer.parseInt(splitPeriod[1]);

        return candidate.getAge() >= AGE_REQUIRED_FROM
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY_REQUIRED)
                && (livingPeriodTo - livingPeriodFrom) >= YEARS_OF_LIVING_REQUIRED;
    }
}
