package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_PRESIDENT_AGE = 35;
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final String ALLOWED_NATIONALITY = "Ukrainian";
    private static final String PERIOD_SEPARATOR = "-";
    private static final int START_PERIOD_INDEX = 0;
    private static final int END_PERIOD_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null) {
            return false;
        }
        String[] stringPeriod = candidate.getPeriodsInUkr().split(PERIOD_SEPARATOR);
        int intPeriod = Integer.parseInt(
                stringPeriod[END_PERIOD_INDEX]) - Integer.parseInt(stringPeriod[START_PERIOD_INDEX]
        );
        return candidate.getAge() >= MIN_PRESIDENT_AGE
                && candidate.getNationality().equals(ALLOWED_NATIONALITY)
                && candidate.isAllowedToVote()
                && intPeriod >= MIN_PERIOD_IN_UKRAINE;
    }
}
