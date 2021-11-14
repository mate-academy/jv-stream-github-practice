package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() >= 35 && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")) {
            String[] yearsInUkr = candidate.getPeriodsInUkr().split("-");
            return Integer.parseInt(yearsInUkr[1]) - Integer.parseInt(yearsInUkr[0]) >= 10;
        }
        return false;
    }
}
