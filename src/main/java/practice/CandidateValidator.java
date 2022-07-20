package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_YEAR_LIVE_COUNTRY = 10;
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final int FROM_YEAR = 0;
    private static final int BEFORE_YEAR = 1;
    private static final String CANDIDATE_FROM_COUNTRY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodsInUkr = candidate.getPeriodsInUkr().split("-");
        int periodsInUkrFrom = Integer.parseInt(periodsInUkr[FROM_YEAR]);
        int periodsInUkrBefore = Integer.parseInt(periodsInUkr[BEFORE_YEAR]);
        return periodsInUkrBefore - periodsInUkrFrom > MIN_YEAR_LIVE_COUNTRY
                && candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(CANDIDATE_FROM_COUNTRY);
    }
}
