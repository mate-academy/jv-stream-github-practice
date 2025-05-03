package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int PERIOD_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final String SPLITERATOR = "-";
    private static final int TO_YEAR = 1;
    private static final int FROM_YEAR = 0;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUa = candidate.getPeriodsInUkr().split(SPLITERATOR);
        int amountYears = Integer.parseInt(periodInUa[TO_YEAR])
                - Integer.parseInt(periodInUa[FROM_YEAR]);
        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && amountYears >= PERIOD_IN_UKRAINE;
    }
}
