package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int CANDIDATE_FROM_AGE = 35;
    private static final String CANDIDATE_NATIONALITY = "Ukrainian";
    private static final int YEARS_IN_UKRAINE = 10;
    private static final int FROM_PERIOD_INDEX = 0;
    private static final int TO_PERIOD_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodsArray = candidate.getPeriodsInUkr().split("-");
        int actualYears = Integer.parseInt(periodsArray[TO_PERIOD_INDEX])
                - Integer.parseInt(periodsArray[FROM_PERIOD_INDEX]);
        return candidate.getAge() >= CANDIDATE_FROM_AGE
                && candidate.getNationality().equals(CANDIDATE_NATIONALITY)
                && candidate.isAllowedToVote()
                && actualYears >= YEARS_IN_UKRAINE;
    }
}
