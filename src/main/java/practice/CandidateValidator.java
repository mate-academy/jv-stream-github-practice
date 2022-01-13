package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final int PERIOD_IN_UKR_LIMIT = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null) {
            return false;
        }
        if (!candidate.isAllowedToVote()) {
            return false;
        }
        if (candidate.getAge() < MIN_AGE) {
            return false;
        }
        if (!VALID_NATIONALITY.equals(candidate.getNationality())) {
            return false;
        }
        return periodsIsValid(candidate.getPeriodsInUkr());
    }

    private boolean periodsIsValid(String periodsInUkr) {
        String[] yearStrings = periodsInUkr.split("-");
        int startPeriod = Integer.parseInt(yearStrings[0]);
        int endPeriod = Integer.parseInt(yearStrings[1]);
        return (endPeriod - startPeriod >= PERIOD_IN_UKR_LIMIT);
    }
}
