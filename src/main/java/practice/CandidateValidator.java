package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMAL_AGE = 35;
    private static final String ALLOWED_NATIONALITY = "Ukrainian";
    private static final int ALLOWED_PERIOD = 10;
    private static final int PERIODS_IN_UKR_FROM_INDEX = 0;
    private static final int PERIODS_IN_UKR_TO_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split("-");
        int fromYear = Integer.parseInt(periods[PERIODS_IN_UKR_FROM_INDEX]);
        int toYear = Integer.parseInt(periods[PERIODS_IN_UKR_TO_INDEX]);
        int totalPeriodInUkraine = toYear - fromYear;
        return candidate.getNationality().equals(ALLOWED_NATIONALITY)
                && candidate.getAge() >= MINIMAL_AGE
                && totalPeriodInUkraine >= ALLOWED_PERIOD
                && candidate.isAllowedToVote();
    }
}
