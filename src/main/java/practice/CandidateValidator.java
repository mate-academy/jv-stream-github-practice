package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split("-");
        int periodsInUkr = Integer.parseInt(periods[1]) - Integer.parseInt(periods[0]);
        return (candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && periodsInUkr >= 10);
    }
}
