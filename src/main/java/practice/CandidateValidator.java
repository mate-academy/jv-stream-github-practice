package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKR = 10;
    private static final char DIVIDER = '-';
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String periodInUkr = candidate.getPeriodsInUkr();
        int inUkrFrom = Integer.parseInt(periodInUkr.substring(0, periodInUkr.indexOf(DIVIDER)));
        int inUkrTo = Integer.parseInt(periodInUkr.substring(periodInUkr.indexOf(DIVIDER) + 1));
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && inUkrTo - inUkrFrom >= MIN_YEARS_IN_UKR;
    }
}
