package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int INDEX_FROM_YEAR = 0;
    private static final int INDEX_TO_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] splittedPeriodInUkr = candidate.getPeriodsInUkr().split("-");
        int periodInYears = Integer.parseInt(splittedPeriodInUkr[INDEX_TO_YEAR])
                - Integer.parseInt(splittedPeriodInUkr[INDEX_FROM_YEAR]);
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && periodInYears >= 10;
    }
    //write your code here

}
