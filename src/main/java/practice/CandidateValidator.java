package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_YEARS_LIVE_IN_COUNTRY = 10;
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final int YEAR_FROM = 0;
    private static final int YEAR_TO = 1;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodsInUkr = candidate.getPeriodsInUkr().split("-");
        int periodsInUkrFrom = Integer.parseInt(periodsInUkr[YEAR_FROM]);
        int periodsInUkrBefore = Integer.parseInt(periodsInUkr[YEAR_TO]);
        return periodsInUkrBefore - periodsInUkrFrom > MIN_YEARS_LIVE_IN_COUNTRY
                && candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY);
    }
}
