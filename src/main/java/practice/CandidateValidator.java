package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate c) {
        return c.getAge() >= 35
                && c.isAllowedToVote()
                && c.getNationality().equals("Ukrainian")
                && (Integer.parseInt(c.getPeriodsInUkr().split("-")[1])
                - Integer.parseInt(c.getPeriodsInUkr().split("-")[0])) >= 10;
    }
}
