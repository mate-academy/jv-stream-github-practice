package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int REQUIRED_MIN_PERIOD_IN_COUNTRY = 10;
    private static final int PERIOD_FROM_INDEX = 0;
    private static final int PERIOD_TO_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] splitPeriod = candidate.getPeriodsInUkr().split("-");
        int period = Integer.parseInt(splitPeriod[PERIOD_TO_INDEX])
                - Integer.parseInt(splitPeriod[PERIOD_FROM_INDEX]);
        return candidate.getAge() >= REQUIRED_MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && period >= REQUIRED_MIN_PERIOD_IN_COUNTRY;
    }
}
