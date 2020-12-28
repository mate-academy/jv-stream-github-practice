package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        String[] yearsInUkraine = candidate.getPeriodsInUkr().split("-");
        int periodInUkraine = Integer.parseInt(yearsInUkraine[1]) - Integer.parseInt(yearsInUkraine[0]);
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && periodInUkraine >= 10;
    }
}
