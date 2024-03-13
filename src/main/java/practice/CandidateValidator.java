package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_BARRIER = 35;
    private static final int AGE_LIVED = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String YEAR_REGEX = "-";

    @Override
    public boolean test(Candidate c) {
        int fromYear = Integer.parseInt(c.getPeriodsInUkr().split(YEAR_REGEX)[0]);
        int toYear = Integer.parseInt(c.getPeriodsInUkr().split(YEAR_REGEX)[1]);

        return c.getAge() >= AGE_BARRIER && c.getNationality().equals(NATIONALITY)
                && c.isAllowedToVote()
                && Math.abs(fromYear - toYear) >= AGE_LIVED;
    }
}
