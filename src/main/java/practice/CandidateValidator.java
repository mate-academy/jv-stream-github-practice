package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int FROM_AGE = 35;
    private static final int FIRST_YEAR = 0;
    private static final int SECOND_YEAR = 1;
    private static final int YEARS_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= FROM_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && checkYearsInUkr(candidate);
    }

    private boolean checkYearsInUkr(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(periods[SECOND_YEAR])
                - Integer.parseInt(periods[FIRST_YEAR])
                >= YEARS_IN_UKRAINE;
    }
}
