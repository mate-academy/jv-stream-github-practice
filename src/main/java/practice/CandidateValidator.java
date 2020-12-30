package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private final int minAge = 35;
    private final int minPeriod = 10;

    @Override
    public boolean test(Candidate candidate) {
        int periodsInUkr = Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0]);
        return candidate.getAge() >= minAge && candidate.getNationality().equals("Ukrainian")
                && periodsInUkr >= minPeriod
                && candidate.isAllowedToVote() ;
    }
}
