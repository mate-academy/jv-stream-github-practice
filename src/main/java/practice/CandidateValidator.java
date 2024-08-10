package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int LIVING_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate != null
                && candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && "Ukrainian".equals(candidate.getNationality())
                && hasLivedInUkraineForAtLeast10Years(candidate.getPeriodsInUkr());
    }

    public boolean hasLivedInUkraineForAtLeast10Years(String periodsInUkr) {
        if (periodsInUkr == null || periodsInUkr.split("-").length < 2) {
            return false;
        }

        String[] period = periodsInUkr.split("-");
        int startYear;
        int currentYear;

        try {
            startYear = Integer.parseInt(period[0]);
            currentYear = Integer.parseInt(period[1]);
        } catch (NumberFormatException e) {
            return false;
        }

        return currentYear - startYear >= LIVING_PERIOD;
    }
}
