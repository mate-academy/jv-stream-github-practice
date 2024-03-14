package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate c) {
        String[] years = c.getPeriodsInUkr().split("-");
        int yearsInUkraine = Integer.parseInt(years[1]) - Integer.parseInt(years[0]);
        return c.getAge() >= 35
                && c.getNationality().equals("Ukrainian")
                && c.isAllowedToVote()
                && yearsInUkraine >= 10;
    }
}
