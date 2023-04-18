package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator {
    Predicate<Candidate> toVote = Candidate::isAllowedToVote;
    Predicate<Candidate> validAge = a -> a.getAge() >= 35;
    Predicate<Candidate> isNationality = c -> c.getNationality().equals("Ukrainian");
    Predicate<Candidate> period = p -> {
        String[] periodOfYear = p.getPeriodsInUkr().split("-");
        return Integer.parseInt(periodOfYear[1]) - Integer.parseInt(periodOfYear[0]) >= 10;
    };
}
