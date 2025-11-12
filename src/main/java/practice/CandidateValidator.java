package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int AGE = 35;
    private static final int REQ_YEARS_IN_UKRAINE = 10;
    private static final int ONE = 1;
    private static final int ZERO = 0;

    @Override
    public boolean test(Candidate candidate) {
        String[] splitted = candidate.getPeriodsInUkr().split("-");
        int periodsInUkraine = Integer.parseInt(splitted[ONE])
                - Integer.parseInt(splitted[ZERO]);
        return candidate.getNationality().equals(NATIONALITY)
                && candidate.getAge() >= AGE
                && periodsInUkraine >= REQ_YEARS_IN_UKRAINE
                && candidate.isAllowedToVote();
    }
}
