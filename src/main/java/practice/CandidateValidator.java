package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_YEARS_MUST_LIVE_IN_UKR = 10;
    private static final int CATCH_LAST_INDEX = 1;
    private static final int MIN_AGE_OF_POTENTIAL_PRESIDENT = 35;
    private static final int FIRST_INDEX = 0;

    @Override
    public boolean test(Candidate candidate) {
        String periodInUkr = candidate.getPeriodsInUkr();
        int livedInUkrFromYear = Integer.parseInt(
                periodInUkr.substring(FIRST_INDEX, periodInUkr.indexOf('-')));
        int livedInUkrToYear = Integer.parseInt(
                periodInUkr.substring(periodInUkr.indexOf('-') + CATCH_LAST_INDEX));
        boolean livesEnoughInUkr =
                ((livedInUkrToYear - livedInUkrFromYear) >= MIN_YEARS_MUST_LIVE_IN_UKR);

        return (candidate.getAge() >= MIN_AGE_OF_POTENTIAL_PRESIDENT
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && livesEnoughInUkr);
    }
}
