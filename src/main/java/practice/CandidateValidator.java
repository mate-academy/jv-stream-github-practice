package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_IN_UKR = 10;
    private static final byte FIRST_YEAR_INDEX = 0;
    private static final byte LAST_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkr = candidate.getPeriodsInUkr().split("-");
        int yearsInUkr = Integer.parseInt(periodInUkr[LAST_YEAR_INDEX])
                - Integer.parseInt(periodInUkr[FIRST_YEAR_INDEX]);
        return candidate.getAge() >= MIN_AGE && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote() && yearsInUkr >= MIN_YEARS_IN_UKR;
    }
}
