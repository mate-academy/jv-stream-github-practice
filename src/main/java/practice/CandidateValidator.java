package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        int yearsInUkraine = Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0]);
        return candidate.getAge() >= 35 && candidate.getNationality().equals("Ukrainian")
                && candidate.isAllowedToVote() && yearsInUkraine >= 10;
    }
}
