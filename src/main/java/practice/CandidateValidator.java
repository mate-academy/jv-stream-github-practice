package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int FIRST_YEAR = 0;
    private static final int LAST_YEAR = 1;
    private static final int CANDIDATE_MIN_AGE = 35;
    private static final int MIN_PERIODS_IN_UKR = 10;
    private static final String SEPARATOR = "-";
    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] firstAndLastYear = candidate.getPeriodsInUkr().split(SEPARATOR);
        int periodsInUkr = Integer.parseInt(firstAndLastYear[LAST_YEAR])
                - Integer.parseInt(firstAndLastYear[FIRST_YEAR]);

        return candidate.getAge() >= CANDIDATE_MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINIAN_NATIONALITY)
                && periodsInUkr >= MIN_PERIODS_IN_UKR;
    }
}
