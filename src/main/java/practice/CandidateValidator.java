package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD_OF_LIVING = 10;
    private static final int YEAR_FROM_INDEX = 0;
    private static final int YEAR_TO_INDEX = 1;
    private static final String SIGN = "-";
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsInUkraine = candidate.getPeriodsInUkr().split(SIGN);
        int periodInUkraine = Integer.parseInt(yearsInUkraine[YEAR_TO_INDEX])
                - Integer.parseInt(yearsInUkraine[YEAR_FROM_INDEX]);
        if (candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && periodInUkraine >= MIN_PERIOD_OF_LIVING) {
            return true;
        }
        return false;
    }
}
