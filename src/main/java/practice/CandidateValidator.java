package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_OF_CANDIDATE = 35;
    private static final int TOTAL_MIN_PERIOD_LIVE_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE_OF_CANDIDATE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && isPeriodEnough(candidate.getPeriodsInUkr());
    }

    private boolean isPeriodEnough(String period) {
        String[] years = period.split("-");
        int totalYears = Integer.parseInt(years[1]) - Integer.parseInt(years[0]);
        return totalYears >= TOTAL_MIN_PERIOD_LIVE_IN_UKRAINE;
    }
}
