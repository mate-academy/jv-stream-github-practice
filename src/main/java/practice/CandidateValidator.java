package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_PRESIDENT_AGE = 35;
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final String ALLOWED_NATIONALITY = "Ukrainian";
    private static final String PERIOD_SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null) {
            return false;
        }
        if (candidate.getAge() < MIN_PRESIDENT_AGE) {
            return false;
        }
        if (!candidate.getNationality().equals(ALLOWED_NATIONALITY)) {
            return false;
        }
        if (!candidate.isAllowedToVote()) {
            return false;
        }
        String[] stringPeriod = candidate.getPeriodsInUkr().split(PERIOD_SEPARATOR);
        int intPeriod = Integer.parseInt(stringPeriod[1]) - Integer.parseInt(stringPeriod[0]);
        return intPeriod >= MIN_PERIOD_IN_UKRAINE;
    }
}
