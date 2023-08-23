package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final String YEARS_DELIMITER = "-";
    private static final int LOWER_AGE_LIMIT = 35;
    private static final int MIN_RESIDENCY_YEARS = 10;
    private static final int FROM_YEAR = 0;
    private static final int TO_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] residencyRange = candidate.getPeriodsInUkr().split(YEARS_DELIMITER);
        int residencyYears = Integer.parseInt(residencyRange[TO_YEAR])
                - Integer.parseInt(residencyRange[FROM_YEAR]);

        if (residencyYears < MIN_RESIDENCY_YEARS) {
            return false;
        }

        if (!candidate.isAllowedToVote()) {
            return false;
        }

        if (!NATIONALITY.equals(candidate.getNationality())) {
            return false;
        }

        if (candidate.getAge() < LOWER_AGE_LIMIT) {
            return false;
        }

        return true;
    }
    //write your code here
}
