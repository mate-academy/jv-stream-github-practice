package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMAL_AGE = 35;
    private static final int MINIMAL_YEARS_IN_UKRAINE = 10;
    private static final int START_OF_PERIOD = 0;
    private static final int END_OF_PERIOD = 1;
    private static final String NATIONALITY = "Ukrainian";
    private static final String DELIMITER = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodsInUkraine = candidate.getPeriodsInUkr().split(DELIMITER);
        int yearsInPeriodInUkraine = Integer.parseInt(periodsInUkraine[END_OF_PERIOD])
                - Integer.parseInt(periodsInUkraine[START_OF_PERIOD]);

        return candidate.getAge() >= MINIMAL_AGE
                && yearsInPeriodInUkraine >= MINIMAL_YEARS_IN_UKRAINE
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote();
    }
}
