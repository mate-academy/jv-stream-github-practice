package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null) {
            return false;
        }
        if (candidate.getAge() < 35) {
            return false;
        }
        if (!candidate.isAllowedToVote()) {
            return false;
        }
        if (!candidate.getNationality().equals("Ukrainian")) {
            return false;
        }
        String yearsInUkraine = candidate.getPeriodsInUkr();
        return Integer.parseInt(yearsInUkraine.substring(yearsInUkraine.indexOf("-") + 1))
                - Integer.parseInt(yearsInUkraine.substring(0, yearsInUkraine.indexOf("-"))) > 10;
    }
}
