package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_YEAR_LIVE_COUNTRY = 10;
    private static final int MIN_CANDIDATE_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodsInUkr = candidate.getPeriodsInUkr().split("-");
        int periodsInUkrFrom = Integer.parseInt(periodsInUkr[0]);
        int periodsInUkrBefore = Integer.parseInt(periodsInUkr[1]);

        if (periodsInUkrBefore - periodsInUkrFrom > MIN_YEAR_LIVE_COUNTRY
                && candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.isAllowedToVote() == true
                && candidate.getNationality().equals("Ukrainian")) {
            return true;
        }
        return false;
    }
}
