package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        String[] splittedYearsInUkraine
                = candidate.getPeriodsInUkr().split("-");
        int yearsInUkraine = Integer.parseInt(splittedYearsInUkraine[1])
                - Integer.parseInt(splittedYearsInUkraine[0]);
        return candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && candidate.getAge() >= 35
                && yearsInUkraine >= 10;
    }
}
