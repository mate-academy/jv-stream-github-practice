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
        var period = candidate.getPeriodsInUkr().split("-");
        var from = Integer.parseInt(period[0]);
        var to = Integer.parseInt(period[1]);
        return to - from >= 10;
    }
}
