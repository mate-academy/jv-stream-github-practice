package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKR = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String REGEX = "-";
    private static final int FROM_YEAR_OF_LIVE_IN_UK = 0;
    private static final int TO_YEAR_OF_LIVE_IN_UK = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkraine = candidate.getPeriodsInUkr().split(REGEX);
        int yearsLivingInUK = Integer.parseInt(periodInUkraine[TO_YEAR_OF_LIVE_IN_UK])
                - Integer.parseInt(periodInUkraine[FROM_YEAR_OF_LIVE_IN_UK]);

        return yearsLivingInUK >= MIN_YEARS_IN_UKR
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.getAge() >= MIN_AGE;
    }
}
