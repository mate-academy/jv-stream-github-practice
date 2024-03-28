package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() > 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && candidate.getPeriodsInUkr().length() >= 10;
    }
}
