package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
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
        if(periodsIsInvalid(candidate.getPeriodsInUkr())) {
            return false;
        }
        return true;
    }

    private boolean periodsIsInvalid(String periodsInUkr) {
        try {
            int startPeriod = Integer.parseInt(periodsInUkr.substring(0,4));
            int endPeriod = Integer.parseInt(periodsInUkr.substring(5,9));
            if (endPeriod - startPeriod < PERIOD_IN_UKR_LIMIT) {
                return true;
            }
        } catch (Exception e) {
            return true;
        }
        return false;
    }
}
