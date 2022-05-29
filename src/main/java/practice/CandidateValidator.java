package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_ALLOWED_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int PERIOD_OF_LIVING = 10;
    private static final int FROM_PERIOD = 0;
    private static final int TO_PERIOD = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_ALLOWED_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && getPeriodOfLiving(candidate.getPeriodsInUkr()) >= PERIOD_OF_LIVING;
    }

    private int getPeriodOfLiving(String period) {
        String[] dates = period.split("-");
        return Integer.parseInt(dates[TO_PERIOD])
                - Integer.parseInt(dates[FROM_PERIOD]);
    }
}
