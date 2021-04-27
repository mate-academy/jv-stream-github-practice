package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator<T extends Candidate> implements Predicate<T> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int AGE = 35;
    private static final int YEARS_LIVE_IN_UKRAINE = 10;

    @Override
    public boolean test(T candidate) {
        String[] rangeYearsLivedInUkraine = candidate.getPeriodsInUkr().split("-");
        int livedInUkraine = Integer.parseInt(rangeYearsLivedInUkraine[1])
                - Integer.parseInt(rangeYearsLivedInUkraine[0]);
        return candidate.getAge() >= AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && livedInUkraine >= YEARS_LIVE_IN_UKRAINE;
    }
}
