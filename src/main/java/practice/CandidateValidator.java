package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String ALLOWED_NATIONALITY = "Ukrainian";
    private static final String PERIOD_SEPARATOR = "-";
    private static final int INDEX_PERIOD_FROM = 0;
    private static final int INDEX_PERIOD_TO = 1;
    private static final int MIN_ALLOWED_AGE = 35;
    private static final int MIN_ALLOWED_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_ALLOWED_AGE
                && candidate.getNationality().equals(ALLOWED_NATIONALITY)
                && checkPeriod(candidate);
    }

    private boolean checkPeriod(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split(PERIOD_SEPARATOR);
        return Integer.parseInt(period[INDEX_PERIOD_TO])
                - Integer.parseInt(period[INDEX_PERIOD_FROM]) >= MIN_ALLOWED_PERIOD;
    }
}
