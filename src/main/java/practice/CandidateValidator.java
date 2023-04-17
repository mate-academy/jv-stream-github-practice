package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    static final String UA_NATIONALITY = "Ukrainian";
    static final int CANDIDATES_MINIMUM_AGE = 35;
    static final int LIVING_TERM_IN_UA = 10;

    public boolean test(Candidate candidate) {
        String[] periodInUAstring = candidate.getPeriodsInUkr().split("-");
        int periodInUA = Integer.parseInt(periodInUAstring[1])
                - Integer.parseInt(periodInUAstring[0]);
        return (candidate.getAge() >= CANDIDATES_MINIMUM_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UA_NATIONALITY)
                && periodInUA >= LIVING_TERM_IN_UA);
    }
    //write your code here
}
