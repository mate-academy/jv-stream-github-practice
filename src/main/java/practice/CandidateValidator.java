package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_FOR_PRESIDENT = 35;
    private static final int PERIOD_LENGTH = 2;
    private static final int START_INDEX = 0;
    private static final int END_INDEX = 1;
    private static final int MIN_PERIOD_LIVING_IN_UKRAINE = 10;
    private static final String REQUIRED_NATIONALITY_FOR_PRESIDENT = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return isEligibleForPresident(candidate);
    }

    private boolean isEligibleForPresident(Candidate candidate) {
        if (candidate.getAge() < MIN_AGE_FOR_PRESIDENT || !candidate.isAllowedToVote()) {
            return false;
        }
        if (!candidate.getNationality().equals(REQUIRED_NATIONALITY_FOR_PRESIDENT)) {
            return false;
        }
        String[] periods = candidate.getPeriodsInUkr().split("-");
        if (periods.length != PERIOD_LENGTH) {
            return false;
        }
        try {
            int startPeriod = Integer.parseInt((periods[START_INDEX]));
            int endPeriod = Integer.parseInt(periods[END_INDEX]);
            return endPeriod - startPeriod >= MIN_PERIOD_LIVING_IN_UKRAINE;
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid input data: " + e);
        }
    }
}
