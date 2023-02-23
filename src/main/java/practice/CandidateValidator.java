package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final int MIN_AGE = 35;
    private static final int MIN_LIVING_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        Integer from = Integer.valueOf(candidate.getPeriodsInUkr().substring(0,4));
        Integer to = Integer.valueOf(candidate.getPeriodsInUkr().substring(5));
        if (candidate.isAllowedToVote()) {
            if (candidate.getAge() >= MIN_AGE) {
                if (candidate.getNationality().equals("Ukrainian")) {
                    return (to - from) >= MIN_LIVING_PERIOD;
                }
            }
        }
        return false;
    }
}
