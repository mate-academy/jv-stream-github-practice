package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_OF_CANDIDACY = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MINIMUM_YEARS_LIVING = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (!candidate.isAllowedToVote()) {
            return false;
        }
        if (candidate.getAge() < AGE_OF_CANDIDACY) {
            return false;
        }
        if (!candidate.getNationality().equals(NATIONALITY)) {
            return false;
        }
        String [] periods = candidate.getPeriodsInUkr().split("-");
        if (periods.length == 0) {
            return false;
        }
        if (periods.length == 2) {
            int startYear = Integer.parseInt(periods[0]);
            int endYear = Integer.parseInt(periods[1]);
            if (endYear - startYear < MINIMUM_YEARS_LIVING) {
                return false;
            }
        }
        return true;
    }
}
