package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int COLUMN_FROM_YEAR = 0;
    private static final int COLUMN_TO_YEAR = 1;
    private static final int LIMIT_AGE = 35;
    private static final int LIVING_PERIOD = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= LIMIT_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && (Integer.parseInt(periods[COLUMN_TO_YEAR])
                - Integer.parseInt(periods[COLUMN_FROM_YEAR])) >= LIVING_PERIOD;
    }
}
