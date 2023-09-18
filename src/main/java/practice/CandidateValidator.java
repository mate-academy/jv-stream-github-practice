package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate {
    private Predicate<Candidate> predicate = c ->
            Integer.parseInt(c.getPeriodsInUkr().split("-")[1])
            - Integer.parseInt(c.getPeriodsInUkr().split("-")[0]) >= 10 && c.getAge() >= 35
            && c.isAllowedToVote() == true && c.getNationality().equals("Ukrainian");

    public Predicate<Candidate> getPredicate() {
        return predicate;
    }

    @Override
    public boolean test(Object o) {
        return false;
    }
}
