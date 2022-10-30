package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String ALLOWED_NATIONALITY = "Ukrainian";
    private static final int INDEX_FROM_YEAR = 0;
    private static final int INDEX_TO_YEAR = 1;
    private static final int MIN_AGE = 35;
    private static final int MIN_LEAVING_PERIOD_IN_UKRAINE = 10;
    private static final String YEAR_SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] leavingPeriod = candidate.getPeriodsInUkr().split(YEAR_SEPARATOR);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(ALLOWED_NATIONALITY)
                && Integer.parseInt(leavingPeriod[INDEX_TO_YEAR])
                - Integer.parseInt(leavingPeriod[INDEX_FROM_YEAR])
                >= MIN_LEAVING_PERIOD_IN_UKRAINE;
    }
}
