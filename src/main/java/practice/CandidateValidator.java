package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    static final String VALID_NATIONAL = "Ukrainian";
    static final int MIN_AGE = 35;
    static final int MIN_TIME_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (!VALID_NATIONAL.equals(candidate.getNationality())) {
            return false;
        }
        if (candidate.getAge() < MIN_AGE) {
            return false;
        }
        if (!candidate.isAllowedToVote()) {
            return false;
        }
        if (timeInUkraineValidator(candidate)) {
            return false;
        }
        return true;
    }

    private boolean timeInUkraineValidator(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split("-");
        if (periods.length != 2) {
            return false;
        }
        int startYear = Integer.parseInt(periods[0]);
        int endYear = Integer.parseInt(periods[1]);
        if ((endYear - startYear) < MIN_TIME_IN_UKRAINE) {
            return true;
        }
        return false;
    }
}
