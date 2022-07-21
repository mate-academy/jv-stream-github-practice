package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE = 35;
    private static final String CANDIDATE_NATIONALITY = "Ukrainian";
    private static final int MINIMUM_PERIOD_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MINIMUM_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(CANDIDATE_NATIONALITY)
                && calculatePeriodInUkr(candidate) >= MINIMUM_PERIOD_IN_UKRAINE;
    }

    private int calculatePeriodInUkr(Candidate candidate) {
        String[] getYears = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(getYears[1]) - Integer.parseInt(getYears[0]);
    }

}
