package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int AGE_LIMIT = 35;
    private static final int REQUIRED_PERIOD_IN_UKR = 10;
    private static final String PERIOD_PATTERN = "\\d{4}-\\d{4}";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= AGE_LIMIT
                && candidate.isAllowedToVote()
                && NATIONALITY.equals(candidate.getNationality())
                && isEligibleResidency(candidate.getPeriodsInUkr());
    }

    private static boolean isEligibleResidency(String periodInUkr) {
        if (periodInUkr == null || !periodInUkr.matches(PERIOD_PATTERN)) {
            return false;
        }
        String[] years = periodInUkr.split("-");
        int startYear = Integer.parseInt((years[0]));
        int endYear = Integer.parseInt(years[1]);
        return endYear - startYear >= REQUIRED_PERIOD_IN_UKR;
    }
}
