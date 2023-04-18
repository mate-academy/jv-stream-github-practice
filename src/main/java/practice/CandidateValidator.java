package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator {
    private Predicate<Candidate> toVote = Candidate::isAllowedToVote;
    private Predicate<Candidate> validAge = a -> a.getAge() >= 35;
    private Predicate<Candidate> isNationality = c -> c.getNationality().equals("Ukrainian");
    private Predicate<Candidate> period = p -> {
        String[] periodOfYear = p.getPeriodsInUkr().split("-");
        return Integer.parseInt(periodOfYear[1]) - Integer.parseInt(periodOfYear[0]) >= 10;
    };
}
