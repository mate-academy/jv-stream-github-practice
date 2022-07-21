package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE = 35;
    private static final String REQUIRED_CANDIDATE_NATIONALITY = "Ukrainian";
    private static final int MINIMUM_PERIOD_IN_UKRAINE = 10;
    private static final int PERIOD_START_INDEX = 0;
    private static final int PERIOD_END_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MINIMUM_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_CANDIDATE_NATIONALITY)
                && calculatePeriodInUkr(candidate) >= MINIMUM_PERIOD_IN_UKRAINE;
    }

    private int calculatePeriodInUkr(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(years[PERIOD_END_INDEX])
                - Integer.parseInt(years[PERIOD_START_INDEX]);
    }
}
