package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int TEN_YEARS_OF_LIVING = 10;
    private static final int MINIMUM_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        String[] splitPeriods = candidate.getPeriodsInUkr().split("-");
        int livingUpperBound = Integer.parseInt(splitPeriods[1]);
        int livingBottomBound = Integer.parseInt(splitPeriods[0]);
        int howLongLive = livingUpperBound - livingBottomBound;
        boolean isLivingMoreThanTenYears = howLongLive >= TEN_YEARS_OF_LIVING;

        return candidate.getAge() >= MINIMUM_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && isLivingMoreThanTenYears;
    }
}
