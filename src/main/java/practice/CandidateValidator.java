package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int PERIOD_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUa = candidate.getPeriodsInUkr().split("-");
        int amountYears = Integer.parseInt(periodInUa[1]) - Integer.parseInt(periodInUa[0]);
        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && amountYears >= PERIOD_IN_UKRAINE;
    }
}
