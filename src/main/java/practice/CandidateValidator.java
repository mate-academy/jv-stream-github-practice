package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String UA_NATIONALITY = "Ukrainian";
    private static final int CANDIDATES_MINIMUM_AGE = 35;
    private static final int LIVING_TERM_IN_UA = 10;
    private static final int INDEX_PERIOD_IN_UA_START = 0;
    private static final int INDEX_PERIOD_IN_UA_FINISH = 1;

    public boolean test(Candidate candidate) {
        String[] periodInUAstring = candidate.getPeriodsInUkr().split("-");
        int periodInUA = Integer.parseInt(periodInUAstring[INDEX_PERIOD_IN_UA_FINISH])
                - Integer.parseInt(periodInUAstring[INDEX_PERIOD_IN_UA_START]);
        return (candidate.getAge() >= CANDIDATES_MINIMUM_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UA_NATIONALITY)
                && periodInUA >= LIVING_TERM_IN_UA);
    }
    //write your code here
}
