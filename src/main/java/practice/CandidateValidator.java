package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    static final String VALID_NATIONAL = "Ukrainian";
    static final int MIN_AGE = 35;
    static final int MIN_TIME_IN_UKRAINE = 10;
    static final int VALID_SPLIT_LENGTH = 2;
    static final int START_DATE_POSITION_AFTER_SPLIT = 0;
    static final int END_DATE_POSITION_AFTER_SPLIT = 1;

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
        if (periods.length != VALID_SPLIT_LENGTH) {
            return false;
        }
        int startYear = Integer.parseInt(periods[START_DATE_POSITION_AFTER_SPLIT]);
        int endYear = Integer.parseInt(periods[END_DATE_POSITION_AFTER_SPLIT]);
        if ((endYear - startYear) < MIN_TIME_IN_UKRAINE) {
            return true;
        }
        return false;
    }
}
