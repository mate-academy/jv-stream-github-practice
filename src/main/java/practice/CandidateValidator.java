package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        String[] partsOfYearsInUkraine = candidate.getPeriodsInUkr().split("-");
        int periodInUkraine = Integer.parseInt(partsOfYearsInUkraine[1])
                - Integer.parseInt(partsOfYearsInUkraine[0]);
        return candidate.getAge() >= 35 && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian") && periodInUkraine >= 10;
    }
}
