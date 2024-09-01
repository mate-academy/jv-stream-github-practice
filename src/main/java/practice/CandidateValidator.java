package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final int MINIMUM_ELIGIBLE_AGE = 35;
    private static final int REQUIRED_PRESENCE_TIMESPAN = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MINIMUM_ELIGIBLE_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && candidate.isAllowedToVote()
                && isLongEnoughInCountry(candidate);
    }

    private boolean isLongEnoughInCountry(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split("-");
        int start = Integer.parseInt(periods[0]);
        int end = Integer.parseInt(periods[1]);
        return (end - start) >= REQUIRED_PRESENCE_TIMESPAN;
    }
}
