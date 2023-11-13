package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split("-");
        int period = Integer.parseInt(periods[1]) - Integer.parseInt(periods[0]);
        if (candidate.getAge() < 35) {
            return false;
        }
        if (!candidate.getNationality().equals("Ukrainian")) {
            return false;
        }
        if (period < 10) {
            return false;
        }
        if (!candidate.isAllowedToVote()) {
            return false;
        }
        return true;
    }

}
