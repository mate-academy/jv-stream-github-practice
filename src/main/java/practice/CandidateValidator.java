package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MAX_AGE = 35;
    private static final int MINIMUM_AMOUNT_OF_YEARS = 10;
    private static final int INDEX_OF_LAST_YEAR = 1;
    private static final int INDEX_OF_FIRST_YEAR = 0;

    @Override
    public boolean test(Candidate e) {
        return e.getAge() >= MAX_AGE
                && e.isAllowedToVote()
                && e.getNationality().equals("Ukrainian")
                && (Integer.parseInt(e.getPeriodsInUkr().split("-")[INDEX_OF_LAST_YEAR])
                - Integer.parseInt(e.getPeriodsInUkr().split("-")[INDEX_OF_FIRST_YEAR]))
                >= MINIMUM_AMOUNT_OF_YEARS;
    }
}
