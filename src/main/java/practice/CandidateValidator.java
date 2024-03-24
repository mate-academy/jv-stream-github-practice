package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final int MINIMAL_YEAR = 35;
    private static final int FIRST_YEAR = 0;
    private static final int SECOND_YEAR = 1;
    private static final int MINIMAL_PERIOD = 10;
    private static final String UKRAINIAN = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        int periodInUKrain =
                Integer.parseInt(candidate.getPeriodsInUkr()
                        .split("-")[SECOND_YEAR])
                        - Integer.parseInt(candidate.getPeriodsInUkr()
                        .split("-")[FIRST_YEAR]);
        return candidate.getAge() >= MINIMAL_YEAR
                && candidate.getNationality().equals(UKRAINIAN)
                && candidate.isAllowedToVote()
                && periodInUKrain >= MINIMAL_PERIOD;
    }
}
