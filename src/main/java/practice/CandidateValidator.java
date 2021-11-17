package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate e) {
        return e.getAge() >= 35
                && e.isAllowedToVote()
                && e.getNationality().equals("Ukrainian")
                && (Integer.parseInt(e.getPeriodsInUkr().split("-")[1])
                - Integer.parseInt(e.getPeriodsInUkr().split("-")[0])) >= 10;
    }
}
