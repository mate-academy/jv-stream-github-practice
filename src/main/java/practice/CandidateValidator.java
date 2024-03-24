package practice;

import java.util.function.Predicate;
import model.Candidate;


public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private final int MINIMAL_YEAR = 35;
    private final int FIRST_YEAR = 0;
    private final int SECOND_YEAR = 1;
    private final int MINIMAL_PERIOD_IN_UKRAIN = 10;
    private final String UKRAINIAN = "Ukrainian";

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
                && periodInUKrain >= MINIMAL_PERIOD_IN_UKRAIN;
    }
}
