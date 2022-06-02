package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_MINIMUM_VALID = 35;
    private static final String NATIONALITY_VALID = "ukrainian";
    private static final String PERIODS_IN_COUNTRY_SPLIT = "-";
    private static final int INDEX_BEGIN_IN_COUNTRY = 0;
    private static final int INDEX_END_IN_COUNTRY = 1;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < AGE_MINIMUM_VALID) {
            return false;
        }
        if (!candidate.isAllowedToVote()) {
            return false;
        }
        if (!candidate.getNationality().equalsIgnoreCase(NATIONALITY_VALID)) {
            return false;
        }
        String[] partsPeriodsInUkr = candidate.getPeriodsInUkr().split(PERIODS_IN_COUNTRY_SPLIT);
        return (Integer.parseInt(partsPeriodsInUkr[INDEX_END_IN_COUNTRY])
                - Integer.parseInt(partsPeriodsInUkr[INDEX_BEGIN_IN_COUNTRY])) >= 10;
    }
}
