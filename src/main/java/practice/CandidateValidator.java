package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate t) {
        String[] s = t.getPeriodsInUkr().split("-");
        int yearsInUkraine = Integer.parseInt(s[1]) - Integer.parseInt(s[0]);
        return t.getAge() >= 35
                && t.getNationality().equals("Ukrainian")
                && t.isAllowedToVote() && yearsInUkraine >= 10;
    }
}
