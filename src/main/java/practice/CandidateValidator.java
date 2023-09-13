package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        String[] parts = candidate.getPeriodsInUkr().split("-");
        int periodsInUkr = (Integer.parseInt(parts[1]) - Integer.parseInt(parts[0]));
        return candidate.getAge() >= 35 && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && periodsInUkr >= 10;
    }
}
