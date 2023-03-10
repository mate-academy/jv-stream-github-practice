package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final int FROM_YEAR = 0;
    private static final int TO_YEAR = 1;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsInUkraine = candidate.getPeriodsInUkr().split("-");
        int periodInUkraine = Integer.parseInt(yearsInUkraine[TO_YEAR])
                - Integer.parseInt(yearsInUkraine[FROM_YEAR]);
        return candidate.getAge() >= MIN_CANDIDATE_AGE
                && periodInUkraine >= MIN_PERIOD_IN_UKRAINE
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote();
    }
}
