package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_MIN = 35;
    private static final int PERIOD = 10;

    @Override

    public boolean test(final Candidate candidate) {
        String[] fromToYearsInUkraine = candidate.getPeriodsInUkr().split("-");
        int periodInUkraine = Integer.parseInt(fromToYearsInUkraine[1])
                - Integer.parseInt(fromToYearsInUkraine[0]);
        return candidate.getAge() >= AGE_MIN
                && candidate.getNationality().equals("Ukrainian")
                && candidate.isAllowedToVote()
                && periodInUkraine >= PERIOD;
    }
}
