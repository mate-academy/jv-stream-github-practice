package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < 35) {
            return false;
        }
        if (!candidate.isAllowedToVote()) {
            return false;
        }
        if (!candidate.getNationality().equals("Ukrainian")) {
            return false;
        }
        if (Integer.parseInt(candidate.getPeriodsInUkr().substring(5, 9))
                - Integer.parseInt(candidate.getPeriodsInUkr().substring(0, 4)) < 10) {
            return false;
        }
        return true;
    }
}
