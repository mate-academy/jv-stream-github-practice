package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE = 35;
    private static final int MINIMUM_PERIOD = 10;
    private static final int START_OF_PERIOD_INDEX = 0;
    private static final int END_OF_PERIOD_INDEX = 1;
    private static final String PERIOD_SEPARATOR = "-";
    private static final String NATIONALITY = "Ukrainian";

    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MINIMUM_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && checkPeriods(candidate);
    }

    private boolean checkPeriods(Candidate candidate) {
        return Integer.parseInt(candidate.getPeriodsInUkr()
                .split(PERIOD_SEPARATOR)[END_OF_PERIOD_INDEX])
                - Integer.parseInt(candidate.getPeriodsInUkr()
                .split(PERIOD_SEPARATOR)[START_OF_PERIOD_INDEX]) >= MINIMUM_PERIOD;
    }
}
