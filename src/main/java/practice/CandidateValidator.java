package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private final static int MINIMAL_YEAR = 35;
    private final static int FIRST_YEAR = 0;
    private final static int SECOND_YEAR = 1;
    private final static int MINIMAL_PERIOD_IN_UKRAIN = 10;
    private final static String UKRAINIAN = "Ukrainian";

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
