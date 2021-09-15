package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int INDEX_FROM_YEAR = 0;
    private static final int INDEX_TO_YEAR = 1;
    private static final int MIN_YEARS = 35;
    private static final int MIN_PERIOD_IN_UKR = 10;
    private static final String SPLIT_REGEX = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] splittedPeriodInUkr = candidate.getPeriodsInUkr().split(SPLIT_REGEX);
        int periodInYears = Integer.parseInt(splittedPeriodInUkr[INDEX_TO_YEAR])
                - Integer.parseInt(splittedPeriodInUkr[INDEX_FROM_YEAR]);
        return candidate.getAge() >= MIN_YEARS
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && periodInYears >= MIN_PERIOD_IN_UKR;
    }
    //write your code here

}
