package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    public static final int MINIMUM_AGE = 35;
    public static final String NATIONALITY = "Ukrainian";
    public static final int PERIOD_LIVE = 10;

    @Override
    public boolean test(final Candidate candidate) {
        if (candidate.getAge() < MINIMUM_AGE) {
            return false;
        }
        if (!candidate.getNationality().equals(NATIONALITY)) {
            return false;
        }
        if (!candidate.isAllowedToVote()) {
            return false;
        }
        return calculateTotalPeriod(candidate) >= PERIOD_LIVE;
    }

    private static int calculateTotalPeriod(final Candidate candidate) {
        String periodsInUkr = candidate.getPeriodsInUkr();
        String[] periodRange = periodsInUkr.split("-");
        int startYear = Integer.parseInt(periodRange[0]);
        int endYear = Integer.parseInt(periodRange[1]);
        return endYear - startYear;
    }
}
