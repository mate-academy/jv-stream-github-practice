package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int FROM_YEAR_INDEX = 0;
    private static final int TO_YEAR_INDEX = 1;
    private static final int MIN_YEARS_IN_UKRAINE = 10;

    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("-");
        int yearsInUkraine = Integer.parseInt(period[TO_YEAR_INDEX])
                - Integer.parseInt(period[FROM_YEAR_INDEX]);
        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && yearsInUkraine >= MIN_YEARS_IN_UKRAINE;
    }
}
