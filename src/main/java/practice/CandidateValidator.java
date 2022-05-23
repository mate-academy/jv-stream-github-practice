package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String ALLOWED_NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final int FIRST_YEAR_IN_UKRAINE_INDEX = 0;
    private static final int LAST_YEAR_IN_UKRAINE_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(ALLOWED_NATIONALITY)
                && candidate.isAllowedToVote()
                && Integer.parseInt(candidate.getPeriodsInUkr()
                .split("-")[LAST_YEAR_IN_UKRAINE_INDEX])
                - Integer.parseInt(candidate.getPeriodsInUkr()
                .split("-")[FIRST_YEAR_IN_UKRAINE_INDEX])
                >= MIN_PERIOD_IN_UKRAINE;
    }
}
