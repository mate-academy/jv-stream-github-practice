package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate c) {
        int yearFrom = Integer.parseInt(c.getPeriodsInUkr().split("-")[0]);
        int yearTo = Integer.parseInt(c.getPeriodsInUkr().split("-")[1]);
        int yearsDiff = yearTo - yearFrom;

        return c.getAge() >= 35 && c.isAllowedToVote() && c.getNationality().equals("Ukrainian")
                && yearsDiff >= 10;
    }
}
