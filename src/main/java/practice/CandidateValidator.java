package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < 35) {
            return false;
        }
        if (!candidate.getNationality().equals("Ukrainian")) {
            return false;
        }
        String periods = candidate.getPeriodsInUkr();
        int from = Integer.parseInt(periods.substring(0,4));
        int to = Integer.parseInt(periods.substring(5,9));
        if (to - from < 10) {
            return false;
        }
        return candidate.isAllowedToVote();
    }
}
