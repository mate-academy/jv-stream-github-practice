package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int FROM_YEAR_INDEX = 0;
    private static final int TO_YEAR_INDEX = 1;
    private static final int YEARS_TO_LIVE_REQUIREMENT = 10;
    private static final int CANDIDATE_MIN_AGE = 35;
    private static final String UKRAINE_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        boolean periodInUkrIsValid = false;

        if (candidate.getPeriodsInUkr() != null
                && candidate.getPeriodsInUkr().contains("-")) {
            String[] periodInUkrAsArray = candidate.getPeriodsInUkr().split("-");
            try {
                periodInUkrIsValid = Integer.parseInt(periodInUkrAsArray[TO_YEAR_INDEX])
                        - Integer.parseInt(periodInUkrAsArray[FROM_YEAR_INDEX])
                        >= YEARS_TO_LIVE_REQUIREMENT;
            } catch (NullPointerException e) {
                periodInUkrIsValid = false;
            }
        }

        return candidate.getAge() >= CANDIDATE_MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINE_NATIONALITY)
                && periodInUkrIsValid;
    }
}
