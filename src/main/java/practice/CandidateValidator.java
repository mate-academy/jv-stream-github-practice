package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE = 35;
    private static final int YEARS_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split("-");
        int startPeriod = Integer.parseInt(periods[0]);
        int endPeriod = Integer.parseInt(periods[1]);
        return candidate.getAge() >= AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && endPeriod - startPeriod >= YEARS_IN_UKRAINE;
    }
}
