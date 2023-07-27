package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMAL_AGE = 35;
    private static final int MINIMAL_YEARS_IN_UKRAINE = 10;
    private static final String DIVIDER = "-";
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodsInUkraine = candidate.getPeriodsInUkr().split(DIVIDER);
        int yearsSpentInUkraine = Integer.parseInt(periodsInUkraine[1])
                - Integer.parseInt(periodsInUkraine[0]);
        return candidate.getAge() >= MINIMAL_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && yearsSpentInUkraine >= MINIMAL_YEARS_IN_UKRAINE;

    }
}
