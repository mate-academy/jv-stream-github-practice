package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_CANDIDATE = 35;
    private static final int MIN_PERIOD_IN_UKR = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int YEAR_TO_INDEX = 1;
    private static final int YEAR_FROM_INDEX = 0;

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsPeriodInUkr = candidate.getPeriodsInUkr().split("-");
        int periodsInUkr = Integer.parseInt(yearsPeriodInUkr[YEAR_TO_INDEX])
                    - Integer.parseInt(yearsPeriodInUkr[YEAR_FROM_INDEX]);
        return candidate.getAge() >= MIN_AGE_CANDIDATE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && periodsInUkr >= MIN_PERIOD_IN_UKR;
    }
}
