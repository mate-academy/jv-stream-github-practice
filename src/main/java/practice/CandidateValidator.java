package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int LIVING_PERIOD = 10;
    private static final int START_LIVING_DATA = 0;
    private static final int CURRENT_LIVING_DATA = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate != null
                && candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && "Ukrainian".equals(candidate.getNationality())
                && hasLivedInUkraineForAtLeast10Years(candidate.getPeriodsInUkr());
    }

    public boolean hasLivedInUkraineForAtLeast10Years(String periodsInUkr) {
        if (periodsInUkr == null) {
            return false;
        }

        String[] period = periodsInUkr.split("-");
        if (period.length < 2) {
            return false;
        }

        int startYear;
        int currentYear;

        try {
            startYear = Integer.parseInt(period[START_LIVING_DATA]);
            currentYear = Integer.parseInt(period[CURRENT_LIVING_DATA]);
        } catch (NumberFormatException e) {
            return false;
        }

        return Math.abs(currentYear - startYear) >= LIVING_PERIOD;
    }
}
