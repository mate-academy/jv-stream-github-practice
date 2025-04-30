package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate c) {
        int fromAge = 35;
        return c.getAge() >= fromAge
                && c.isAllowedToVote()
                && c.getNationality().equals("Ukrainian")
                && getYearsInUkraine(c.getPeriodsInUkr()) >= 10;
    }

    private int getYearsInUkraine(String periodsInUkr) {
        String[] period = periodsInUkr.split("-");
        return Integer.parseInt(period[1]) - Integer.parseInt(period[0]);
    }
}
