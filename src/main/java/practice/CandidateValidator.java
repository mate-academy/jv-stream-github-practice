package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        if (!candidate.isAllowedToVote()) {
            return false;
        }
        if (candidate.getAge() < 35) {
            return false;
        }
        if (!candidate.getNationality().equals("Ukrainian")) {
            return false;
        }
        int startLivingInUkr = Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0]);
        int endLivingInUkr = Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1]);
        if (endLivingInUkr - startLivingInUkr < 10) {
            return false;
        }
        return true;
    }
}
