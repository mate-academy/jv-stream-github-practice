package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMAL_AGE = 35;
    private static final int MINIMAL_PERIOD_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String SPLITERATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodArray = candidate.getPeriodsInUkr().split(SPLITERATOR);
        int actualPeriodInUkraine = Integer.parseInt(periodArray[1])
                - Integer.parseInt(periodArray[0]);
        return candidate.getAge() >= MINIMAL_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && actualPeriodInUkraine >= MINIMAL_PERIOD_IN_UKRAINE;
    }
}
