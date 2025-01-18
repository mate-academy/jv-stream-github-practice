package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MINIMUM_YEARS_IN_UKRAINE = 10;
    private static final int INDEX_OF_START_PERIOD = 0;
    private static final int INDEX_OF_END_PERIOD = 1;
    private static final String DASH_SIGN = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MINIMUM_AGE
               && candidate.getNationality().equals(REQUIRED_NATIONALITY)
               && candidate.isAllowedToVote()
               && getResidencyYearsInUkraine(candidate) >= MINIMUM_YEARS_IN_UKRAINE;
    }

    private int getResidencyYearsInUkraine(Candidate candidate) {
        int startPeriod = Integer.parseInt(candidate.getPeriodsInUkr()
                .split(DASH_SIGN)[INDEX_OF_START_PERIOD]);
        int endPeriod = Integer.parseInt(candidate.getPeriodsInUkr()
                .split(DASH_SIGN)[INDEX_OF_END_PERIOD]);
        return endPeriod - startPeriod;
    }

    //write your code here
}
