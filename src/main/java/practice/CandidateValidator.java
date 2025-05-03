package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int TEN_YEARS_OF_LIVING = 10;
    private static final int MINIMUM_AGE = 35;
    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";
    private static final int UPPER_BOUND_OF_LIVING_INDEX = 1;
    private static final int BOTTOM_BOUND_OF_LIVING_INDEX = 0;

    @Override
    public boolean test(Candidate candidate) {
        String[] splitPeriods = candidate.getPeriodsInUkr().split("-");
        int livingUpperBound = Integer.parseInt(splitPeriods[UPPER_BOUND_OF_LIVING_INDEX]);
        int livingBottomBound = Integer.parseInt(splitPeriods[BOTTOM_BOUND_OF_LIVING_INDEX]);
        int howLongLive = livingUpperBound - livingBottomBound;
        boolean isLivingMoreThanTenYears = howLongLive >= TEN_YEARS_OF_LIVING;

        return candidate.getAge() >= MINIMUM_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINIAN_NATIONALITY)
                && isLivingMoreThanTenYears;
    }
}
