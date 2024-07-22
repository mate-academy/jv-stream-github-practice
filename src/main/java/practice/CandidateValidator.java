package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final int AGE_CANDIDATE = 35;
    private static final int COUNT_YEARS_RESIDENCE = 10;
    private static final int START_DATA = 0;
    private static final int END_DATA = 1;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < AGE_CANDIDATE || !candidate.isAllowedToVote()
                || !"Ukrainian".equals(candidate.getNationality())) {
            return false;
        }

        String[] periods = candidate.getPeriodsInUkr().split("-");
        int startYear = Integer.parseInt(periods[START_DATA]);
        int endYear = Integer.parseInt(periods[END_DATA]);
        return (endYear - startYear) >= COUNT_YEARS_RESIDENCE;
    }
}
