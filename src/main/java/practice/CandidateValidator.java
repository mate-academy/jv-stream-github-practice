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
        if (!candidate.getNationality().equals("Ukrainian")) {
            return false;
        }
        if (!candidate.isAllowedToVote()) {
            return false;
        }
        String[] stringPeriod = candidate.getPeriodsInUkr().split("-");
        int intPeriod = Integer.parseInt(stringPeriod[1]) - Integer.parseInt(stringPeriod[0]);
        return intPeriod >= 10;
    }
}