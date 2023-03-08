package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_TO_LIVE = 10;
    private static final int INDEX_OF_LAST_YEAR = 1;
    private static final int INDEX_OF_FIRST_YEAR = 0;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate e) {
        return e.getAge() >= MIN_AGE
                && e.isAllowedToVote()
                && e.getNationality().equals(REQUIRED_NATIONALITY)
                && (Integer.parseInt(e.getPeriodsInUkr().split("-")[INDEX_OF_LAST_YEAR])
                - Integer.parseInt(e.getPeriodsInUkr().split("-")[INDEX_OF_FIRST_YEAR]))
                >= MIN_YEARS_TO_LIVE;
    }
}
