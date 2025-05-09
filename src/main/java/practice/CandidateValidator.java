package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int REQUIRED_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && (candidate.getAge() >= REQUIRED_AGE)
                && (candidate.getNationality().equals(REQUIRED_NATIONALITY))
                && getPeriodInUkr(candidate.getPeriodsInUkr());
    }

    private boolean getPeriodInUkr(String period) {
        String[] dates = period.split("-");
        int fromYear = 0;
        int toYear = 0;
        try {
            fromYear = Integer.parseInt(dates[0]);
            toYear = Integer.parseInt(dates[1]);
        } catch (NumberFormatException e) {
            return false;
        }
        return (toYear - fromYear) >= REQUIRED_PERIOD;
    }
}
