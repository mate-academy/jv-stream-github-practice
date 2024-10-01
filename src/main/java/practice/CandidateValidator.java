package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator {
    private static final int INCLUDE_START_AND_END_YEAR = 1;
    private static final Predicate<Candidate> isEligibleToVote = candidate ->
            candidate.isAllowedToVote()
                    && candidate.getAge() > 35
                    && candidate.getNationality().equals("Ukrainian")
                    && calculateYearsOfResidence(candidate.getPeriodsInUkr()) >= 10;

    /**
     * Return years of residence in country
     *
     * @param period with period format: "2000-2002".
     * @return year/s of residence in country
     */
    private static int calculateYearsOfResidence(String period) {
        String[] periods = period.split("-");
        int fromYear = Integer.parseInt(periods[0]);
        int toYear = Integer.parseInt(periods[1]);
        return toYear - fromYear + INCLUDE_START_AND_END_YEAR;
    }

    public static Predicate<Candidate> getEligibilityPredicate() {
        return isEligibleToVote;
    }
}
