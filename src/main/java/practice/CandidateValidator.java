package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_TO_BE_PRESIDENT = 35;
    private static final int INDEX_FROM_LAST_YEAR = 5;
    private static final int INDEX_TO_FIRST_YEAR = 4;
    private static final int MIN_TERM_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        String periodInUkr = candidate.getPeriodsInUkr();
        int yearsInUkr = Integer.parseInt(periodInUkr.substring(INDEX_FROM_LAST_YEAR))
                - Integer.parseInt(periodInUkr.substring(0, INDEX_TO_FIRST_YEAR));
        return candidate.getAge() >= MIN_AGE_TO_BE_PRESIDENT
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && yearsInUkr >= MIN_TERM_IN_UKR;
    }
}
