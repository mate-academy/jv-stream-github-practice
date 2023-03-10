package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int MIN_AGE = 35;
    public static final int MIN_YEARS_IN_UKR = 10;
    public static final char DIVIDER = '-';
    public static final String NATIONALITY = "Ukrainian";

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
