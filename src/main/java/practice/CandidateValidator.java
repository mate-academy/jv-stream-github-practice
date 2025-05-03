package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int FIRST_YEAR = 0;
    private static final int LAST_YEAR = 1;
    private static final int MIN_TERM = 10;
    private static final int MIN_AGE = 35;
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final String YEAR_SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        int term = Integer.parseInt(candidate.getPeriodsInUkr().split(YEAR_SEPARATOR)[LAST_YEAR])
                - Integer.parseInt(candidate.getPeriodsInUkr().split(YEAR_SEPARATOR)[FIRST_YEAR]);
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(VALID_NATIONALITY)
                && candidate.isAllowedToVote()
                && term >= MIN_TERM;
    }
}
