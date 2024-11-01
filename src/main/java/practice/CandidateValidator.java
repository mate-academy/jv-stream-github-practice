package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_LIMIT = 35;
    private static final String NATIONALITY_ALLOWED = "Ukrainian";
    private static final int MIN_YEARS_OF_LIVING_IN_UKR = 10;
    private static final char YEARS_SEP = '-';

    @Override
    public boolean test(Candidate candidate) {
        String periodInUkr = candidate.getPeriodsInUkr();
        int fromYear = Integer.parseInt(periodInUkr.substring(0,periodInUkr.indexOf(YEARS_SEP)));
        int toYear = Integer.parseInt(periodInUkr.substring(periodInUkr.indexOf(YEARS_SEP) + 1));
        int yearsInUkr = toYear - fromYear;
        if (candidate.getAge() >= AGE_LIMIT
                && candidate.getNationality().equals(NATIONALITY_ALLOWED)
                && yearsInUkr >= MIN_YEARS_OF_LIVING_IN_UKR && candidate.isAllowedToVote()) {
            return true;
        }
        return false;
    }
}
