package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate c) {
        int fromYear = Integer.parseInt(c.getPeriodsInUkr().split("-")[0]);
        int toYear = Integer.parseInt(c.getPeriodsInUkr().split("-")[1]);

        return c.getAge() >= 35 && c.getNationality().equals("Ukrainian")
                && c.isAllowedToVote()
                && Math.abs(fromYear - toYear) >= 10;
    }
}
