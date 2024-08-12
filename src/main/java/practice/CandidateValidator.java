package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final int LIVING_PERIOD = 10;
    private static final int INDEX_LEAVE_FROM = 0;
    private static final int INDEX_LEAVE_TO = 1;
    private static final int PERIODS_LENGTH = 2;

    @Override
    public boolean test(Candidate candidate) {
        return candidate != null
                && candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && UKRAINIAN_NATIONALITY.equals(candidate.getNationality())
                && isValidByResidenceInUkraine(candidate.getPeriodsInUkr());
    }

    private boolean isValidByResidenceInUkraine(String periodsInUkr) {
        String[] yearsInUkraine = periodsInUkr.split("\\D+");
        if (yearsInUkraine.length < PERIODS_LENGTH) {
            return false;
        }
        try {
            int fromYear = Integer.parseInt(yearsInUkraine[INDEX_LEAVE_FROM]);
            int toYear = Integer.parseInt(yearsInUkraine[INDEX_LEAVE_TO]);
            return (toYear - fromYear) >= LIVING_PERIOD;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
