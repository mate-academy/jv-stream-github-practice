package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35
                && candidate.getNationality().equals("Ukrainian")
                && candidate.isAllowedToVote()
                && (Integer.valueOf(candidate.getPeriodsInUkr().substring(5))
                - Integer.valueOf(candidate.getPeriodsInUkr().substring(0, 4))) >= 10;
    }
}
