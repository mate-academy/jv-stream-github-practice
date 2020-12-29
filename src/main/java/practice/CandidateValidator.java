package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getNationality().equals("Ukrainian") && candidate.isAllowedToVote()) {
            if (candidate.getAge() >= 35) {
                String[] yearBounds = candidate.getPeriodsInUkr().split("-");
                int yearDiff = Integer.parseInt(yearBounds[1]) - Integer.parseInt(yearBounds[0]);
                return yearDiff >= 10;
            }
        }
        return false;
    }
}
