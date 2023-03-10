package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int MIN_AGE = 35;
    public static final int MIN_YEARS_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        String periodInUkr = candidate.getPeriodsInUkr();
        int inUkrFrom = Integer.parseInt(periodInUkr.substring(0, periodInUkr.indexOf('-')));
        int inUkrTo = Integer.parseInt(periodInUkr.substring(periodInUkr.indexOf('-') + 1));
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && inUkrTo - inUkrFrom >= MIN_YEARS_IN_UKR;
    }
}
