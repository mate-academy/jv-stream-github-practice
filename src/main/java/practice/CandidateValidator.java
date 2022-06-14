package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        return candidate.getNationality().equals("Ukrainian") && candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && Integer.parseInt(candidate.getPeriodsInUkr().substring(5))
                - Integer.parseInt(candidate.getPeriodsInUkr().substring(0, 4)) > 10;
    }
}
