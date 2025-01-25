package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        String[] yearsInUkr = candidate.getPeriodsInUkr().split("-");
        int livedInUkr = Integer.parseInt(yearsInUkr[1]) - Integer.parseInt(yearsInUkr[0]);
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && livedInUkr > 10;
    }
}
