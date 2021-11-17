package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_CANDIDATE = 35;
    private static final int MIN_PERIOD_IN_UKR = 10;
    private static final String NATIONALITY_CANDIDATE = "Ukrainian";
    private static final int YEAR_INDEX_TO = 1;
    private static final int YEAR_INDEX_FROM = 0;

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsPeriodInUkr = candidate.getPeriodsInUkr().split("-");
        int periodsInUkr = Integer.parseInt(yearsPeriodInUkr[YEAR_INDEX_TO])
                    - Integer.parseInt(yearsPeriodInUkr[YEAR_INDEX_FROM]);
        return candidate.getAge() >= MIN_AGE_CANDIDATE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY_CANDIDATE)
                && periodsInUkr >= MIN_PERIOD_IN_UKR;
    }
}
