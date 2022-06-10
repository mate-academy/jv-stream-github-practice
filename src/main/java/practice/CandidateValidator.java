package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getClass().equals(Candidate.class)
                && candidate.getAge() >= 35
                && candidate.getNationality().equals("Ukrainian")
                && candidate.isAllowedToVote()
                && (Integer.parseInt(candidate.getPeriodsInUkr().substring(5))
                - Integer.parseInt(candidate.getPeriodsInUkr().substring(0, 4))) >= 10;
    }
}
